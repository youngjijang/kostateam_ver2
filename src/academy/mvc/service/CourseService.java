package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dao.CourseDAO;
import academy.mvc.model.dao.CourseDAOImpl;
import academy.mvc.model.dao.UserDAO;
import academy.mvc.model.dao.UserDAOImpl;
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
		if(courseDAO.cCodeCheck(cCode)) {
			int result = courseDAO.updateCourse(cCode, cContent);
			if (result == 0) {
				throw new SQLException("강의 수정에 실패했습니다.");
			}
		}else {
			throw new SQLException("존재하지않는 강의코드입니다.");
		}
		
	}

	/**
	 * 강의 삭제
	 */
	public void deleteCourse(String cCode) throws SQLException {
		if(courseDAO.cCodeCheck(cCode)) {
			int result = courseDAO.deleteCourse(cCode);
			if (result == 0) {
				throw new SQLException("수강중인 학생 혹은 지정 강사가 존재하는 강의로 삭제가 불가능합니다.");
			}
		}else {
			throw new SQLException("존재하지않는 강의코드입니다.");
		}	
	}

	/**
	 * 강사 지정
	 */
	public void choiceTeacher(String teacherId, String cCode)throws SQLException,NullPointerException {
		if(courseDAO.cCodeCheck(cCode)) { // 강의 코드 확인
			
			UserDAO userDAO = new UserDAOImpl();
			if(userDAO.idCheck("teacher", teacherId)) {//강사 id확인
				if(courseDAO.tCourseCode(cCode)) {
					throw new SQLException("강사 지정에 실패했습니다. : 해당 강의는 이미 지정된 강사가 존재합니다.");
				}else {
					if(courseDAO.choiceTeacher(teacherId, cCode)==0)
					throw new SQLException("강사 지정에 실패했습니다.");
				}
			}else
				throw new NullPointerException("존재하지않는 강사ID입니다.");
		}else {
			throw new NullPointerException("존재하지않는 강의코드입니다.");
		}	
			
		
	}
}
