package academy.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.service.CartService;
import academy.mvc.service.CourseService;
import academy.mvc.service.SugangService;
import academy.mvc.session.Session;
import academy.mvc.session.SessionSet;
import academy.mvc.view.FailView;
import academy.mvc.view.SuccessView;



public class CartController {
	private static CourseService courseService = new CourseService();
	private static CartService cartService = new CartService();
	
	public static void putCart(String sID,String cCode) {
		
		try {
			CourseDTO course = courseService.selectCartCourse(cCode);

			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(sID);                          
			//장바구니 가져오기
			Map<CourseDTO,String> cart = (Map<CourseDTO,String>)session.getAttribute("cart");
			
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}
			String co = cart.get(course);
			if(co != null) { //장바구니에 이미 상품이 있다면
				throw new Exception("이미 장바구니에 담아뒀음");
			}

			//장바구니에 넣기
			cart.put(course, cCode);
			
			SuccessView.printMessage("장바구니에 담았습니다.");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		} 	
	}//put메소드끝
	
	public static void viewCart(String sID) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(sID);
		
		Map<CourseDTO,String> cart = (Map<CourseDTO,String>)session.getAttribute("cart");
		if(cart == null ) { // 장바구니가 없는 고객
			FailView.errorMessage("장바구니가 비었습니다");
		}else {
			SuccessView.printViewCart(sID , cart);
		}

	}//view 끝
	
	
	
	
	public static void allInsertCart(String sID) {
		try {
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(sID);
			Map<CourseDTO,String> cart = (Map<CourseDTO,String>)session.getAttribute("cart");
			cartService.allInsertCart(sID, cart);
			SuccessView.printMessage("수강신청 완료");
		} catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
	
}
