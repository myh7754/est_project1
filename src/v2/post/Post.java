package v2.post;

public class Post {
    private Long postId;
    private String title;
    private String content;
    private static Long postIdCounter = 0L;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.postId = ++postIdCounter;
    }
}
