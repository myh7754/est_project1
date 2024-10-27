package v2;

import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        String author = "비회원";// 임시 권한
        String category = "구분"; // 임시
        String method = "기능"; // 임시
        while(true) {
            // 비회원 상태의 글
            System.out.println(author +"님 어서오세요");
            System.out.println("1.회원 가입"); // req(/account/signup
            {

            }
            System.out.println("2.로그인"); // req(/account/signin
            {

            }
            System.out.print("번호 : ");


            // 회원 상태의 글
            author = "관리자";
            // 관리자
            System.out.println((author+"님 어서오세요"));
            System.out.println("1. 로그아웃"); // req(account/signout)
            System.out.println("2. 계정관리"); // 그냥 현재 계정에 한에서 정보 조회, 삭제, 수정해야 할 듯
            {
                category = "계정";
                method = "view";
                System.out.println("1."+ category +method); //req(/account/view)
                method = "edit";
                System.out.println("2."+ category +method); //req(/account/edit)
                method = "remove";
                System.out.println("3."+ category +method); //req(/account/remove)
                System.out.print("번호 : ");
            }
            System.out.println("3. 게시글 관리");
            {
                category = "게시판";
                System.out.println("1." + category + "생성"); // req(/board/add)
                method = "view";
                System.out.println("2." + category + method); // req(board/view)
                method = "edit";
                System.out.println("3." + category + method); // req(board/edit)
                method = "remove";
                System.out.println("4." + category + method); // req(board/remove)
                System.out.print("번호 : ");
            }
            System.out.print("번호 : ");
            // 회원
            author = "회원";
            System.out.println((author+"님 어서오세요"));
            System.out.println("1. 로그아웃"); // req(/account/signout)
            System.out.println("2. 계정관리"); // req(/account/view)
            {
                category = "계정";
                method = "view";
                System.out.println("1."+ category +method); //req(/account/view)
                method = "edit";
                System.out.println("2."+ category +method); //req(/account/edit)
                method = "remove";
                System.out.println("3."+ category +method); //req(/account/remove)
                System.out.print("번호 : ");
            }
            System.out.println("3. 게시글 목록"); // req(/post/view)
            {
                category = "게시판";
                System.out.println("1." + category + "생성"); // req(/post/add)
                method = "view";
                System.out.println("2." + category + method); // req(post/view)
                method = "edit";
                System.out.println("3." + category + method); // req(post/edit)
                method = "remove";
                System.out.println("4." + category + method); // req(post/remove)
                System.out.print("번호 : ");
            }
            // -> 생성되어 있는 게시판 카테고리 선택 ->
            // -> 게시글 목록 표시 ->
            //System.out.print("게시글을 선택하세요 : "); // req(/posts/view)
            System.out.print("번호 : ");






            // 현재 권한에 따라 표시
            System.out.println(author +"님 어서오세요 무엇을 도와드릴까요?");

            // 권한에 따라 회원가입과 로그인
        }

//        Scanner scanner = new Scanner(System.in);
//        String command;
//        Blog blog = new Blog();
//        while(true){;
//            System.out.print("손님 ");
//            command=scanner.nextLine();
//            if (command.equals("종료") || command.equals("exit")) {
//                System.out.println("프로그램이 종료됩니다.");
//                break;
//            }
//
//            switch (command) {
//                case "작성":
//                    blog.create();
//                    break;
//                case "조회":
//                    blog.read();
//                    break;
//                case "삭제":
//                    blog.delete();
//                    break;
//                case "수정":
//                    blog.update();
//                    break;
//                case "목록" :
//                    blog.idx();
//                    break;
//                default:
//                    System.out.println("존재하지 않는 명령어 입니다.");
//                    break;
//
//            }
//        }
//
//
    }
}