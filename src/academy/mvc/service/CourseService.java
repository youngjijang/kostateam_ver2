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
	public List<CourseDTO> selectCourseList() throws SQLException {
		List<CourseDTO> list = courseDAO.selectCourseList();

		if (list.size() == 0) {
			throw new NullPointerException("강의 목록이 비었습니다.");
		}
		return list;
	}

	/**
	 * 내 강의 조회-강사
	 */
	public List<CourseDTO> selectTeacherCourse(String teacherId) throws SQLException {
		List<CourseDTO> list = courseDAO.selectTeacherCourse(teacherId);
		
		if(list.size() == 0) {
			throw new NullPointerException("강의중인 과목이 없습니다.");
		}
		return list;
	}

}
