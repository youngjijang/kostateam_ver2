package academy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;

public interface CourseDAO {
	/**
	 * 강사 지정 강의중복 체크
	 */
	boolean tCourseCode( String cCode)throws SQLException;
	/**
	 * 강의코드 중복 체크
	 */
	boolean cCodeCheck(String cCode) throws SQLException;

	/**
	 * 전체 강의 조회
	 */
	List<CourseDTO> selectCourseList() throws SQLException;

	/**
	 * 내 강의 조회-강사
	 */
	List<CourseDTO> selectTeacherCourse(String teacherId) throws SQLException;

	/**
	 * 선택한 과목
	 */
	CourseDTO selectCartCourse(String cCode) throws SQLException;

	/**
	 * 강의 등록
	 */
	int insertCourse(CourseDTO courseDTO) throws SQLException;

	/**
	 * 강의 수정 (강의 내용만 수정)
	 */
	int updateCourse(String cCode, String cContent) throws SQLException;

	/**
	 * 강의 삭제
	 */
	int deleteCourse(String cCode) throws SQLException;
	
	/**
	 * 강사 지정
	 */
	int choiceTeacher(String teacherId, String cCode)throws SQLException;

}
