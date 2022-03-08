package academy.mvc.controller;

import java.sql.SQLException;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.service.CourseService;

public class CartController {
	private static CourseService courseService = new CourseService();
	
	
	public static void putCart(String sID,String cCode) {
		
		//CourseDTO course = courseService. // 강의에서 선택한 과목 불러오기
		/*
		if(course.getKapa() < max) {
			throw new SQLException("수강인원 초과");
		}*/
		
	}
}
