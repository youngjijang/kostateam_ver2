package academy.mvc.model.dao;

import java.sql.SQLException;

import academy.mvc.model.dto.UserDTO;

public interface UserDAO {

	/**
	 * 중복체크
	 * 
	 * @param kind
	 * @param userId
	 */
	boolean idCheck(String kind, String userId) throws SQLException;

	/**
	 * 로그인 - 로그인이 되면 SessionSet객체안에 있는 Set에 Session을 저장한다 강사일 경우 kind = teacher, 학생일
	 * 경우 kind = student 로 픽스
	 * 
	 * @param userId, userPwd ,kind
	 * @return User
	 */
	UserDTO userLogin(String userId, int userPwd, String kind) throws SQLException;

	/**
	 * 회원가입 강사일 경우 kind = teacher, 학생일 경우 kind = student 로 픽스
	 */
	int userJoin(String kind, String userId, int userPwd, String userName, String userTel, String thing)
			throws SQLException;

	/**
	 * 아이디를 입력받아 개인정보 업데이트
	 * 
	 * @param userId, kind, newTel
	 * @return 0이면 실패
	 */
	int updateUser(String userId, String kind, String newTel) throws SQLException;

	/**
	 * 아이디를 입력받아 개인정보를 삭제한다.
	 * 
	 * @param userId, kind
	 * @return 0이면 실패
	 */
	int deleteUser(String userId, String kind) throws SQLException;
}
