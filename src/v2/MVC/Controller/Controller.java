//package v2.MVC.Controller;
//
//import v2.MVC.View.View;
//
//import java.util.Scanner;
//
//public class Controller {
//    Scanner sc = new Scanner(System.in);
//    String command;
//
//    public void mainController() {
//        String login;
//        View view = new View();
//        System.out.print("사용자 설정 : ");
//        login = sc.nextLine();
//        view.inputView(login);
//        while(true) {
//            command = sc.nextLine();
//            if (command.equals("종료") || command.equals("exit")) {
//                System.out.println("프로그램이 종료됩니다.");
//                break;
//            }
//            switch (login) {
//                case "unknown":
//                    if (command.equals("1")) {
//                        //회원가입
//                        System.out.println("회원가입 뷰");
//                    }
//                    else if (command.equals("2")) {
//                        //로그인
//                        view.loginView();
//                    }
//                    else {
//                        // 예외
//                        System.out.println("잘못된 입력");
//                    }
//                    break;
//                case "admin":
//                    if (command.equals("1")) {
//                        System.out.println("로그아웃 기능실행");
//                    } else if (command.equals("2")) {
//                        System.out.println("계정관리 뷰");
//                    } else if(command.equals("3")) {
//                        view.methodDisplay("board");
//                    }
//                    break;
//                case "member":
//                    if (command.equals("1")) {
//                        System.out.println("로그아웃");
//                    } else if (command.equals("2")) {
//                        System.out.println("계정관리 뷰");
//                    } else {
//                        System.out.println("게시글 목록");
//                    }
//                    break;
//            }
//
//        }
//    }
//}
