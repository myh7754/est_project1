package v3.account;

import java.util.Scanner;

public class AccountService {
    private final AccountRepository accountRepository;
    private Session loginSession;
    Scanner scanner = new Scanner(System.in);

    public AccountService(AccountRepository accountRepository,Session loginSession) {
        this.accountRepository = accountRepository;
        this.loginSession = loginSession;
    }

    public void singup() {
        System.out.println("Account.signup을 호출합니다");
        System.out.print("회원 가입할 아이디를 입력하세요 :"); // 중복검사 나중에 구현
        String id = scanner.nextLine();
        System.out.print("회원 가입할 비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();
        System.out.print("회원 가입할 이름를 입력하세요 : "); // 중복검사 나중에 구현
        String name = scanner.nextLine();
        System.out.print("회원 가입할 이메일를 입력하세요 : "); // 이메일 형식 검사 나중에 구현
        String email = scanner.nextLine();

        Account account = new Account(id, password, name, email);
        accountRepository.save(account);
    }

    public void signIn() {
        if(!loginSession.isLoginState()) {
            System.out.println("Account.signin 을 호출합니다.");
            System.out.print("로그인 아이디를 입력하세요 : ");
            String memberId = scanner.nextLine();
            System.out.print("로그인 비밀번호를 입력하세요 : ");
            String password = scanner.nextLine();
            accountRepository.login(memberId, password,loginSession);
        } else { // 예외처리
            System.out.println("이미 로그인되어 있습니다.");
        }
    }

    public void signOut() {
        // 현재 로그인 상태라면 현재 계정을 로그아웃
        if(loginSession.isLoginState()) {
            loginSession.setLoginState(false);
        } else { //오류발생
            System.out.println("로그인 되어있지 않습니다.");
        }
    }

    public void detail(Long accountId) {
        System.out.println("Account.detail을 호출합니다.");
        // 현재 로그인 상태확인 on이라면 해당 계정의 정보 조회
        Account account = accountRepository.findByIdMember(accountId);
        System.out.println("["+account.getAccountId()+"]"+"번 회원");
        System.out.println("계정 : " + account.getId());
        System.out.println("이름 : " + account.getAccountName());
        System.out.println("이메일 : "+ account.getEmail());
        System.out.println("가입일 : "+ account.getCreatedAt());
    }

    public void edit(Long accountId) {
        //현재 로그인 상태확인 on이라면 해당 계정의 정보 조회
        System.out.println("Account.edit 호출합니다.");
        Account account = accountRepository.findByIdMember(accountId);
        System.out.print("이메일 변경: ");
        account.setEmail(scanner.nextLine());
        System.out.print("비밀번호 변경 :");
        account.setPassword(scanner.nextLine());
    }

    public void remove(long accountId) {
        System.out.println("Account.remove 호출합니다.");
        accountRepository.accounts.remove(accountId);
        signOut();
    }
}
