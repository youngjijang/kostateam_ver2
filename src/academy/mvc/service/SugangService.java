package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dao.SugangDAO;
import academy.mvc.model.dao.SugangDAOImpl;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;

public class SugangService {
	SugangDAO dao = new SugangDAOImpl();
	public List<SugangDTO> selectMind(String studentId)throws SQLException {
		
		List<SugangDTO> list =dao.selectMind(studentId);	
		if(list.size()==0)throw new NullPointerException("수강한 과목이 없습니다.");
		return list;
	}
	
	public List<StudentDTO> selectStudentList(String teacherID)throws SQLException{
		List<StudentDTO> list = dao.selectStudentList(teacherID);
		if(list.size()==0)throw new NullPointerException("수강중인 학생이 없습니다.");
		return list;
	}
	
	public List<SugangDTO> selectGrade(String studentId)throws SQLException{
		List<SugangDTO> list = dao.selectGrade(studentId);
		if(list.size()==0)throw new NullPointerException("수강한 과목이 없습니다.");
		return list;
	}
	
	
	public void updateScore(String studentId, int score,String userId) throws SQLException{
		int result = dao.updateScore(studentId, score, userId);
		if(result == 0 ) {
			throw new SQLException("등록 실패");
		}
		
	}
	
	public void insertSugang(String studentId,String cCode) throws SQLException{
		int result = dao.insertSugang(studentId, cCode);
		if(result == 0 )throw new SQLException("수강신청 안됨");
		
	}
	
	public void delectSugang(String studentId,String cCode) throws SQLException{
		int result = dao.delectSugang(studentId, cCode);
		if(result == 0 )throw new SQLException("수강철회 안됨");
		
	}

	public List<SugangDTO> selectAllScorebyTeacherId(String teacherId) throws SQLException{
		//학생정보 + 성적
		List<SugangDTO> studentWithScoreList = dao.selectStudentWithScoreList(teacherId);
		if(studentWithScoreList.size()==0)throw new NullPointerException("수강중인 학생이 없습니다.");
		return studentWithScoreList;
	}
	
}
