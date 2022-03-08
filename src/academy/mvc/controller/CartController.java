package academy.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.service.CourseService;
import academy.mvc.session.Session;
import academy.mvc.session.SessionSet;

public class CartController {
	private static CourseService courseService = new CourseService();
	
	
	public static void putCart(String sID,String cCode) {
		
		try {
			CourseDTO course = courseService.selectCartCourse(cCode);
			int people = 0;
			if(course.getcCapa()< people) {
				throw new SQLException("수강인원 초과");
			}
			
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(sID);
			
			List <String> cart = session.getAttributes();
			
			if(cart == null) {
				cart = new ArrayList<String>();
				session.setAttributes(cart);
			}
			
			
			//cart.get(0)
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
