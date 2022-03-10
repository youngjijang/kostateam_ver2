package academy.mvc.model.dto;

public class UserDTO {
	
	private String userId;
	private int userPwd;
	private String userName;
	private String userTel;
	  
	public UserDTO() {}
	
	public UserDTO(String userId, String userName, String userTel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTel = userTel;
	}

	public UserDTO(String userId, int userPwd, String userName, String userTel) {
		this(userId,userName,userTel);
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(int userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(" 개인정보++++");
		builder.append("\n");
		builder.append("아이디: ");
		builder.append(userId);
		builder.append("\n");
		builder.append("이름: ");
		builder.append(userName);
		builder.append("\n");
		builder.append("연락처: ");
		builder.append(userTel);
		builder.append("\n");
		return builder.toString();
	}
	
}
