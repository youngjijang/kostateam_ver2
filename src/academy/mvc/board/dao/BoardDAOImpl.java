package academy.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import academy.mvc.model.dto.BoardDTO;
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
		String sql="select * from board order by board_no desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			
				BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5));
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
	public int boardDelete(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete board where board_no = ? and board_pwd = ?";//delete from board where board_no = ?
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


	//댓글등록안됨 ㅠ
	@Override
	public int replyInsert(String content, int boardNo, String writer, int replyPwd) throws SQLException { 
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into reply values(reply_seq.nextval, ?, ?, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
			result = ps.executeUpdate();
			
			ps.setString(1, content);
			ps.setInt(2, boardNo);
			ps.setString(3, writer);
			ps.setInt(4, replyPwd);
			
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
		}finally {
			DbUtil.dbClose(con, ps);
		}		
				
		return replyPwd;
		}
	  


}












