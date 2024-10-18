package v2;

import v2.board.BoardMethod;
import v2.board.Board;
import v2.post.Post;
import v2.post.PostMethod;

public class test {
    public static void main(String[] args) {
        PostMethod PostMethod = new PostMethod();
        BoardMethod boardMethod = new BoardMethod();



        for (long i = 0; i < 3; i++) {
            PostMethod.add(3L);
        }
        PostMethod.edit();
        PostMethod.view();
        PostMethod.view();
        PostMethod.view();

    }
}
