package v3;

import v3.model.Container;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {

        Container container = new Container();
        Scanner sc = new Scanner(System.in);
        String url;
        while (true) {
            String login = container.getSession().getLoginUser(); // admin, member, guest
            System.out.print(login + "> ");
            url = sc.nextLine();
            try {
                if (!url.startsWith("/")) {
                    throw new Exception("잘못된 URL 형식입니다. URL은 '/'로 시작해야 합니다.");
                }
                container.ReqRes(url); // URL 처리
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}

