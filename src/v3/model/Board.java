package v3.model;

import java.util.Map;

public class Board {
    private String boardName;
    private final Long boardId;
    private static Long boardIdCounter = 0L;
    public Map<Long, Post> posts;

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
