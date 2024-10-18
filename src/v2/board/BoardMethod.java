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

    public void edit() {
        System.out.println("Board.edit을 호출합니다.");
        System.out.print("수정할 board 번호 : ");
        long boardId = Long.parseLong(scanner.nextLine());
        System.out.print("수정할 board 제목 : ");
        boardName = scanner.nextLine();
        boardRepository.boards.get(boardId).setBoardName(boardName);

    }
    public void remove() {
        System.out.println("Board.remove을 호출합니다.");
        System.out.print("삭제할 board 번호 : ");
        long boardId = Long.parseLong(scanner.nextLine());
        boardRepository.boards.remove(boardId);
    }
    public void view() { // 수정해야함 글로
        System.out.println("Board.view을 호출합니다.");
        System.out.print("어떤 게시판을 조회하겠습니까? : ");
        long boardId = Long.parseLong(scanner.nextLine());
        System.out.println(boardRepository.boards.get(boardId).getBoardName());
    }
}
