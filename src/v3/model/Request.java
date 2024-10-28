package v3.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Request {
    private String[] parse;
    //    private String[] section;
    private String url;
    private String path; //경로
    private String query; // query
    private String category; // boars/posts/accounts
    private String action; // method
    private final Map<String, String> param;
    //    private String fragment; 프래그먼트 나중에 구현가능
    private final Session session;
    private String role;
    private boolean author;


    public Request(String url, Session session) throws Exception {
        this.url = url;
        this.session = session;
        this.param = new HashMap<>();
        urlParse(url);
    }

    public Session getSession() {
        return session;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public String getCategory() throws Exception {
//        if (Objects.equals(category, "accounts") || Objects.equals(category, "posts") || Objects.equals(category, "boards")) {
            return category;
//        } else {
//            throw new Exception("잘못된 카테고리를 입력 했습니다.");
//        }
    }

    public String getAction() throws Exception {
        if (action != null && !action.isEmpty()) {
            return action;
        } else {
            throw new Exception("잘못된 명령어입니다.");
        }
    }

    public String getQuery() {
        return query;
    }

    public String[] getParse() {
        return parse;
    }



    public void urlParse(String url) throws Exception {
//        System.out.println("urlParse호출");
//        if (!url.startsWith("/")) {
//            throw new Exception("잘못된 URL 형식입니다. URL은 '/'로 시작해야 합니다.");
//        }
        parse = url.split("\\?");

        if (parse.length > 1) {
            this.path = parse[0];
            this.query = parse[1];

            pathParse(path);
            // query가 null이거나 비어 있는 경우 예외 처리
            if (this.query != null && !this.query.isEmpty()) {
                queryParse(query);
            } else {
                System.out.println("쿼리 문자열이 비어 있습니다.");
            }
        } else if (parse.length == 1) {
            this.path = parse[0];
            pathParse(path);
        }

    }

    private void pathParse(String path) throws Exception {
        parse = path.split("/");
        this.category = parse[parse.length - 2];
        this.action = parse[parse.length - 1];
    }

    public void queryParse(String query) throws Exception {
//        System.out.println("queryParse호출");
        parse = query.split("&"); // a=10 , b="안녕" #피그먼트까지 나눈다면 여기서 parse
        for (String s : parse) {
            parse = s.split("=");
            this.param.put(parse[0], parse[1]);
        }
    }
}
