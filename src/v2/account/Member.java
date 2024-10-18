package v2.account;

public class Member {
    private Long id;
    private static Long memberIdCounter = 0L;
    private String name;
    private String memberId; // 중복검사
    private String password;
    private String email; // 이메일 형식에 맞지 않으면 오류 발생시켜야함
    private String Grade;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Member(String name, String memberId, String password, String email) {
        this.id = ++memberIdCounter;
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getMemberIdCounter() {
        return memberIdCounter;
    }

    public static void setMemberIdCounter(Long memberIdCounter) {
        Member.memberIdCounter = memberIdCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }


}
