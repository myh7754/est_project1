package v2.board;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMethod{
    private String boardName;
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

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
        boardRepository.boards.get(boardId).setBoardName(boardName);

    }
    public void remove(Long boardId) {
        System.out.println("Board.remove을 호출합니다.");
        boardRepository.boards.remove(boardId);
    }
    public void view(String boardName) { // 수정해야함 글로
        System.out.println("Board.view을 호출합니다.");
//        System.out.println(boardRepository.boards.get(boardId).getBoardName());
    }
}
