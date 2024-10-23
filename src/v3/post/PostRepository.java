package v3.post;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {
    public Map<Long, Post> posts = new HashMap<>();

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
//        for (Post post : posts.values()) {
//            System.out.println("너가 문제니?" + post.getBoardId());
//            System.out.println("이건가?"+boardId);
//            if((post.getBoardId()).equals(boardId)) {
//                System.out.println("post같음 실행");
//                return post;
//            }
//        }
//        return null;
    }


    public void deleteById(Long postId) {
        posts.remove(postId);
    }
}
