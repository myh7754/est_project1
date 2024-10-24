package v3;

import v3.account.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String[] parse;
//    private String[] section;
    private String url;
    private String path; //경로
    private String query; // query
    private String category; // boars/posts/accounts
    private String action; // method
    private final Map<String , String> param = new HashMap<>();
//    private String fragment; 프래그먼트 나중에 구현가능
    private final Session session;
    private String role;
    private boolean author;



    public Session getSession() {
        return session;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }

    public String getQuery() {
        return query;
    }

    public String[] getParse() {
        return parse;
    }


    public Request(String url, Session session) throws Exception {
        this.url = url;
        this.session = session;
        urlParse(url);
    }



    public void urlParse(String url) throws Exception {
        System.out.println("urlParse호출");
        parse = url.split("\\?");
        if (parse.length > 1) {
            this.path = parse[0];
            this.query = parse[1];

            pathParse(path);
            queryParse(query); //여기서 query가 null이면 오류발생
        } else if (parse.length == 1) {
            this.path = parse[0];
            pathParse(path);
        } else { // 오류 발생
            throw new Exception("잘못된 URL 형식입니다. URL은 '/'로 시작해야 한다.");
        }
    }
    private void pathParse(String path) throws Exception {
        parse = path.split("/");
        this.category = parse[parse.length - 2];
        this.action = parse[parse.length-1];
    }

    public void queryParse(String query) throws Exception {
        System.out.println("queryParse호출");

        parse = query.split("&"); // a=10 , b="안녕" #피그먼트까지 나눈다면 여기서 parse
        for (String s : parse) {
            parse = s.split("=");
            this.param.put(parse[0], parse[1]);
        }
    }

    public void response() {

    }

}
