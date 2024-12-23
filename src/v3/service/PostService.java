package v3.service;

import v3.model.Session;
import v3.model.Post;
import v3.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PostService {
    private PostRepository postRepository;
    String author;
    Scanner scanner = new Scanner(System.in);

    public PostService(PostRepository postRepository, Session session) {
        this.postRepository = postRepository;
    }


    public void add(Long boardId) {
//        System.out.println("Post.add를 호출합니다.");
        System.out.print("post 제목 : ");
        String title = scanner.nextLine();
        System.out.print("post 내용 : ");
        String content = scanner.nextLine();
        Post post = new Post(title, content, boardId);
        postRepository.save(post);

        // posts가 정상적으로 저장되었는지 확인하는 코드 추가
        System.out.println("게시글이 저장되었습니다.");
    }
    public void remove(Long postId) {
//        System.out.println("Post.remove를 호출합니다.");
        if(postRepository.findByPostId(postId) == null) {
            System.out.println("생성된 게시물이 없습니다");
        } else {
            postRepository.deleteById(postId);
        }
    }
    public void edit(Long postId) {
//        System.out.println("Post.edit를 호출합니다.");
        if(postRepository.findByPostId(postId) == null) {
            System.out.println("생성된 게시물이 없습니다");
        } else {
        System.out.print("수정할 post 제목 : ");
        String postTitle = scanner.nextLine();
        System.out.print("수정할 post 내용 : ");
        String postContent = scanner.nextLine();
        postRepository.posts.get(postId).setTitle(postTitle);
        postRepository.posts.get(postId).setContent(postContent);
        postRepository.posts.get(postId).setUpdatedAt(LocalDateTime.now()); // 수정 시간 업데이트
        }
    }

    public void view(Long postId) {
//        System.out.println("Post.view를 호출합니다.");
        Post post = postRepository.posts.get(postId);
        if(post == null) {
            System.out.println("게시물이 생성되어 있지 않습니다.");
        } else {
            System.out.println("["+post.getPostId()+"]번 게시글");
            System.out.println("작성일 : "+post.getCreatedAt());
            System.out.println("수정일 : "+post.getUpdatedAt());
            System.out.println("게시판  : "+post.getBoardId());
            System.out.println("제목 : "+post.getTitle());
            System.out.println("내용 : "+post.getContent());
        }
    }

    ////////
    public void list() { // 생성되어있는 모든 게시물을 조회
        System.out.println("글 번호/ 글 제목/ 작성일");
        for (Post post : postRepository.posts.values()) {
            if(post == null) {
                System.out.println("생성된 게시글이 없습니다.");
            } else {
                System.out.println(post.getPostId()+"/"+post.getTitle()+"/"+post.getCreatedAt());
            }
        }
    }

}
