package academy.mvc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	
	private static Properties proFile = new Properties();
	
	/**
	 * 로드
	 * */
	static {
		try {
			//외부 ~.properties파일로딩
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			//proFile.load(new FileInputStream("resources/board.properties"));			
			Class.forName(proFile.getProperty("driverName"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public static Properties getProFile() {
		return proFile;
	}
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException {
		Connection con=DriverManager.getConnection(
				
				proFile.getProperty("url"),
				proFile.getProperty("userName"),
				proFile.getProperty("userPass")			
				);
		return con;
	}
	
	/**
	 * 닫기(DDl 또는 DML인 경우 - create , insert, update, delete)
	 * */
	public static void dbClose(Connection con , Statement st) {
		try {
			if(st!= null)st.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	/**
	 * 닫기(Select 인경우)
	 * */
	public static void dbClose(Connection con , Statement st,ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			dbClose(con, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
