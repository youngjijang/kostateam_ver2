package academy.mvc.view;

import java.util.Scanner;

import academy.mvc.controller.BoardController;
import academy.mvc.controller.CartController;
import academy.mvc.controller.CourseController;
import academy.mvc.controller.SugangController;
import academy.mvc.controller.UserController;


public class MenuView {
	static Scanner sc = new Scanner(System.in);
	
	public static void loginMenu() throws NumberFormatException{
		
		String userId;
		int userPwd;
		String kind;
		String userName;
		String userTel;
		String major;
		
		while(true){
			System.out.println("**************Academy Program 시작합니다**************");
			System.out.println("1.로그인 | 2.회원가입 | 9.프로그램 종료");
			int menuNo = Integer.parseInt(sc.nextLine());
			
			
			switch(menuNo){
			
			case 1 : 
				System.out.println("사용자 유형을 입력하세요.");
				System.out.print("학생계정-1  강사계정-2  매니저계정-3 > ");
				kind = sc.nextLine();
				
				System.out.print("아이디> ");
				userId = sc.nextLine();
				System.out.print("비밀번호> ");
				userPwd = Integer.parseInt(sc.nextLine());
			
				if(kind.equals("1")) {
					kind = "student";
					UserController.userLogin(userId, userPwd, kind);
					//다음 메뉴 선택하러 이동
					homeMenu(userId, kind);
				}else if(kind.equals("2")) {
					kind = "teacher";
					UserController.userLogin(userId, userPwd, kind);
				}else if(kind.equals("3")) {
					kind = "manager";
					UserController.userLogin(userId, userPwd, kind);
				}
				else {
					FailView.errorMessage("사용자 유형이 틀렸습니다.");
				}
				
				break;
			case 2 :
				System.out.println("환영합니다!! 가입하실 사용자 유형을 입력하세요.");
				System.out.print("학생계정-1  강사계정-2 > ");
				kind = sc.nextLine();
				if(kind.equals("1")) {
					kind = "student";
					System.out.print("아이디> ");
					userId = sc.nextLine();
					System.out.print("비밀번호> ");
					userPwd = Integer.parseInt(sc.nextLine());
					System.out.print("이름> ");
					userName = sc.nextLine();
					System.out.print("연락처> ");
					userTel = sc.nextLine();
					System.out.print("전공> ");
					major = sc.nextLine();
					UserController.userJoin(kind, userId, userPwd, userName, userTel, major);
					
				}else if(kind.equals("2")) {
					kind = "teacher";
					System.out.print("아이디> ");
					userId = sc.nextLine();
					System.out.print("비밀번호> ");
					userPwd = Integer.parseInt(sc.nextLine());
					System.out.print("이름> ");
					userName = sc.nextLine();
					System.out.print("연락처> ");
					userTel = sc.nextLine();
					UserController.userJoin(kind, userId, userPwd, userName, userTel, null);
				}else {
					FailView.errorMessage("사용자 유형이 틀렸습니다.");
				}
				break;
				
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
	
	//
	public static void homeMenu(String userId, String kind) throws NumberFormatException{
		while(true) {
			System.out.println("----------------------------------------홈 메뉴--------------------------------------");
			System.out.println("1.공지게시판 | 2.강의목록 | 3.수강신청 | 4.마이페이지 | 5.로그아웃 | 9.프로그램 종료");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
				case 1 :
					boardMenu(userId, kind);
					 break;
				case 2 :
					CourseController.selectCourseList();
					break;
				case 3 :
					//수강신청은 하위메뉴와 학생메뉴 모두에서 접근 가능
					if(kind=="student") sugangMenu(userId, kind);
					else FailView.errorMessage("학생만 수강신청 가능합니다.");
					break;
				case 4 :
					if(kind.equals("student")) MyPageView.studentMenu(userId, kind);
					else if(kind.equals("teacher")) MyPageView.teacherMenu(userId,kind);
					else MyPageView.managerMenu(userId, "manager");
				case 5 :
					loginMenu();
				case 9 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
			}
		}
	}
	
 
    public static void sugangMenu(String userId, String kind) throws NumberFormatException{ //studentMenu와 연결하기
    	//메뉴출력
    	while(true) {
	    	System.out.println("-----------------------수강신청 메뉴-----------------------");
	    	System.out.println("1.강의목록 | 2.수강신청 | 3.신청취소 | 4.신청현황 | 5.장바구니담기 | 6.장바구니목록 | 7.장바구니목록 일괄신청 | 8.홈으로");
	    	int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
				case 1 :
					CourseController.selectCourseList();
					break;
				case 2 :
					System.out.print("신청할 강의코드> ");
					String courseCode = sc.nextLine();
					SugangController.insertSugang(userId, courseCode);
					break;
				case 3 :
					System.out.print("취소할 강의코드> ");
					courseCode = sc.nextLine();
					SugangController.delectSugang(userId, courseCode);
					break;
				case 4 :
					SugangController.selectMind(userId);
					break;
				case 5 :
					System.out.print("담을 강의코드> ");
					courseCode = sc.nextLine();
					CartController.putCart(userId, courseCode);
					break;
				case 6 :	
					CartController.viewCart(userId);
					break;
				case 7 :	
					CartController.allInsertCart(userId);
					break;
				default :
					homeMenu(userId, kind);
					
			}
    	}
    }

	
	public static void boardMenu(String userId, String kind) throws NumberFormatException{
		while(true) {
			System.out.println("-----------------------------------공지게시판----------------------------------");
			System.out.println("1.게시글목록 | 2.게시글등록 | 3.게시글삭제 | 4.댓글등록 | 5.댓글삭제 | 9.홈으로");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
				case 1 : 
					BoardController.boardSelectByAll(); break;
				case 2 :
					System.out.println("**게시글 등록은 강사만 가능합니다**"); //사용자정의 오류처리? grantException
					if(kind.equals("teacher")) {
						System.out.print("내용> ");
						String content = sc.nextLine();
						System.out.print("비밀번호> ");
						int boardPwd = Integer.parseInt(sc.nextLine());
						BoardController.insertBoard(content, boardPwd, userId); //boardNo, 날짜는 시퀀스와 sysdate사용
					}else FailView.errorMessage("권한이 없습니다.");
					break;
				case 3 :
					System.out.println("**게시글 삭제는 강사만 가능합니다**");
					if(kind.equals("teacher")) {
						System.out.print("삭제할 글번호>");
						int deleteNo = Integer.parseInt(sc.nextLine());
						BoardController.deleteBoard(deleteNo);
					}else FailView.errorMessage("권한이 없습니다.");
					break;
				case 4 :
					System.out.print("내용> ");
					String content = sc.nextLine();
					System.out.print("부모글 번호> ");
					int boardNo = Integer.parseInt(sc.nextLine());
					System.out.print("작성자> ");
					String writer = sc.nextLine();
					System.out.print("비밀번호(숫자)>");
					int replyPwd = Integer.parseInt(sc.nextLine());
					BoardController.replyInsert(content, boardNo, writer, replyPwd); //BoardController에 List<Reply> 추가 필요
					break;
				case 5 :
					System.out.print("부모글 번호> ");
					boardNo = Integer.parseInt(sc.nextLine());
					System.out.print("댓글 번호> ");
					int replyNo = Integer.parseInt(sc.nextLine());
					System.out.print("비밀번호> ");
					replyPwd = Integer.parseInt(sc.nextLine());
					BoardController.replyDelete(boardNo, replyNo, replyPwd);
					break;
				case 9 :
					homeMenu(userId, kind);
					break;
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
					
			}
		}
	}
	
}
