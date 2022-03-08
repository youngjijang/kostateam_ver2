package academy.mvc.controller;

import academy.mvc.model.dto.UserDTO;
import academy.mvc.service.UserService;
import academy.mvc.view.FailView;
import academy.mvc.view.MenuView;
import academy.mvc.view.SuccessView;

public class UserController {
	static UserService userService = new UserService();
	
	/**
	 *로그인
	 * 학생kind - student 강사kind - teacher
	 * @param userId userPwd kind
	 */
	public static void userLogin(String userId, int userPwd, String kind) {
		try{
			userService.userLogin(userId, userPwd, kind);
			if(kind.equals("student"))
				MenuView.studentMenu(userId);
			else 
				MenuView.teacherMenu(userId);
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * 개인정보 보기
	 */
	public static void showUser(String kind, String userId) {
		try{
			UserDTO user = userService.showInfo(kind,userId);
			SuccessView.printUserInfo(user);
			
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	* 연락처 수정
	 */
	public static void updateUser(String kind, String userId, String newTel) {
		try{
			userService.updateUser(kind, userId, newTel);
			SuccessView.printMessage("수정이 완료되었습니다.");
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 개인정보 삭제
	 */
	public static void deleteUser(String kind, String userId) {
		try {
			userService.deleteUser(kind, userId);
			//SuccessView
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
}
