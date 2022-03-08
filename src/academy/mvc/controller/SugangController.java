package academy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.service.SugangService;

public class SugangController {
	private static SugangService service = new SugangService();
	
	public static void SelectMind(String studentId) {		
		try {
			List<SugangDTO> list = service.selectMind(studentId);	
			//System.out.println(list.get(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void SelectStudentList(String cCode) {
		try {
			List<StudentDTO> list = service.selectStudentList(cCode);
			for (StudentDTO studentDTO : list) {
				System.out.println(studentDTO.getUserTel());		
			}
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
		SelectStudentList("A100");
		//SelectMind("11");
	}*/
	
}
