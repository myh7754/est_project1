# 프로젝트 이름  
프로젝트 소개  
java를 이용해 사용자로 부터 url을 입력 받아 게시물의 기능을 실행하는 게시판 프로젝트
---
명령어에 따른 동작
|  |url | 기능 |권한|
|----------|----------|----------|----------|
| accounts  | /accounts/signup   | 회원가입  | 익명 |
| accounts  | /accounts/signin   | 로그인   | 익명 |
| accounts  | /accounts/signout  | 로그아웃  | 회원  |
| accounts | /accounts/detail  | 로그인된 회원조회  | 회원 |
| accounts | /accounts/edit  | 로그인된 회원정보 수정  | 회원 |
| accounts | /accounts/remove | 로그인된 회원계정 삭제  | 회원 |
| boards | /boards/add  | 게시판 생성  | 관리자 |
| boards | /boards/edit  | 게시판 수정  | 관리자 |
| boards | /boards/remove  | 게시판 삭제  | 관리자 |
| boards | /boards/view  | 게시판의 글 조회  | 익명 |
| boards | /boards/list  | 게시판 목록조회  | 익명 |
| posts | /posts/add  | 게시글 적기  | 회원 |
| posts | /posts/remove  | 게시글 삭제  | 회원 |
| posts | /posts/edit  | 게시글 수정  | 회원 |
| posts | /posts/view  | 게시글 조회  | 익명 |

accounts/signup/아이디 중복검사  
boards/remove/ 게시판 삭제시 해당 게시판에 적혀있는 posts 글들도 모두 삭제  
boards/list/ 생성되어 있는 모든 게시판 출력, 게시판에 작성된 글 수 표시  
---
## 객체 설명
### Session객체
- 현재 로그인 상태를 확인
- 로그인 상태를 이용하여 계정 정보에 담긴 등급에 따라 회원 분류

### Container객체
- 한번만 생성해도 되는 모든 객체의 생성을 담당
- Container객체에서 생성해서 생성자를 주입하여 싱글톤 패턴을 구현할 수 있음

### Request 객체
- url을 받아 parsing하여 /카테고리/기능?param을 담을 수 있도록 분류

### Response 객체
- req를 통해 분류된 카테고리, 기능에 따라 해당 url parse된 결과를 전달받아 분류에 맞는 기능을 호출하여 실행
- filter기능을 통해 전달받은 기능이 회원의 등급에 따라 사용할 수 있는 권한과 없는 권한을 분류

---
## 트러블 슈팅(1)  
1. repository에 객체를 저장하는데 Service안에서 생성하다 보니 저장이 되지 않는 문제가 발생
2. 하나의 인스턴스에서 생성된 repository가 아니라 여러 곳에서 생성해서 사용하려 해서 문제가 발생한 것 
3. 싱글톤 패턴이 이용하여 해결하는 방법을 찾아 싱글톤 패턴이 필요한 이유를 듣는게 아니라 직접 알게되었습니다.
4. main 객체에서 한번만 생성해야하는 객체 예를들어 Repository와 같은 저장소를 하나만 생성하여 객체에 주입하여 하나의 인스턴스를 사용할 수 있도록 변경
5. 싱글톤 패턴이 필요한 이유를 먼저 깨닫고 container 객체를 만들어서 주입하여 사용하여서 그에 대한 이해가 어렵지 않았던 것 같다. 만약 내가 처음부터 이러한 방법을 인지해서 사용했다면 어떻게 객체를 가져와야서 사용해야하지에 대한 고민을 덜어 더욱 빠르게 개발할 수 있었을 것 같다.

## 트러블 슈팅(2)
1. Response에서 Filter기능을 구현하는데 if문 조건이 너무 복잡하게 만들어 항상 true가 발생
2.    if ((category.equals("accounts") && (action.equals("signup") || action.equals("signin"))) ||(category.equals("boards") || category.equals("posts")) && (action.equals("view") || action.equals("list"))) {
            return true;
        }
위 조건식에서 항상 true가 발생한걸 발견한 후 Short-Circuit 때문에 앞 조건이 참이면 뒤에 조건을 무시하고 항상 true가 발생되는 것을 발견
3. 해당 if문을 나눠 Short-circuit이 발생하지 않도록 각각의 조건으로 나눔
4. ```
   if (category.equals("accounts") && (action.equals("signup") || action.equals("signin"))) {
            return true;
        }
        if((category.equals("boards") || category.equals("posts")) && (action.equals("view") || action.equals("list"))) {
            return true;
        }
   ```
   다음과 같이 if문을 끊어서 각각의 조건에 따라 true가 발생되도록 변경
5. if문의 복잡한 조건을 사용할 때는 항상 조심해서 끊어서 사용해야 하는 것을 느끼게 되었습니다.
---
### 느낀점 : 이렇게 객체를 묶어서 구현하면 안된다는걸 알면서도 어떤식으로 쪼개야할지 감이 잘 안왔던 것 같다. 예외처리 또한 나중에 한번에 구현하려고 하니 문제가 많았다... 아쉽게 구현하지 못한 부분도 많고 java를 이용해서 구현하는 여러방식을 고민해볼 수 있는 시간이었다.
