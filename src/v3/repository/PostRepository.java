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


    public Post findByBoardId(Long boardId) {
        System.out.println("findByBoardId 호출");
        System.out.println("현재 posts 내용: " + posts);

        return null;
    }


    public void deleteById(Long postId) {
        posts.remove(postId);
    }
}
