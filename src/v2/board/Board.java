package v2.board;

public class Board {
    private String boardName;
    private Long boardId;
    private static Long boardIdCounter = 0L;

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }
    public Long getBoardId() {
        return boardId;
    }

    public Board(String boardName) {
        System.out.println("Board 생성자를 호출합니다.");
        this.boardName = boardName;
        this.boardId = ++boardIdCounter;
    }
}
