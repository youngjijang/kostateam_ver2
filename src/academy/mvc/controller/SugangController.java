package academy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.service.SugangService;
import academy.mvc.view.FailView;
import academy.mvc.view.SuccessView;

public class SugangController {
	private static SugangService service = new SugangService();
	
	/**
	 * 수강중인 과목 확인-학생
	 * */
	public static void selectMind(String studentId) {		
		try {
			List<SugangDTO> list = service.selectMind(studentId);	
			SuccessView.printSugangList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 수강중인 학생 목록-강사
	 * */
	public static void selectStudentList(String teacherID) {
		try {
			List<StudentDTO> list = service.selectStudentList(teacherID);
			SuccessView.printStudentList(list);			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}	
	}
	
	/**
	 * 수강성적확인-학생
	 * */
	public static void selectGrade(String studentId) {
		
		try {
			List<SugangDTO> list = service.selectGrade(studentId);
			SuccessView.printScoreByStudentId(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 학생성적 전체확인-강사
	 * */
	public static void selectAllScorebyTeacherId(String userId) {
		try {
			List<SugangDTO> list = service.selectAllScorebyTeacherId(userId);
			SuccessView.printAllScorebyTeacherId(list);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
	/**
	 * 학생 성적 수정-강사
	 * */
	public static void updateScore(String studentId, int score,String userId) {
		try {
			service.updateScore(studentId, score,userId);
			SuccessView.printMessage("수정 완료");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 강의 신청-학생
	 * */
	public static void insertSugang(String studentId,String cCode) {
		try {
			service.insertSugang(studentId, cCode);
			SuccessView.printMessage("신청 완료");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	
	}
	
	/**
	 * 강의 철회-학생
	 * */
	public static void delectSugang(String studentId,String cCode) {
		try {
			service.delectSugang(studentId, cCode);
			SuccessView.printMessage("철회 성공");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}	
	}

	
	
	

}
