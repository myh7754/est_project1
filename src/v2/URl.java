package v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class URl {
    private String[] parse;
    private String[] section;
    private String path;
    private String query;
    private String category;
    private String action;
    private Map<String , String> param = new HashMap<>();

    public void router(String url) throws Exception {

    }

    public void urlParse(String url) throws Exception {
        System.out.println("urlParse호출");
        parse = url.split("\\?");
        if (parse.length > 1) {
            query = parse[1];
            path = parse[0];

            pathParse(path);
            queryParse(query);
        } else if (parse.length == 1) {
            path = parse[0];
            pathParse(path);
        } else {
            throw new Exception("잘못된 URL 형식입니다. URL은 '/'로 시작해야 합니다.");
        }
    }

    private void pathParse(String path) {
        System.out.println("pathParse호출");
        parse = path.split("/");
        category = parse[1];
        action = parse[2];
    }

    private void queryParse(String query) {
        System.out.println("queryParse호출");
        parse = query.split("&"); // a=10 , b="안녕"
        for (String s : parse) {
            section = s.split("=");
            param.put(section[0], section[1]);
        }

    }

    public static void main(String[] args) throws Exception {

        URl url = new URl();
        url.urlParse("/board/add/?a=10&b=\"안녕\"&a=11");
    }
}
