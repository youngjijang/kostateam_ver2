package academy.mvc.board.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;

public interface CourseDAO {

	/**
	 * 전체 강의 조회
	 */
	List<CourseDTO> getCourseList() throws SQLException;

	/**
	 * 내 강의 조회
	 */
	List<StudentDTO> getStudentList(String teacherId) throws SQLException;

	/**
	 * 강의 등록-강사
	 **/
	int insertCourse(CourseDTO courseDTO) throws SQLException;
	

}
