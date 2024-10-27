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
## 세부사항  
단계  
어떤 문제를 어떻게 풀었는지 소개 (단계별 요구사항에 대한 해결내용)  
## 트러블 슈팅(적어도 2개)  
1. 문제를 직면
2. 그에 대한 고민
3. 해결방안 모색
4. 해결
5. 그에 대한 감상? 후기?
