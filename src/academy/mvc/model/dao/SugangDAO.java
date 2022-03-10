package academy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;

public interface SugangDAO {
//아직 SugangDTO가 없기에 import를 할 주소값이없어 import는 없으므로 확인해야함	

	/**
	 * 수강중인 과목 확인-학생
	 */
	List<SugangDTO> selectMind(String studentId) throws SQLException;

	/**
	 * 수강중인 학생 목록-강사
	 */
	List<StudentDTO> selectStudentList(String cCode) throws SQLException;

	/**
	 * 수강성적확인-학생
	 */
	List<SugangDTO> selectGrade(String studentId) throws SQLException;

	/**
	 * 학생정보 + 성적
	 */
	List<SugangDTO> selectStudentWithScoreList(String teacherId) throws SQLException;

	/**
	 * 학생 성적 수정-강사
	 */
	int updateScore(String studentId, int score, String userId) throws SQLException;

	/**
	 * 강의 신청-학생
	 */
	int insertSugang(String studentId, String cCode) throws SQLException;

	/**
	 * 강의 철회-학생
	 */
	int delectSugang(String studentId, String cCode) throws SQLException;

}
