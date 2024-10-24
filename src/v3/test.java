package v3;

import v3.account.AccountRepository;
import v3.account.AccountService;
import v3.account.Session;
import v3.board.BoardRepository;
import v3.board.BoardService;
import v3.post.PostRepository;
import v3.post.PostService;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        BoardRepository boardRepository = new BoardRepository();
        PostRepository postRepository = new PostRepository();
        AccountRepository accountRepository = new AccountRepository();

        String url = "boards/add?a=d";
        Session session = new Session();

        BoardService boardService = new BoardService(boardRepository, postRepository,session);
        PostService postService = new PostService(postRepository,session);
        AccountService accountService = new AccountService(accountRepository,session);

        Request req = new Request(url, session);
        Filter filter = new Filter(req,accountService);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String login = session.getLoginUser(); // admin, member, guest
            System.out.print(login + "> ");
            url = sc.nextLine();
            Request request = new Request(url,session);
            Response response = new Response(request, boardService,postService,accountService);


        }
    }
}

