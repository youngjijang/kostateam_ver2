package academy.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.util.DbUtil;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public List<CourseDTO> getCourseList() throws SQLException {
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
	public List<StudentDTO> getStudentList(String teacherId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StudentDTO> list = new ArrayList<>();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"select * from course where course_code in(select course_code from teacher where t_id = ?)");
			rs = ps.executeQuery();
			ps.setString(1, teacherId);

			while (rs.next()) {
				StudentDTO studentDTO = new StudentDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(studentDTO);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}



}
