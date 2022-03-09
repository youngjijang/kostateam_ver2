package academy.mvc.view;

import java.util.Scanner;

import academy.mvc.controller.BoardController;
import academy.mvc.controller.CartController;
import academy.mvc.controller.CourseController;
import academy.mvc.controller.SugangController;
import academy.mvc.controller.UserController;


public class MenuView {
	static Scanner sc = new Scanner(System.in);
	
	public static void loginMenu() {
		
		String userId;
		int userPwd;
		String kind;
		
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
						
						System.out.println("다시 입력하려면 Y, 프로그램을 종료하려면 N을 누르세요");
						System.out.print("입력> ");
						String input = sc.nextLine();
						if(input.equals("Y") || input.equals("y")) loginMenu();
						else System.exit(0);
					}
				case 2 :
					//회원가입
				case 9 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		}
	}
	
	//
	public static void homeMenu(String userId, String kind) {
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
				if(kind.equals("student")) studentMenu(userId, kind);
				else if(kind.equals("teacher")) teacherMenu(userId,kind);
			case 5 :
				loginMenu();
			case 9 :
				System.exit(0);
			default :
				FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
		}
	}
	
    public static void studentMenu(String userId, String kind){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("---------------------"+userId+ "님의 마이페이지 ( "+kind+" )----------------------");
			System.out.println("1.수강현황 | 2.성적확인 | 3.개인정보확인 | 4.개인정보수정 | 5.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
				case 1 :
					SugangController.selectMind(userId);
					System.out.println("수강신청 페이지로 가려면 Y를 누르세요");
					String select = sc.nextLine();
					if(select.equals("Y")||select.equals("y")) sugangMenu(userId, kind);
					break;
				case 2 :
					SugangController.selectGrade(userId);
					break;
				case 3 :
					UserController.showUser(kind, userId);
					break;
				case 4 :
					System.out.println("연락처를 변경합니다.");
					System.out.print("변경할 연락처> ");
					//sc.next();//개행읽기
					String newTel = sc.nextLine();
					UserController.updateUser("student", userId, newTel); //Session추가 후 수정...
					//비밀번호 변경(미정)
					break;
				case 5 :
					homeMenu(userId, kind);
					break;
				case 9:
					loginMenu();
					break;
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
			}
		}	
	}
    
    
    public static void sugangMenu(String userId, String kind) { //studentMenu와 연결하기
    	//메뉴출력
    	System.out.println("-----------------------수강신청 페이지-----------------------");
    	System.out.println("1.강의목록 | 2.수강신청 | 3.신청취소 | 4.신청현황 | 5.장바구니담기 | 6.장바구니목록 | 7.홈으로");
    	int menuNo = Integer.parseInt(sc.nextLine());
		switch(menuNo) {
			case 1 :
				CourseController.selectCourseList();
				break;
			case 2 :
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
				courseCode = sc.nextLine();
				CartController.putCart(userId, courseCode);
				break;
			case 6 :
				courseCode = sc.nextLine();
				CartController.viewCart(userId);
				break;
			default :
				homeMenu(userId, kind);
				
		}
    }

	
	public static void teacherMenu(String userId, String kind){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("---------------------------"+userId+ "님의 마이페이지 ( "+kind+" )---------------------------");
			System.out.println("1.학생목록 | 2.성적등록 | 3.성적수정 | 4.개인정보확인 | 5.개인정보수정 | 6.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(sc.nextLine());
				switch(menuNo) {
					case 1 :
						SugangController.selectStudentList(userId);
						break;
					case 2 :
						int score = sc.nextInt();
						SugangController.updateScore(userId, score); //성적등록과 수정 메소드 동일
						break;
					case 3 :
						System.out.print("변경할 성적> ");
						int newScore = sc.nextInt();
						SugangController.updateScore(userId, newScore);
						break;
					case 4 :
						UserController.showUser("teacher", userId);
						break;
					case 5 :
						System.out.print("연락처를 변경합니다.");
						System.out.print("변경할 연락처> ");
						String newTel = sc.nextLine();
						UserController.updateUser("teacher", userId, newTel);
						break;
					case 6 :
						homeMenu(userId, kind);
						break;
					case 9 :
						loginMenu();
						break;
						//session...
					default :
						FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
				}
			
		}
	}
	
	public static void managerMenu(String userId, String kind) {
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true) {
			System.out.println("---------------------------"+userId+ "님의 마이페이지 ( "+kind+" )---------------------------");
			System.out.println("1.강의등록 | 2.강의수정 | 3.강의삭제 | 6.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(sc.nextLine());
				switch(menuNo) {
				case 1 :
					System.out.println("강의를 등록합니다.");
					System.out.println("등록할 강의>");
					String courseCode = sc.nextLine();
//					CourseController.insertCourse(); 
					break;
				case 2 : 
					System.out.println("강의를 수정합니다.");
					System.out.print("수정할 강의> ");
					String course = sc.nextLine();
//					CourseController.updateCourse();
					break;
				case 3 : 
					System.out.println("강의를 삭제합니다.");
					System.out.print("삭제할 강의> ");
					courseCode = sc.nextLine();
//					CourseController.deleteCourse();
				case 6 :
					homeMenu(userId, kind);
					break;
				case 9 :
					loginMenu();
					break;
					//session...
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
				}
		}
	}
	
	public static void boardMenu(String userId, String kind) {
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
					int boardPwd = sc.nextInt();
					//BoardController.insertBoard(content, boardPwd, userId); //boardNo, 날짜는 시퀀스와 sysdate사용
				}else FailView.errorMessage("권한이 없습니다.");
				break;
			case 3 :
				System.out.print("삭제할 글번호>");
				int deleteNo = sc.nextInt();
				BoardController.deleteBoard(deleteNo);
				break;
			case 4 :
				System.out.print("내용> ");
				String content = sc.nextLine();
				System.out.print("부모글 번호> ");
				int boardNo = sc.nextInt();
				System.out.print("작성자> ");
				String writer = sc.nextLine();
				System.out.print("비밀번호(숫자)>");
				int replyPwd = sc.nextInt();
				BoardController.replyInsert(content, boardNo, writer, replyPwd); //BoardController에 List<Reply> 추가 필요
				break;
			case 5 :
				System.out.print("부모글 번호> ");
				boardNo = sc.nextInt();
				System.out.print("댓글 번호> ");
				int replyNo = sc.nextInt();
				System.out.print("비밀번호> ");
				replyPwd = sc.nextInt();
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
