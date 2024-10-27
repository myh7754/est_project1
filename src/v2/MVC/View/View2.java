package v2.MVC.View;

import java.util.Objects;
import java.util.Scanner;

public class View2 {
    Scanner sc = new Scanner(System.in);

    // 로그인 화면
    public void loginView() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();
    }

    // 비로그인 사용자 메뉴
    public void unknownView() {
        System.out.println("1.회원 가입"); // req(/account/signup)
        System.out.println("2.로그인");   // req(/account/signin)
    }

    // 관리자 메뉴
    public void adminView() {
        System.out.println("1. 로그아웃"); // req(account/signout)
        System.out.println("2. 계정관리"); // 계정 정보 조회, 삭제, 수정
        System.out.println("3. 게시글 관리");
    }

    // 회원 메뉴
    public void memberView() {
        System.out.println("1. 로그아웃");    // req(/account/signout)
        System.out.println("2. 계정관리");    // req(/account/view)
        System.out.println("3. 게시글 목록"); // req(/post/view)
    }

    ////////////////////////////////

    // 사용자에 따른 메뉴를 출력하는 메서드
    public void display(String author) {
        if (Objects.equals(author, "unknown")) {
            unknownView();
        } else if (Objects.equals(author, "admin")) {
            adminView();
        } else if (Objects.equals(author, "member")) {
            memberView();
        }
    }

    // 입력을 받고 해당하는 상태에 맞는 뷰를 출력하는 메서드
    public void view(String author) {
        display(author);
        String command = stateView(author);
        methodswitch(command, author); // 입력된 숫자와 author에 따라 기능 실행
    }

    // 상태에 따라 프롬프트를 출력하고 입력받는 메서드
    public String stateView(String author) {
        System.out.print(author + "> ");
        return sc.nextLine(); // 숫자를 입력받음
    }

    // 입력된 숫자에 따라 메서드를 실행하는 메서드
    public void methodswitch(String command, String author) {
        switch (command) {
            case "1":
                if (Objects.equals(author, "unknown")) {
                    System.out.println("회원 가입 메서드 실행");
                } else {
                    System.out.println("로그아웃 메서드 실행");
                }
                break;
            case "2":
                if (Objects.equals(author, "unknown")) {
                    System.out.println("로그인 메서드 실행");
                } else {
                    System.out.println("계정 관리 메서드 실행");
                }
                break;
            case "3":
                if (Objects.equals(author, "admin")) {
                    System.out.println("게시글 관리 메서드 실행");
                } else if (Objects.equals(author, "member")) {
                    System.out.println("게시글 목록 보기 메서드 실행");
                }
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
}
