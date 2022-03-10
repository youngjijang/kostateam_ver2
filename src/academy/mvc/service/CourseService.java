package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dao.CourseDAO;
import academy.mvc.model.dao.CourseDAOImpl;
import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;

public class CourseService {
	CourseDAO courseDAO = new CourseDAOImpl();

	/**
	 * 전체 강의 목록리턴
	 */
	public List<CourseDTO> selectCourseList() throws NullPointerException, SQLException {
		List<CourseDTO> list = courseDAO.selectCourseList();

		if (list.size() == 0) {
			throw new NullPointerException("강의 목록이 비었습니다.");
		}
		return list;
	}

	/**
	 * 내 강의 조회-강사
	 */
	public List<CourseDTO> selectTeacherCourse(String teacherId) throws NullPointerException, SQLException {
		List<CourseDTO> list = courseDAO.selectTeacherCourse(teacherId);

		if (list.size() == 0) {
			throw new NullPointerException("강의중인 과목이 없습니다.");
		}
		return list;
	}

	/**
	 * 선택과목정보-cart
	 */
	public CourseDTO selectCartCourse(String cCode) throws SQLException {
		CourseDTO dto = courseDAO.selectCartCourse(cCode);
		if (dto == null)
			throw new NullPointerException("해당 과목이 없습니다.");
		return dto;
	}

	/**
	 * 강의 등록
	 */
	public void insertCourse(CourseDTO courseDTO) throws SQLException {
		if(courseDAO.cCodeCheck(courseDTO.getcCode())) {
			throw new SQLException("이미 존재하는 강의코드입니다. 강의등록에 실패했습니다.");
		}else {
			int result = courseDAO.insertCourse(courseDTO);
			if (result == 0) {
				throw new SQLException("강의 등록에 실패했습니다.");
			}
		}	

	}

	/**
	 * 강의 수정
	 */
	public void updateCourse(String cCode, String cContent) throws SQLException {
		int result = courseDAO.updateCourse(cCode, cContent);
		if (result == 0) {
			throw new SQLException("강의 수정에 실패했습니다.");
		}
	}

	/**
	 * 강의 삭제
	 */
	public void deleteCourse(String cCode) throws SQLException {
		int result = courseDAO.deleteCourse(cCode);
		if (result == 0) {
			throw new SQLException("강의 삭제에 실패했습니다.");
		}
	}

}
