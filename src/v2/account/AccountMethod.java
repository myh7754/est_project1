package v2.account;

import java.util.Scanner;

public class AccountMethod {
    AccountRepository accountRepository = new AccountRepository();
    Scanner scanner = new Scanner(System.in);

    public void singup() {
        System.out.println("Account.signup을 호출합니다");
        System.out.print("회원 가입할 아이디를 입력하세요 :");
        String memberid = scanner.nextLine();
        System.out.println("회원 가입할 비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();
        System.out.println("회원 가입할 이름를 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.println("회원 가입할 이메일를 입력하세요 : ");
        String email = scanner.nextLine();

        Member member = new Member(memberid, password, name, email);
        accountRepository.save(member);
    }
    public void signin() {
        System.out.println("Account.signin 을 호출합니다.");
        System.out.println("로그인 아이디를 입력하세요 : ");
        String memberid = scanner.nextLine();
        System.out.println("로그인 비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();

        accountRepository.loginEnable(memberid, password);

    }
    public void signout() {
        System.out.println("Account.signout을 호출합니다.");
        // 로그인 상태 확인
        // 로그인 상태라면 로그아웃 상태로 변경
        // 로그인 상태가 아닌데 로그아웃 시도시 오류처리
    }
    public void detail(String 로그인여부확인) {
        System.out.println("Account.detail을 호출합니다.");
        // 로그인 상태확인 -> 참이라면 가입 번호 반환
        long id = 3L; // 반환된 가입 번호
        System.out.println( id + "번 회원" );
        // 현재 로그인 되어있는 회원 정보 반환
    }
    public void edit(String 로그인여부확인) {
        System.out.println("Account.edit을 호출합니다.");
        // 로그인 상태 확인
        // 현재 로그인 되어 있는 정보 수정
    }

    public void remove(String 로그인여부확인) {
        System.out.println("Account.remove을 호출합니다.");
        // 로그인 상태 확인
        // 현재 로그인 되어 있는 정보 삭제
    }
}
