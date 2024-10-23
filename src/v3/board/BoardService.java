package v3.board;

import v3.account.Session;
import v3.post.Post;
import v3.post.PostRepository;

import java.util.Scanner;

public class BoardService {
    private BoardRepository boardRepository;
    private PostRepository postRepository;

    public BoardService(BoardRepository boardRepository, PostRepository postRepository, Session session) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }

    Scanner scanner = new Scanner(System.in);
    String boardName;

    public void add() {
        System.out.println("Board.add를 호출합니다.");
        System.out.print("board 제목 : ");
        boardName = scanner.nextLine();// 제목설정
        Board board = new Board(boardName);
        boardRepository.save(board);
    }

    public void edit(long boardId) {
        System.out.println("Board.edit을 호출합니다.");
        System.out.print("수정할 board 제목 : ");
        boardName = scanner.nextLine();
        Board board = boardRepository.findById(boardId);
        board.setBoardName(boardName);
    }

    public void remove(long boardId) {
        System.out.println("Board.remove을 호출합니다.");
        boardRepository.deleteById(boardId);
    }

    public void view(String boardName) {
        Board board = boardRepository.findByName(boardName);
        if (board == null) {
            System.out.println("board 생성된 게시판이 없습니다.");
        } else {
            long boardId;
            boardId = board.getBoardId();
            System.out.println("글 번호 / 글 제목 / 작성일");
            for (Post post : postRepository.posts.values()) {
                if (post.getBoardId().equals(boardId)) {
                    System.out.println(post.getPostId()+"/"+post.getTitle()+"/"+post.getCreatedAt());
                }
            }
        }
    }

    ///////// 추가 메서드
    public void list() {
        System.out.println("번호/이름/ 게시판에 글 작성여부(나중에구현)");
        for (Board board : boardRepository.boards.values()) {
            System.out.println(board.getBoardId() + "/게시판 이름 :" + board.getBoardName());
        }
    }
}
