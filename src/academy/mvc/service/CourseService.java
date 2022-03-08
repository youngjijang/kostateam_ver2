package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.board.dao.CourseDAO;
import academy.mvc.board.dao.CourseDAOImpl;
import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;

public class CourseService {
	CourseDAO courseDAO = new CourseDAOImpl();

	/**
	 * 전체 강의 목록리턴
	 */
	public List<CourseDTO> getCourseList() throws SQLException {
		List<CourseDTO> list = courseDAO.getCourseList();

		if (list.size() == 0) {
			throw new SQLException("강의 목록이 비었습니다.");
		}
		return list;
	}

	/**
	 * 강사 ID 받아서 해당 강사의 강의를 수강하는 학생 목록 리턴
	 */
	public List<StudentDTO> getStudentList(String teacherId) throws SQLException {
		List<StudentDTO> list = courseDAO.getStudentList(teacherId);

		if (list.size() == 0) {
			throw new SQLException("해당 강의를 수강하는 학생 목록이 비었습니다.");
		}

		return null;

	}


}
