package academy.mvc.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import academy.mvc.board.dao.UserDAO;
import academy.mvc.board.dao.UserDAOImpl;
import academy.mvc.model.dto.UserDTO;
import academy.mvc.session.Session;
import academy.mvc.session.SessionList;

public class UserService {
	UserDAO userDao = new UserDAOImpl();
	
	Map<String,UserDTO> user = new HashMap<String, UserDTO>();
	
	
	public UserDTO userLogin(String userId, int userPwd, String kind) throws SQLException,NullPointerException{
		UserDTO now = userDao.userLogin(userId, userPwd, kind);
		if(user == null) {
			throw new NullPointerException("정보를 다시 확인해주세요.");
		}
		
		//Session session = new Session(userId);
		
		
		//SessionSet sessionSet = SessionSet.getInstance();
		//sessionSet.add(session);
		
		
		user.put(kind, now);
		//System.out.println(user);
		
		return now;
	}
	
	
	public UserDTO showInfo (String kind, String userId) throws NullPointerException{
		UserDTO now = user.get(kind);
		if(now.getUserId()==userId) {
			return now;
		}else {
			throw new NullPointerException("정보찾기에 실패했습니다.");
		}
		
	}
	
	public void updateUser(String kind, String userId, String newTel) throws SQLException {
		if(userDao.updateUser(userId, kind, newTel)==0){
			throw new SQLException("수정되지않았습니다.");
		}
	}
	
	public void deleteUser(String kind, String uesrId) throws SQLException{
		if(userDao.deleteUser(uesrId, kind)==0) {
			throw new SQLException("삭제되지않았습니다.");
		}
	}
}
