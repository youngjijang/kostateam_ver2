package academy.mvc.view;

import academy.mvc.controller.CourseController;
import academy.mvc.controller.SugangController;
import academy.mvc.controller.UserController;

public class MyPageView {
	
    public static void studentMenu(String userId, String kind){
		while(true){
			System.out.println("---------------------"+userId+ "님의 마이페이지 ( "+kind+" )----------------------");
			System.out.println("1.수강현황 | 2.성적확인 | 3.개인정보확인 | 4.개인정보수정 | 5.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(MenuView.sc.nextLine());
			switch(menuNo) {
				case 1 :
					SugangController.selectMind(userId);
					System.out.println("수강신청 페이지로 가려면 Y를 누르세요");
					String select = MenuView.sc.nextLine();
					if(select.equals("Y")||select.equals("y")) MenuView.sugangMenu(userId, kind);
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
					String newTel = MenuView.sc.nextLine();
					UserController.updateUser("student", userId, newTel); //Session추가 후 수정...
					//비밀번호 변경(미정)
					break;
				case 5 :
					MenuView.homeMenu(userId, kind);
					break;
				case 9:
					MenuView.loginMenu();
					break;
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
			}
		}	
	}
    
    
	public static void teacherMenu(String userId, String kind){
		while(true){
			System.out.println("---------------------------"+userId+ "님의 마이페이지 ( "+kind+" )---------------------------");
			System.out.println("1.학생목록 | 2.성적등록 | 3.성적수정 | 4.개인정보확인 | 5.개인정보수정 | 6.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(MenuView.sc.nextLine());
				switch(menuNo) {
					case 1 :
						SugangController.selectStudentList(userId);
						break;
					case 2 :
						System.out.print("학생ID> ");
						String studentId = MenuView.sc.nextLine();
						System.out.print("성적> ");
						int score = MenuView.sc.nextInt();
						SugangController.updateScore(studentId, score);
						break;
					case 3 :
						System.out.print("변경할 학생ID> ");
						studentId = MenuView.sc.nextLine();
						System.out.print("변경할 성적> ");
						int newScore = MenuView.sc.nextInt();
						SugangController.updateScore(studentId, newScore);
						break;
					case 4 :
						UserController.showUser("teacher", userId);
						break;
					case 5 :
						System.out.print("연락처를 변경합니다.");
						System.out.print("변경할 연락처> ");
						String newTel = MenuView.sc.nextLine();
						UserController.updateUser("teacher", userId, newTel);
						break;
					case 6 :
						MenuView.homeMenu(userId, kind);
						break;
					case 9 :
						MenuView.loginMenu();
						break;
						//session...
					default :
						FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
				}
			
		}
	}
	
	public static void managerMenu(String userId, String kind) {
		while(true) {
			System.out.println("---------------------------"+userId+ "님의 마이페이지 ( "+kind+" )---------------------------");
			System.out.println("1.강의등록 | 2.강의수정 | 3.강의삭제 | 6.홈으로 | 9.로그아웃");
			int menuNo = Integer.parseInt(MenuView.sc.nextLine());
				switch(menuNo) {
				case 1 :
					System.out.println("강의를 등록합니다.");
					System.out.println("강의코드>");
					String cCode = MenuView.sc.nextLine();
					System.out.println("강의이름> ");
					String cName = MenuView.sc.nextLine();
					System.out.println("최대 수강인원> ");
					int cCapa = Integer.parseInt(MenuView.sc.nextLine());
					System.out.println("총 강의시간> ");
					int cHour = Integer.parseInt(MenuView.sc.nextLine());
					System.out.println("강의설명> ");
					String cContent = MenuView.sc.nextLine();
					System.out.println("강의시작일> ");
					String cStart = MenuView.sc.nextLine();
					System.out.println("강의종료일> ");
					String cEnd = MenuView.sc.nextLine();
					CourseController.insertCourse(cCode, cName, cCapa, cHour, cContent, cStart, cEnd);
					
					break;
				case 2 : 
					System.out.println("강의를 수정합니다.");
					System.out.print("수정할 강의코드> ");
					cCode = MenuView.sc.nextLine();
					System.out.println("수정할 강의설명> ");
					cContent = MenuView.sc.nextLine();
					CourseController.updateCourese(cCode, cContent);
					break;
				case 3 : 
					System.out.println("강의를 삭제합니다.");
					System.out.print("삭제할 강의> ");
					cCode = MenuView.sc.nextLine();
					CourseController.deleteCourse(cCode);
					break;
				case 6 :
					MenuView.homeMenu(userId, kind);
					break;
				case 9 :
					MenuView.loginMenu();
					break;
					//session...
				default :
					FailView.errorMessage("메뉴를 잘못 입력하였습니다.");
				}
		}
	}
}