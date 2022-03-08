package academy.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.TeacherDTO;
import academy.mvc.model.dto.UserDTO;
import academy.mvc.util.DbUtil;
//ㅎ
public class UserDAOImpl implements UserDAO {

	@Override
	public UserDTO userLogin(String userId, int userPwd, String kind) throws SQLException {
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 UserDTO user = null;
		 try {
			   con = DbUtil.getConnection();
		        
		        if(kind == "teacher") {
		        	ps= con.prepareStatement("select * from teacher where t_id=? and t_pwd=?");
					ps.setString(1, userId);
					ps.setInt(2, userPwd);
					   
			        rs = ps.executeQuery(); 
		        	if(rs.next()) {
		        		user = new TeacherDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) );
		        	}
		        }else {
		        	ps= con.prepareStatement("select * from student where s_id=? and s_pwd=?");
					ps.setString(1, userId);
					ps.setInt(2, userPwd);
					   
			        rs = ps.executeQuery(); 
		        	if(rs.next()) {
			        	user = new StudentDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) );
			        }
		        }
		        
	        }finally {
	        	DbUtil.dbClose(con, ps, rs);
	        }
		return user;
	}
	
	
	@Override
	public int updateUser(String userId, String kind, String newTel) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try {
			if(kind.equals("teacher")) {
				con = DbUtil.getConnection();
				ps= con.prepareStatement("update teacher set t_tel = ? where t_id= ?");
				ps.setString(1, newTel);
				ps.setString(2, userId);

			}else if(kind.equals("student")){
				
				con = DbUtil.getConnection();
				ps= con.prepareStatement("update student set s_tel = ? where s_id= ?");
				ps.setString(1, newTel);
				ps.setString(2, userId);
				
			}else {
				throw new SQLException();
			}

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteUser(String userId, String kind) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			
			
			if(kind == "teacher") {
				ps= con.prepareStatement("delete from teacher where t_id= ?");
				ps.setString(1, userId);
				result = ps.executeUpdate();
	        }else {
	        	ps= con.prepareStatement("delete from student where s_id= ?");
				ps.setString(1, userId);
				result = ps.executeUpdate();
	        }
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
