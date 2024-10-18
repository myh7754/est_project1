package v2.board;

import java.util.HashMap;
import java.util.Map;

public class BoardRepository {
    public Map<Long, Board> boards = new HashMap<>();
    public void save(Board board) {
        boards.put(board.getBoardId(), board);
    }
}
