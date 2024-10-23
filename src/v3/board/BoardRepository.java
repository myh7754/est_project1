package v3.board;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BoardRepository {
    public Map<Long, Board> boards = new HashMap<>();

    public void save(Board board) {
        this.boards.put(board.getBoardId(), board);
    }

    public Board findById(long boardId) {
        return boards.get(boardId);
    }
    public Board findByName(String boardName) {
        for (Board board : boards.values()) {
            if ((board.getBoardName()).equals(boardName)) {
                System.out.println("board같음실행");
                return board;
            }
        }
        return null;
    }
    public void deleteById(long boardId) {
        boards.remove(boardId);
    }

}
