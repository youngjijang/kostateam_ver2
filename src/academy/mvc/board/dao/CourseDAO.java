package academy.mvc.board.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;

public interface CourseDAO {
	// 아직 CourseDTO가 없기에 import를 할 주소값이없어 import는 없으므로 확인해야함

	//테스

	/**
	 * 전체 강의 조회-학생
	 */
	List<CourseDTO> selectAllCousre() throws SQLException;

	/**
	 * 내 강의 조회-강사
	 */
	List<CourseDTO> selectMind(String teacherId) throws SQLException;

	/**
	 * 강의 등록-강사
	 *
	 **/
	int insertCourse(CourseDTO courseDTO) throws SQLException;

}
