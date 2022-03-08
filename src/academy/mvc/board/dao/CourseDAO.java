package academy.mvc.board.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;

public interface CourseDAO {

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
}
