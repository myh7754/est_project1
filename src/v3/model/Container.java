package v3.model;

import v3.repository.AccountRepository;
import v3.service.AccountService;
import v3.repository.BoardRepository;

import v3.service.BoardService;
import v3.repository.PostRepository;
import v3.service.PostService;

public class Container {
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    private final Session session;

    private final BoardService boardService;
    private final PostService postService;
    private final AccountService accountService;



    public Container() throws Exception {
        this.boardRepository = new BoardRepository();
        this.postRepository = new PostRepository();
        this.accountRepository = new AccountRepository();
        this.session = new Session();
        this.boardService = new BoardService(boardRepository,postRepository,session);
        this.postService = new PostService(postRepository,session);
        this.accountService = new AccountService(accountRepository,session);
    }

    public void ReqRes(String url) throws Exception {
        Request request = new Request(url,getSession());
        Response response = new Response(request,getBoardService(),getPostService(),getAccountService(),getBoardRepository());
    }

    public BoardService getBoardService() {
        return boardService;
    }

    public PostService getPostService() {
        return postService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public Session getSession() {
        return session;
    }

    public BoardRepository getBoardRepository() {
        return boardRepository;
    }
}
