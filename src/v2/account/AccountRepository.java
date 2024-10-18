package v2.account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    public Map<String, Member> accounts = new HashMap<>();
    public void save(Member member) {
        accounts.put(member.getMemberId(), member);
    }

    public void loginEnable(String memberId, String password) {  // 가입된 내역 조회
        if (accounts.containsKey(memberId)) {
            if (accounts.get(memberId).getPassword().equals(password)) {
                System.out.println("로그인 되었습니다");
            } else {
                System.out.println("비밀번호가 다릅니다.");
            }

        } else {
            System.out.println("회원가입 정보가 없습니다. 먼저 회원가입을 해주세요");
        }
    }

    public void findByAll () { // 모든 회원 출력

    }
    public void findById (String memberId) { //

    }
    public void findByPassword (String password) { // password찾기

    }

    public void loginMemberInfo(long id) {

    }

}
