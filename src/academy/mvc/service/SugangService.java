package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.board.dao.SugangDAO;
import academy.mvc.board.dao.SugangDAOImpl;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;

public class SugangService {
	SugangDAO dao = new SugangDAOImpl();
	public List<SugangDTO> selectMind(String studentId)throws SQLException {
		
		List<SugangDTO> list =dao.selectMind(studentId);		
		return list;
	}
	
	public List<StudentDTO> selectStudentList(String cCode)throws SQLException{
		List<StudentDTO> list = dao.selectStudentList(cCode);
		return list;
	}
	
	public List<SugangDTO> selectGrade(String studentId)throws SQLException{
		List<SugangDTO> list = dao.selectGrade(studentId);
		//if(sugangDTO==null)throw new 
		return list;
	}
	
	
}
