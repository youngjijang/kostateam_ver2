package academy.mvc.view;

import java.util.Scanner;

import academy.mvc.controller.UserController;

public class StartView {

	static Scanner sc = new Scanner(System.in);
	public static void userLogin() {
		
		String userId;
		int userPwd;
		String kind;
		
		while(true){
			System.out.println("-------------Academy Program 시작합니다-------------");
			System.out.println("사용자 유형을 입력하세요");
			System.out.println("1-학생계정  2-강사계정 >");
			kind = sc.nextLine();
			
			System.out.println("아이디> ");
			userId = sc.nextLine();
			System.out.println("비밀번호> ");
			userPwd = Integer.parseInt(sc.nextLine());
			
			if(kind=="1") 
				UserController.userLogin(userId, userPwd, "student");
			else if(kind=="2")
				UserController.userLogin(userId, userPwd, "teacher");
			else
				FailView.errorMessage("사용자 유형입력이 틀렸습니다.");
			
		}
	}
	
	
	public static void main(String[] args) {
		userLogin();
	}

}
