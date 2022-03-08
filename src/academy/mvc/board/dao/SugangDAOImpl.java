package academy.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.util.DbUtil;
//ㅎ
public class SugangDAOImpl implements SugangDAO {
	private Properties proFile = DbUtil.getProFile();
	@Override
	public List<SugangDTO> selectMind(String studentId) throws SQLException {
		List<SugangDTO> list= new ArrayList<SugangDTO>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {	
			con = DbUtil.getConnection();
			String sql ="SELECT * FROM SUGANG WHERE S_ID LIKE ?";//proFile.getProperty("");
			ps= con.prepareStatement(sql);
			ps.setString(1, studentId);		
			rs=ps.executeQuery();		
			
			while(rs.next()) {			
				int sNo =rs.getInt(1);
				String cCode =rs.getString(2);
				String sID =rs.getString(3);
				int score =rs.getInt(4);
				SugangDTO sugangDTO = new SugangDTO(sNo,cCode,sID,score);										
				list.add(sugangDTO);							
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
		
	@Override
	public List<StudentDTO> selectStudentList(String cCode) throws SQLException {
		List<StudentDTO> list= new ArrayList<StudentDTO>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;				
		try {	
			con = DbUtil.getConnection();
			String sql ="SELECT * FROM STUDENT WHERE S_ID IN(SELECT S_ID FROM SUGANG WHERE COURSE_CODE LIKE ?)"; //proFile.getProperty("board.selectAll");
			ps= con.prepareStatement(sql);
			ps.setString(1, cCode);			
			rs=ps.executeQuery();	
				
			while(rs.next()) {			
				String sID =rs.getString(1);
				String sname =rs.getString(3);
				String stel =rs.getString(4);
				String major =rs.getString(5);
				StudentDTO studentDTO = new StudentDTO(sID,sname,stel,major);										
				list.add(studentDTO);							
			}		
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<SugangDTO> selectGrade(String studentId) throws SQLException {
		List<SugangDTO> list= new ArrayList<SugangDTO>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		
		try {	
			con = DbUtil.getConnection();
			String sql ="SELECT C.COURSE_NAME, S.SCORE FROM COURSE C ,SUGANG S WHERE C.COURSE_CODE =(SELECT COURSE_CODE FROM SUGANG WHERE S_ID = ?) AND S.S_ID=?"; //proFile.getProperty("board.selectAll");
			ps= con.prepareStatement(sql);
			ps.setString(1, studentId);		
			ps.setString(2, studentId);	
			rs=ps.executeQuery();				
			if(rs.next()) {			
				
				String cName =rs.getString(1);
				int score =rs.getInt(2);
				SugangDTO sugangDTO = new SugangDTO(cName,score);
				list.add(sugangDTO);
			}		
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;

	}

	@Override
	public int insertScore(String studentId, int score) throws SQLException {
		
		return 0;
	}

	@Override
	public int insertSugang(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delectSugang(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
