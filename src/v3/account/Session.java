package v3.account;

public class Session {
    private boolean loginState;
    private long accountId;
    private String loginUser;

    public String getLoginUser() {
        return loginUser;
    }
    public void setLoginUser(String login) {
        this.loginUser = login;
    }

    public Session() {
        this.loginState = false;
        this.loginUser = "guest";
    }

    public long getAccountId() {
        return accountId;
    }

    public void display(String loginUser) {
        System.out.print(loginUser + "> ");
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
        this.loginUser = "guest";
    }
    public void setLoginState(boolean loginState,Account account) {
        if (loginState) {
            this.loginState = true;
            if(account.getGrade().equals("member")) {
                this.loginUser = "member";
                this.accountId = account.getAccountId();
            } else {
                this.loginUser = "admin";
                this.accountId = account.getAccountId();
            }
        } else {
            this.loginState = false;
            this.loginUser = "guest";
        }
    }

    public boolean isLoginState() {
        return loginState;
    }

}
