package v3.service;

import v3.model.Session;
import v3.model.Account;
import v3.repository.AccountRepository;

import java.util.Objects;
import java.util.Scanner;

public class AccountService {
    private final AccountRepository accountRepository;
    private Session loginSession;
    Scanner scanner = new Scanner(System.in);

    public AccountService(AccountRepository accountRepository, Session loginSession) {
        this.accountRepository = accountRepository;
        this.loginSession = loginSession;
    }

    public void singup() {
//        System.out.println("Account.signup을 호출합니다");
        System.out.print("회원 가입할 아이디를 입력하세요 :");
        String id = scanner.nextLine();
        if (accountRepository.findByIdMember(id) != null) { // 중복검사
            System.out.println("중복된 아이디 입니다.");
            return;
        }
        System.out.print("회원 가입할 비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();
        System.out.print("회원 가입할 이름를 입력하세요 : "); // 중복검사 나중에 구현
        String name = scanner.nextLine();
        System.out.print("회원 가입할 이메일을 입력하세요 :");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) { // 이메일 형식 검사
            System.out.println("잘못된 이메일 형식입니다.");
            return;
        }

        Account account = new Account(id, password, name, email);
        accountRepository.save(account);


    }

    public void signIn() {
        if (!loginSession.isLoginState()) {
//            System.out.println("Account.signin 을 호출합니다.");
            System.out.print("로그인 아이디를 입력하세요 : ");
            String memberId = scanner.nextLine();
            System.out.print("로그인 비밀번호를 입력하세요 : ");
            String password = scanner.nextLine();
            accountRepository.login(memberId, password, loginSession);
        } else { // 예외처리
            System.out.println("이미 로그인되어 있습니다.");
        }
    }

    public void signOut() {
        // 현재 로그인 상태라면 현재 계정을 로그아웃
        if (loginSession.isLoginState()) {
            loginSession.setLoginState(false);
        } else { //오류발생
            System.out.println("로그인 되어있지 않습니다.");
        }
    }

    public void detail(Long accountId) {
//        System.out.println("Account.detail을 호출합니다.");
        // 현재 로그인 상태확인 on이라면 해당 계정의 정보 조회
        Account account = accountRepository.findByIdMember(accountId);
        System.out.println("[" + account.getAccountId() + "]" + "번 회원");
        System.out.println("계정 : " + account.getId());
        System.out.println("이름 : " + account.getAccountName());
        System.out.println("이메일 : " + account.getEmail());
        System.out.println("가입일 : " + account.getCreatedAt());

    }

    public void edit(Long accountId) {
        //현재 로그인 상태확인 on이라면 해당 계정의 정보 조회
//        System.out.println("Account.edit 호출합니다.");
        Account account = accountRepository.findByIdMember(accountId);
        System.out.print("이메일 변경: ");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) { // 이메일 형식 검사
            System.out.println("잘못된 이메일 형식입니다.");
            return;
        } else {
            account.setEmail(email);
        }
        System.out.print("비밀번호 변경 :");
        account.setPassword(scanner.nextLine());
    }

    public void remove(long accountId) {
//        System.out.println("Account.remove 호출합니다.");
        accountRepository.accounts.remove(accountId);
        System.out.println("계정이 삭제되었습니다. 로그아웃 합니다.");
        signOut();
    }

    // 이메일 형식 검사를 위한 메서드
    private boolean isValidEmail(String email) {
        // 이메일 형식 정규 표현식
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(emailRegex);
    }
}
