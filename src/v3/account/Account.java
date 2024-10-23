package v3.account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private static Long accountCounterId = 0L;
    private final Long accountId;
    private String accountName;
    private String email;
    private String id;
    private String password;
    private LocalDateTime createdAt;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCreatedAt() {
        return createdAt.format(formatter);
    }

    public Account(String id, String password, String accountName, String email) {
        this.accountId = ++accountCounterId;
        this.accountName = accountName;
        this.email = email;
        this.id = id;
        this.password = password;
        this.grade = "member"; // 기본 등급은 member로 시작
    }

    public Long getAccountId() {
        return accountId;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
