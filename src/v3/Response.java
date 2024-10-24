package v3;

import v3.account.AccountService;
import v3.account.Session;
import v3.board.BoardService;
import v3.post.PostService;

import java.util.Map;
import java.util.Scanner;

public class Response {
    private String category;
    private String action;
    private Session session;
    private String role;

    private BoardService boardService;
    private PostService postService;
    private AccountService accountService;
    Scanner sc = new Scanner(System.in);
    private boolean author;
//    private Map<String , String> param;


    public Response(Request req, BoardService boardService, PostService postService, AccountService accountService) {
       this.category = req.getCategory();
       this.action = req.getAction();
       this.session = req.getSession();

       this.boardService = boardService;
       this.postService = postService;
       this.accountService = accountService;

       role = session.getLoginUser();
       this.author = filter(role);
       res();
    }

    public boolean filter(String role) {
        System.out.println("filter호출");
        if (category.equals("accounts") && (action.equals("signup") || action.equals("signin"))) {
            return true;
        }

        if((category.equals("boards") || category.equals("posts")) && (action.equals("view") || action.equals("list"))) {
            return true;
        }

        // 회원이 접근 가능한 URL
        if (role.equals("member")) {
            return switch (category) {
                case "posts" -> action.equals("add") || action.equals("edit") || action.equals("remove");
                case "accounts" -> action.equals("signout") || action.equals("edit") || action.equals("remove");
                default -> false;
            };
        }
        // 관리자가 접근 가능한 URL
        if (role.equals("admin")) {
            return switch (category) {
                case "boards" -> action.equals("add") || action.equals("edit") || action.equals("remove");
                case "posts" -> action.equals("add") || action.equals("edit") || action.equals("remove");
                case "accounts" -> action.equals("signout") || action.equals("edit") || action.equals("remove");
                default -> false;
            };
        }
        // 그 외
        return false;
    }



    public void res() {
        Long accountId = session.getAccountId();
        System.out.println(author);
        if (author) {
            switch (category) {
                case "boards"-> {
                    switch (action) {
                        case "add"-> {
                            boardService.add();
                        }
                        case "edit"-> {
                            System.out.print("수정할 board 번호 : ");
                            long boardId = Long.parseLong(sc.nextLine());
                            boardService.edit(boardId);
                        }
                        //display
                        case "remove"-> {
                            System.out.print("삭제할 board 번호 : ");
                            long boardId = Long.parseLong(sc.nextLine());
                            boardService.remove(boardId);
                        }
                        case "view"-> {
                            System.out.print("어떤 게시판을 조회하겠습니까? : ");
                            String boardName = sc.nextLine();
                            boardService.view(boardName);
                        }
                        case "list"-> {
                            boardService.list();
                        }
                        default-> {
                            System.out.println("올바른 boards 명령어가 아닙니다.");
                        }
                    }
                }
                case "posts"-> {
                    switch (action) {
                        case "add"-> {
                            //display
                            System.out.print("게시판 선택 변호 :");
                            long boardId = Long.parseLong(sc.nextLine());
                            postService.add(boardId);
                        }
                        case "edit"-> {
                            System.out.print("수정할 post 번호 : ");
                            long postId = Long.parseLong(sc.nextLine());
                            postService.edit(postId);
                        }
                        case "remove"-> {
                            System.out.print("삭제할 post 번호 : ");
                            long postId = Long.parseLong(sc.nextLine());
                            postService.remove(postId);
                        }
                        case "view"-> {
                            //display
                            System.out.print("어떤 게시물을 조회하겠습니까? : ");
                            long postId = Long.parseLong(sc.nextLine());
                            postService.view(postId);
                        }
                        default-> {
                            System.out.println("올바른 posts 명령어가 아닙니다.");
                        }
                    }
                }
                case "accounts"->{
                    switch (action) {
                        case "signup"-> {
                            accountService.singup();
                        }
                        case "signin"-> {
                            accountService.signIn();
                        }
                        case "signout"-> {
                            accountService.signOut();
                        }
                        case "edit"-> {
                            accountService.edit(accountId);
                        }
                        case "remove"-> {
                            accountService.remove(accountId);
                        }
                        case "detail"-> {
                            accountService.detail(accountId);
                        }
                        default-> {
                            System.out.println("올바른 account 명령어가 아닙니다.");
                        }
                    }
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        } else {
            System.out.println("권한이 없습니다.");
        }
    }
}