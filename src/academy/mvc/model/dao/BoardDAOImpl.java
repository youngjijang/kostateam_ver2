package academy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.ReplyDTO;
import academy.mvc.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		
		String sql="select a.BOARD_NO,\r\n"
				+ "       BOARD_CONTENT, \r\n"
				+ "       BOARD_DATE,\r\n"
				+ "		  T_ID,\r\n"
				+ "       REPLY_NO, \r\n"
				+ "       BOARD_PWD,\r\n"
				+ "       REPLY_CONTENT, \r\n"
				+ "       REPLY_WRITER, \r\n"
				+ "       REPLY_PWD\r\n"
				+ "from board a, reply b\r\n"
				+ "where a.board_no = b.board_no(+) \r\n"
				+ "order by a.BOARD_NO";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("BOARD_NO"), 
						rs.getString("BOARD_CONTENT"), 
						rs.getString("BOARD_DATE"), 
						rs.getInt("BOARD_PWD"),
						rs.getInt("REPLY_NO"),
						rs.getString("REPLY_CONTENT"),
						rs.getString("T_ID"),
						rs.getInt("REPLY_PWD"),
						rs.getString("REPLY_WRITER"));
				list.add(dto);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return list;
	}
	
	

	@Override
	public int insertBoard(String content, int boardPwd, String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into board values(board_seq.nextval, ?, sysdate, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, boardPwd);
			ps.setString(3, userId);	
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteBoard(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete board where board_no = ?";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
	
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}



	@Override
	public int replyInsert(String content, int boardNo, String userId, int replyPwd) throws SQLException { 
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into reply values(reply_seq.nextval, ?, ?, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
		
			
			ps.setString(1, content);
			ps.setInt(2, boardNo);
			ps.setString(3, userId);
			ps.setInt(4, replyPwd);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int replyDelete(int boardNo, int replyNo, int replyPwd) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete reply where reply_no = ? and reply_pwd = ?";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, replyNo);
			ps.setInt(2, replyPwd);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}		
				
		return result;
		}



}












