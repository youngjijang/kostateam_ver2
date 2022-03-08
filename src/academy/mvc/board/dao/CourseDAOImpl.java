package academy.mvc.board.dao;

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
	public List<CourseDTO> selectCourseList() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<>();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from course");
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
	public List<CourseDTO> selectTeacherCourse(String teacherId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<>();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"select * from course where course_code in(select course_code from teacher where t_id = ?)");
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

}
