package v2.post;

import v2.board.Board;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {

    public Map<Long, Post> posts = new HashMap<>();
    public void save(Post post) {
        posts.put(post.getPostId(), post);
    }
}
