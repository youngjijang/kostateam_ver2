package academy.mvc.model.dto;

public class UserDTO {
	
	private String userId;
	private int userPwd;
	private String userName;
	private String userTel;
	  
	public UserDTO() {
		// TODO Auto-generated constructor stubㅎ
	}
	
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
		builder.append("[userId=");
		builder.append(userId);
		builder.append(", userPwd=");
		builder.append(userPwd);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userTel=");
		builder.append(userTel);
		return builder.toString();
	}
	
}
