package v3.repository;

import v3.model.Post;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {
    public Map<Long, Post> posts;
    public PostRepository() {
        this.posts = new HashMap<>();
    }

    public void save(Post post) {
        this.posts.put(post.getPostId(), post);
    }

    public Post findByPostId(Long postId) {
        return posts.get(postId);
    }


    public int findByBoardIdCount(Long boardId) {
        int count = 0;
        for (Post post : posts.values()) {
            if (post.getBoardId().equals(boardId)) {
                count++;
            }
        }
        return count;
    }


    public void deleteById(Long postId) {
        posts.remove(postId);
    }
}
