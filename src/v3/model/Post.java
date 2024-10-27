package v3.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private final Long postId;
    private String title;
    private String content;
    private final Long boardId;
    private LocalDateTime createdAt;
    private static Long postIdCounter = 0L;
    private LocalDateTime updatedAt;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Post(String title, String content, Long boardId) {
        System.out.println("post생성자 호출");
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        this.postId = ++postIdCounter;
    }

    public Long getBoardId() {
        return boardId;
    }
    public String getCreatedAt() {return createdAt.format(formatter);}
    public String getUpdatedAt() {
        return updatedAt.format(formatter);
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getPostId() {
        return postId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
