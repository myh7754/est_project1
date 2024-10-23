package v3;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String[] parse;
    private String[] section;
    private String path;
    private String query;
    private String category;
    private String action;
    private Map<String , String> param = new HashMap<>();

    public void urlParse(String url) throws Exception {
        System.out.println("urlParse호출");
        parse = url.split("\\?");
        if (parse.length > 1) { // 만약 쿼리가 들어온다면
            query = parse[1];
            path = parse[0];

            pathParse(path);
            queryParse(query);
        } else if (parse.length == 1) { // 쿼리없이 path만 들어온다면
            this.path = parse[0];
            pathParse(path);
        } else {
            throw new Exception("잘못된 URL 형식입니다. URL은 '/'로 시작해야 합니다.");
        }
    }

    private void pathParse(String path) {
        System.out.println("pathParse호출");
        parse = path.split("/");
        this.category = parse[1];
        this.action = parse[2];
    }

    private void queryParse(String query) {
        System.out.println("queryParse호출");
        parse = query.split("&"); // a=10 , b="안녕"
        for (String s : parse) {
            section = s.split("=");
            this.param.put(section[0], section[1]);
        }


    }
    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }
    public Map<String, String> getParam() {
        return param;
    }

}
