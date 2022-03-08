package academy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.service.SugangService;

public class SugangController {
	private static SugangService service = new SugangService();
	
	public static void selectMind(String studentId) {		
		try {
			List<SugangDTO> list = service.selectMind(studentId);	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectStudentList(String cCode) {
		try {
			List<StudentDTO> list = service.selectStudentList(cCode);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void selectGrade(String studentId) {
		
		try {
			List<SugangDTO> list = service.selectGrade(studentId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	

	public static void selectScore() {
		// TODO Auto-generated method stub
		
	}

	public static void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	/*
	
	public static void main(String[] args) {
		selectGrade("거북이");
		
	}*/
	
}
