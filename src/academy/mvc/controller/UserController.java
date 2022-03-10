package academy.mvc.controller;

import java.awt.Menu;
import java.sql.SQLException;

import academy.mvc.model.dto.UserDTO;
import academy.mvc.service.UserService;
import academy.mvc.view.FailView;
import academy.mvc.view.MenuView;
import academy.mvc.view.MyPageView;
import academy.mvc.view.SuccessView;

public class UserController {
	static UserService userService = new UserService();
	
	/**
	 * 회원가입
	 */
	public static void userJoin(String kind, String userId, int userPwd, String userName, String userTel, String thing) {
		try {
			userService.userJoin(kind, userId, userPwd, userName, userTel, thing);
			SuccessView.printMessage("회원가입이 완료되었습니다!");
			MenuView.loginMenu();
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
			//e.printStackTrace();
			MenuView.loginMenu();
		}
	}
	
	/**
	 *로그인
	 * 학생kind - student 강사kind - teacher
	 * @param userId userPwd kind
	 */
	public static void userLogin(String userId, int userPwd, String kind) {
		try{
			userService.userLogin(userId, userPwd, kind);
			if(kind.equals("student")) {
				MenuView.homeMenu(userId, kind);
			} else if(kind.equals("teacher")) {
				MenuView.homeMenu(userId, kind);
			} else { 
				MenuView.homeMenu(userId, kind);
			}
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			MenuView.loginMenu();
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
