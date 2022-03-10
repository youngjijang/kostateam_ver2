package academy.mvc.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import academy.mvc.model.dao.UserDAO;
import academy.mvc.model.dao.UserDAOImpl;
import academy.mvc.model.dto.UserDTO;
import academy.mvc.session.Session;
import academy.mvc.session.SessionSet;


public class UserService {
	UserDAO userDao = new UserDAOImpl();
	
	Map<String,UserDTO> user = new HashMap<String, UserDTO>();
	
	
	public UserDTO userLogin(String userId, int userPwd, String kind) throws SQLException,NullPointerException{
		
		UserDTO now = userDao.userLogin(userId, userPwd, kind);
		
		if(now == null) {
			throw new NullPointerException("정보를 다시 확인해주세요.");
		}
		
		Session session = new Session(userId);
		
		
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);
		
		
		user.put(kind, now);
		//System.out.println(now);
		
		return now;
	}
	
	
	public void userJoin(String kind, String userId, int userPwd, String userName, String userTel, String thing) throws SQLException {
		if(userDao.idCheck(kind, userId)) {
			throw new SQLException("중복된id입니다.");
		}else {
			if(userDao.userJoin(kind, userId, userPwd, userName, userTel, thing)==0){
				throw new SQLException("회원가입이 정상 완료되지않았습니다.");
			}
		}	
	}
	
	public UserDTO showInfo (String kind, String userId) throws NullPointerException{
		UserDTO now = user.get(kind);
		//System.out.println(now);
		if(now.getUserId().equals(userId)) {
			return now;
		}else {
			throw new NullPointerException("정보찾기에 실패했습니다.");
		}
		
	}
	
	public void updateUser(String kind, String userId, String newTel) throws SQLException {
		if(userDao.updateUser(userId, kind, newTel)==0){
			throw new SQLException("수정되지않았습니다.");
		}else {
			user.get(kind).setUserTel(newTel);
		}
	}
	
	public void deleteUser(String kind, String uesrId) throws SQLException{
		if(userDao.deleteUser(uesrId, kind)==0) {
			throw new SQLException("삭제되지않았습니다.");
		}
	}
}

