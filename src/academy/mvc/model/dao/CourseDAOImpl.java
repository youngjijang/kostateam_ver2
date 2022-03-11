package academy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.util.DbUtil;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public boolean cCodeCheck(String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			con = DbUtil.getConnection();

			ps = con.prepareStatement("select count(*) from course where course_code=?");
			ps.setString(1, cCode);
	
			rs = ps.executeQuery();
	
			if (rs.next()) {
				if (rs.getInt(1) == 0)
					result= false;
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

	@Override
	public List<CourseDTO> selectCourseList() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<>();
		String sql = "select course_code, course_name, t_name, course_capa, course_hour, course_content, to_char(course_start, 'YYYY-MM-DD'), to_char(course_end, 'YYYY-MM-DD') "
				+ "FROM course left JOIN teacher USING (course_code)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CourseDTO courseDTO = new CourseDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				list.add(courseDTO);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<CourseDTO> selectTeacherCourse(String teacherId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<>();
		String sql = "select * from course where course_code in(select course_code from teacher where t_id = ?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, teacherId);

			rs = ps.executeQuery();

			while (rs.next()) {
				CourseDTO courseDTO = new CourseDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(courseDTO);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public CourseDTO selectCartCourse(String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CourseDTO courseDTO = null;
		try {
			con = DbUtil.getConnection();
			String sql = "SELECT * FROM COURSE WHERE COURSE_CODE = ?";// proFile.getProperty("");
			ps = con.prepareStatement(sql);
			ps.setString(1, cCode);
			rs = ps.executeQuery();

			if (rs.next()) {
				String coCode = rs.getString(1);
				String cName = rs.getString(2);
				int cCapa = rs.getInt(3);
				int cHour = rs.getInt(4);
				;
				String cContent = rs.getString(5);
				String cStart = rs.getString(6);
				String cEnd = rs.getString(7);
				courseDTO = new CourseDTO(coCode, cName, cCapa, cHour, cContent, cStart, cEnd);

			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return courseDTO;
	}

	@Override
	public int insertCourse(CourseDTO courseDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into course values(?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, courseDTO.getcCode());
			ps.setString(2, courseDTO.getcName());
			ps.setInt(3, courseDTO.getcCapa());
			ps.setInt(4, courseDTO.getcHour());
			ps.setString(5, courseDTO.getcContent());
			ps.setString(6, courseDTO.getcStart());
			ps.setString(7, courseDTO.getcEnd());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int updateCourse(String cCode, String cContent) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update course set course_content = ? where course_code = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, cContent);
			ps.setString(2, cCode);

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int deleteCourse(String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int result = 0;
		String sql = "delete course where course_code = ?";
		ResultSet rs = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select count(*) from teacher full join sugang using(course_code)  where course_code=?");
			ps.setString(1, cCode);
	
			rs = ps.executeQuery();
	
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					
					ps2 = con.prepareStatement(sql);
					ps2.setString(1, cCode);
		
					result = ps2.executeUpdate();
				}
			}
			 

		} finally {
			DbUtil.dbClose(con, ps,rs);
		}

		return result;
	}
	
	@Override
	public int choiceTeacher(String teacherId, String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update teacher set course_code = ? where t_id = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, cCode);
			ps.setString(2, teacherId);

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}
	
	
	/**
	 * 강사 지정 강의코드 중복체크
	 */
	@Override
	public boolean tCourseCode(String cCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			con = DbUtil.getConnection();

			ps = con.prepareStatement("select count(*) from teacher where course_code=?");
			ps.setString(1, cCode);
	
			rs = ps.executeQuery();
	
			if (rs.next()) {
				if (rs.getInt(1) == 0)
					result= false;
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

}
