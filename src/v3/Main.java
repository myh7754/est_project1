package v3;

import v3.account.AccountRepository;
import v3.account.AccountService;
import v3.account.Session;
import v3.board.BoardRepository;
import v3.board.BoardService;
import v3.post.PostRepository;
import v3.post.PostService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BoardRepository boardRepository = new BoardRepository();
        PostRepository postRepository = new PostRepository();
        AccountRepository accountRepository = new AccountRepository();

        Session session = new Session();

        BoardService boardService = new BoardService(boardRepository, postRepository,session);
        PostService postService = new PostService(postRepository,session);
        AccountService accountService = new AccountService(accountRepository,session);



        Request request = new Request();

        String url;
        String category;
        String method;

        while (true) {
            try {
                String login = session.getLoginUser(); // admin, member, guest
                System.out.print(login + "> ");
                url = sc.nextLine();
                request.urlParse(url);
                category = request.getCategory();
                method = request.getAction();
                System.out.println(category + " " + method);
                Long accountId = session.getAccountId();
                switch (category) {
                    case "boards" -> {
                        switch (method) {
                            case "add":
                                boardService.add();
                                break;
                            case "edit":
                                //display
                                System.out.print("수정할 board 번호 : ");
                                long boardId = Long.parseLong(sc.nextLine());
                                boardService.edit(boardId);
                                break;
                            case "remove":
                                System.out.print("삭제할 board 번호 : ");
                                boardId = Long.parseLong(sc.nextLine());
                                boardService.remove(boardId);
                                break;
                            case "view":
                                System.out.print("어떤 게시판을 조회하겠습니까? : ");
                                String boardName = sc.nextLine();
                                boardService.view(boardName);
                                break;
                            case "list":
                                boardService.list();
                                break;
                            default:
                                System.out.println("올바른 boards 명령어가 아닙니다.");
                                break;
                        }
                    }
                    case "posts" -> {
                        switch (method) {
                            case "add":
                                //display
                                System.out.print("게시판 선택 변호 :");
                                long boardId = Long.parseLong(sc.nextLine());
                                postService.add(boardId);
                                break;
                            case "edit":
                                System.out.print("수정할 post 번호 : ");
                                long postId = Long.parseLong(sc.nextLine());
                                postService.edit(postId);
                                break;
                            case "remove":
                                System.out.print("삭제할 post 번호 : ");
                                postId = Long.parseLong(sc.nextLine());
                                postService.remove(postId);
                                break;
                            case "view":
                                //display
                                System.out.print("어떤 게시물을 조회하겠습니까? : ");
                                postId = Long.parseLong(sc.nextLine());
                                postService.view(postId);
                                break;
                            default:
                                System.out.println("올바른 posts 명령어가 아닙니다.");
                                break;
                        }
                    }
                    case "accounts" -> {
                        switch (method) {
                            case "signup":
                                accountService.singup();
                                break;
                            case "signin":
                                accountService.signIn();
                                break;
                            case "signout":
                                accountService.signOut();
                                break;
                            case "edit":
                                accountService.edit(accountId);
                                break;
                            case "remove":
                                accountService.remove(accountId);
                                break;
                            case "detail":
                                accountService.detail(accountId);
                                break;
                            default:
                                System.out.println("올바른 account 명령어가 아닙니다.");
                                break;
                        }
                    }
                    default -> {
                        System.out.println("잘못된 입력입니다. 명령어는 /boards , /posts, /accounts 중 하나를 입력해주세요");
                        break;
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException("잘못된 URL 형식입니다. URL은 '/구분/기능?파라미터'로 시작해야 합니다. (파라미터 생략가능)");
            }

        }
    }
}
