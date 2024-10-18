package v2.post;


import v2.board.Board;

import java.util.Scanner;

public class PostMethod {
    private String postTitle;
    private String postContent;
    Scanner scanner = new Scanner(System.in);
    PostRepository postRepository = new PostRepository();

    public void add(Long boardId) {
        System.out.println("Post.add를 호출합니다.");
        System.out.print("post 제목 : ");
        postTitle = scanner.nextLine();// 제목설정
        System.out.print("post 내용 : ");
        postContent = scanner.nextLine();// 제목설정
        Post post = new Post(postTitle, postContent);
        postRepository.save(post);
    }

    public void remove() {
        System.out.println("Post.remove를 호출합니다.");
        System.out.print("삭제할 post 번호 : ");
        Long postId = Long.parseLong(scanner.nextLine());
        postRepository.posts.remove(postId);

    }
    public void edit() {
        System.out.println("Post.edit를 호출합니다.");
        System.out.print("수정할 post 번호 : ");
        long postId = Long.parseLong(scanner.nextLine());
        System.out.print("수정할 post 제목 : ");
        postTitle = scanner.nextLine();
        System.out.print("수정할 post 내용 : ");
        postContent= scanner.nextLine();

        postRepository.posts.get(postId).setTitle(postTitle);
        postRepository.posts.get(postId).setContent(postContent);

    }
    public void view() {
        System.out.println("Post.view를 호출합니다.");
        System.out.print("어떤 게시물을 조회하겠습니까? : ");
        long postId = Long.parseLong(scanner.nextLine());
        System.out.println(postId + "번 게시글");
        System.out.println(postRepository.posts.get(postId).getTitle());
        System.out.println(postRepository.posts.get(postId).getContent());

    }
}
