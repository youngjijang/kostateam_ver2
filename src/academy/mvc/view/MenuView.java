package academy.mvc.view;

import java.util.Scanner;

import academy.mvc.controller.CourseController;
import academy.mvc.controller.SugangController;
import academy.mvc.controller.UserController;


public class MenuView {
	static Scanner sc = new Scanner(System.in);
	
	public static void userLoginMenu() {
		
		String userId;
		int userPwd;
		String kind;
		
		while(true){
			System.out.println("**************Academy Program 시작합니다**************");
				System.out.println("사용자 유형을 입력하세요");
				System.out.print("학생계정-1  강사계정-2 > ");
				kind = sc.nextLine();
				
				System.out.print("아이디> ");
				userId = sc.nextLine();
				System.out.print("비밀번호> ");
				userPwd = Integer.parseInt(sc.nextLine());
				
				
				if(kind.equals("1")) 
					UserController.userLogin(userId, userPwd, "student");
				else if(kind.equals("2"))
					UserController.userLogin(userId, userPwd, "teacher");
				else {
					FailView.errorMessage("사용자 유형이 틀렸습니다.");
					
					System.out.println("다시 입력하려면 Y, 프로그램을 종료하려면 N을 누르세요");
					System.out.print("입력> ");
					String input = sc.nextLine();
					if(input.equals("Y") || input.equals("y")) userLoginMenu();
					else System.exit(0);
				}
		}
	}
	
    public static void studentMenu(String userId){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("--------------------------------------------학생 메뉴------------------------------------------");
			System.out.println("1.강의목록 | 2.수강신청 | 3.성적확인 | 4.개인정보확인 | 5.개인정보수정 | 6.게시판 | 9.로그아웃");
			int menuNo = Integer.parseInt(sc.nextLine());
			switch(menuNo) {
				case 1 :
					CourseController.selectCourseList();
					//SuccessView.printCourseList(list);
					break;
					
				case 2 :
					//수강코드 키보드입력받음
					String courseCode = sc.nextLine();
					SugangController.insertSugang(userId, courseCode);
					break;
					
				case 3 :
					SugangController.selectGrade(userId);
					break;
					
				case 4 :
					UserController.showUser("student", userId);
					break;
					
				case 5 :
					//연락처 키보드 입력받음
					System.out.println("변경할 연락처> ");
					//sc.next();//개행읽기
					String newTel = sc.nextLine();
					UserController.updateUser("student", userId, newTel); //Session추가 후 수정...
					//비밀번호 변경(미정)
					break;
				case 6 :
					//게시판메뉴로 이동한다
					boardMenu();
				case 9 :
					userLoginMenu();
					//session...
			
			}
		}	
	}

	
	public static void teacherMenu(String userId){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("--------------------------------------------강사 메뉴------------------------------------------");
			System.out.println("1.학생목록 | 2.성적등록 | 3.성적수정 | 4.개인정보확인 | 5.개인정보수정 | 6.게시판 | 9.로그아웃");
			int menuNo = Integer.parseInt(sc.nextLine());
				switch(menuNo) {
					case 1 :
						//SugangController.selectStudentList();
						break;
					case 2 :
						//성적입력받는다
						int score = sc.nextInt(); //개행 읽기 필요?
						SugangController.updateScore(userId, score); //성적등록과 수정 메소드 동일
						break;
					case 3 :
						System.out.println("변경할 성적> ");
						int newScore = sc.nextInt();
						SugangController.updateScore(userId, newScore);
						break;
					case 4 :
						UserController.showUser("teacher", userId);
						break;
					case 5 :
						System.out.println("변경할 연락처> ");
						String newTel = sc.nextLine();
						UserController.updateUser("teacher", userId, newTel);
						break;
					case 6 :
						//게시판메뉴로 이동한다
						boardMenu();
					case 9 :
						userLoginMenu();
						//session...
				}
			
		}
	}
	
	
	public static void boardMenu() {
		//강사,학생이 6번메뉴 진입하면 들어온다
		System.out.println("------------------------------------게시판 메뉴----------------------------------");
		System.out.println("1.게시글목록 | 2.게시글등록 | 3.게시글삭제 | 4.댓글등록 | 5.댓글삭제 | 9.나가기");
		int menuNo = Integer.parseInt(sc.nextLine());
		switch(menuNo) {
			case 1 : 
				
			case 2 :
				
			case 3 :
			
			case 4 : 
				
			case 5 :
				
			case 9 :
				
		}
	}
}
