package v3;

import v3.model.Container;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {

        Container container = new Container();
        Scanner sc = new Scanner(System.in);
        String url;
        while (true) {
            String login = container.getSession().getLoginUser(); // admin, member, guest
            System.out.print(login + "> ");
            url = sc.nextLine();
            container.ReqRes(url);
        }
    }
}

