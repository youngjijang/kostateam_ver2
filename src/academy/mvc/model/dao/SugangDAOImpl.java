package academy.mvc.model.dao;

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
		List<SugangDTO> list = new ArrayList<SugangDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT * FROM SUGANG WHERE S_ID LIKE ?";// proFile.getProperty("");
			ps = con.prepareStatement(sql);
			ps.setString(1, studentId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int sNo = rs.getInt(1);
				String cCode = rs.getString(2);
				String sID = rs.getString(3);
				int score = rs.getInt(4);
				SugangDTO sugangDTO = new SugangDTO(sNo, cCode, sID, score);
				list.add(sugangDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<StudentDTO> selectStudentList(String teacherID) throws SQLException {
		List<StudentDTO> list = new ArrayList<StudentDTO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT * FROM STUDENT WHERE S_ID IN(SELECT S_ID FROM SUGANG WHERE COURSE_CODE LIKE (SELECT COURSE_CODE FROM TEACHER WHERE T_ID = ?))"; // proFile.getProperty("board.selectAll");
			ps = con.prepareStatement(sql);
			ps.setString(1, teacherID);
			rs = ps.executeQuery();

			while (rs.next()) {
				String sID = rs.getString(1);
				String sname = rs.getString(3);
				String stel = rs.getString(4);
				String major = rs.getString(5);
				StudentDTO studentDTO = new StudentDTO(sID, sname, stel, major);
				list.add(studentDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<SugangDTO> selectGrade(String studentId) throws SQLException {
		List<SugangDTO> list = new ArrayList<SugangDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConnection();
			String sql = "select course_name, score from sugang join course using(course_code) where s_id = ?"; // proFile.getProperty("board.selectAll");
			ps = con.prepareStatement(sql);
			ps.setString(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {

				String cName = rs.getString(1);
				int score = rs.getInt(2);
				SugangDTO sugangDTO = new SugangDTO(cName, score);
				list.add(sugangDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;

	}

	@Override
	public List<SugangDTO> selectStudentWithScoreList(String teacherId) throws SQLException {
		List<SugangDTO> list = new ArrayList<SugangDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select sugang_no, course_code, s_id, s_name, s_tel, s_major, score from student join sugang using(s_id) where course_code in (select course_code from teacher where t_id = ?) order by sugang_no";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, teacherId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int sNo = rs.getInt(1);
				String cCode = rs.getString(2);
				String sId = rs.getString(3);
				String sName = rs.getString(4);
				String sTel = rs.getString(5);
				String sMajor = rs.getString(6);
				int score = rs.getInt(7);

				SugangDTO sugangDTO = new SugangDTO(sNo, cCode, sId, sName, sTel, sMajor, score);
				list.add(sugangDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public int updateScore(String studentId, int score, String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update sugang set score = ? where s_id = ? and course_code = (select course_code from teacher where t_id = ?)";// (select

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, score);
			ps.setString(2, studentId);
			ps.setString(3, userId);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;

	}

	@Override
	public int insertSugang(String studentId, String cCode) throws SQLException {	
		List<String> listCount = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs2 = null;
		ResultSet rs1 = null;
		ResultSet rs = null;
		int capa = 0 ;
		int result = 0;	
		String sql4 = "select course_capa from course where course_code = ?";
		String sql3 = "select course_code from sugang where course_code = ?";
		String sql2 = "select course_code from sugang where s_id =?";
		String sql = "insert into sugang values(sugang_seq.nextval, ?, ?, null)";// proFile.getProperty("");
		try {
			con = DbUtil.getConnection();
			
			
			ps3= con.prepareStatement(sql4);
			ps3.setString(1,cCode);
			rs2 = ps3.executeQuery();
			if(rs2.next()) {
				capa = rs2.getInt(1);	
			}
	
			ps2 = con.prepareStatement(sql3);
			ps2.setString(1,cCode);
			rs1 = ps2.executeQuery();
			while(rs1.next()) {
				String code = rs1.getString(1);
				listCount.add(code);
			}
		
			ps = con.prepareStatement(sql2);
			ps.setString(1,studentId);			
			rs = ps.executeQuery();

			while (rs.next()) {
				String courseCode = rs.getString(1);	
				list.add(courseCode);
			}
			
			if(!list.contains(cCode) &&  listCount.size()<capa) {
				ps1 = con.prepareStatement(sql);
				ps1.setString(1, cCode);
				ps1.setString(2, studentId);
				result = ps1.executeUpdate();
				return result;			
			}
			return result;
			
		} finally {
			DbUtil.dbClose(null, ps3,rs2);
			DbUtil.dbClose(null, ps2,rs1);
			DbUtil.dbClose(null, ps,rs);
			DbUtil.dbClose(con, ps1);
		}
		
	}

	@Override
	public int delectSugang(String studentId, String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete sugang where s_id = ? and course_code = ?";// proFile.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, studentId);
			ps.setString(2, cCode);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
