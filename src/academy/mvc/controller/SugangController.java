package academy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.service.SugangService;

public class SugangController {
	private static SugangService service = new SugangService();
	
	/**
	 * 수강중인 과목 확인-학생
	 * */
	public static void selectMind(String studentId) {		
		try {
			List<SugangDTO> list = service.selectMind(studentId);	
			for (SugangDTO sugangDTO : list) {
				System.out.println(sugangDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 수강중인 학생 목록-강사
	 * */
	public static void selectStudentList(String cCode) {
		try {
			List<StudentDTO> list = service.selectStudentList(cCode);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 수강성적확인-학생
	 * */
	public static void selectGrade(String studentId) {
		
		try {
			List<SugangDTO> list = service.selectGrade(studentId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 학생 성적 수정-강사
	 * */
	public static void updateScore(String studentId, int score) {
		try {
			service.updateScore(studentId, score);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 강의 신청-학생
	 * */
	public static void insertSugang(String studentId,String cCode) {
		try {
			service.insertSugang(studentId, cCode);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 강의 철회-학생
	 * */
	public static void delectSugang(String studentId,String cCode) {
		try {
			service.delectSugang(studentId, cCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public static void main(String[] args) {
		selectMind("거북이");
		
	
	}
}
