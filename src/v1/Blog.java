package v1;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Blog extends Document{
    ArrayList<Map<String,String>> documents = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void create() {
        HashMap<String,String> gle = new HashMap<>(); // 묶는 글 생성
        System.out.println("작성을 호출합니다.");
        System.out.print("제목 : ");
        setTitle(scanner.nextLine()); // 제목설정
        System.out.print("내용 : ");
        setContent(scanner.nextLine()); // 내용 설정
        gle.put("title",getTitle()); // 제목의 맵핑
        gle.put("content",getContent()); //내용 맵핑
        documents.add(gle);

    }
    public void read() {
        System.out.println("조회를 호출합니다.");
        System.out.print("어떤 게시물을 조회할까요? : ");
        int index = Integer.parseInt(scanner.nextLine());
        int realIdx = index-1;
        try {
            Map<String,String> document = documents.get(realIdx); // {title=제목, content=내용}
            System.out.println("제목 : " + document.get("title"));
            System.out.println("내용 : " + document.get("content"));
        } catch (Exception e) {
            System.out.println(index + "번 게시물은 존재하지 않습니다.");
        }

    }
    public void delete() {
        System.out.println("삭제를 호출합니다.");
        System.out.print("어떤 게시물을 삭제할까요? : ");
        int index = Integer.parseInt(scanner.nextLine());
        int realIdx = index-1;
        try {
            documents.remove(realIdx);
            System.out.println(index + "번 게시물이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            System.out.println(index + "번 게시물은 존재하지 않습니다.");
        }

    }

    public void update() {
        HashMap<String,String> gle = new HashMap<>();
        System.out.println("수정을 호출합니다.");
        System.out.print("어떤 게시물을 수정할까요? : ");
        int index = Integer.parseInt(scanner.nextLine());
        int realIdx = index-1;
        try {
            documents.get(realIdx);
            System.out.println(index + "번 게시물을 수정합니다.");
            System.out.print("제목 : ");
            setTitle(scanner.nextLine()); // 제목설정
            System.out.print("내용 : ");
            setContent(scanner.nextLine()); // 내용 설정
             //내용 맵핑
            gle.put("title",getTitle());
            gle.put("content",getContent());
            documents.set(realIdx,gle);

            System.out.println(index + "번 게시물이 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            System.out.println(index + "번 게시물은 존재하지 않습니다.");
        }
       }

    public void idx() {

        System.out.println("총 게시글은 "+documents.size() +"개 작성되었습니다.");
        System.out.println();
        for (int i = 0; i < documents.size(); i++) {
            Map<String,String> document = documents.get(i); // {title=제목, content=내용}
            System.out.println((i+1)+ "번 게시글");
            System.out.println("제목 : " + document.get("title"));
            System.out.println("내용 : " + document.get("content"));
            System.out.println();
        }

    }
}