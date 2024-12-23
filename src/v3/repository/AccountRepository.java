package v3.repository;

import v3.model.Session;
import v3.model.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    public Map<Long, Account> accounts = new HashMap<>();

    public void save(Account account) {
        if (account.getId().equals("343")) { // 관리자 계정고정
            account.setGrade("admin");
        }
        this.accounts.put(account.getAccountId(), account);
    }

    public Account findByIdMember(String id) {
        for (Account account : accounts.values()) {
//            System.out.println(account.getId());
//            System.out.println(id);
            if (account.getId().equals(id)) {
                return account;
            } else {
                System.out.println("findbyMember계정을 찾을 수 없습니다.");
            }
        }
        return null;
    }

    public Account findByIdMember(Long accountId) {
        for (Account account : accounts.values()) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            } else {
                System.out.println("findBYMember계정을 찾을 수 없습니다.");
            }
        }
        return null;
    }

    public void login(String id, String password, Session loginSession) {
        Account account = findByIdMember(id);
        if (account == null) {
            System.out.println("계정을 찾을 수 없습니다.");
        } else {
            if (account.getPassword().equals(password)) {
                loginSession.setLoginState(true,account);
                System.out.println("로그인 성공");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

}
