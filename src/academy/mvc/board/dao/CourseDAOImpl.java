package academy.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.util.DbUtil;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public List<CourseDTO> selectAllCousre() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from course");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CourseDTO courseDTO = new CourseDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				list.add(courseDTO);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<CourseDTO> selectMind(String teacherId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCourse(CourseDTO course) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
