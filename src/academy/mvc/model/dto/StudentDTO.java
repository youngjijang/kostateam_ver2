package academy.mvc.model.dto;

public class StudentDTO extends UserDTO {

	private String major;//ㅎ
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String userId, String userName, String userTel, String major) {
		super(userId, userName, userTel);
		this.major = major;
		
	}
	public StudentDTO(String userId, int userPwd, String userName, String userTel, String major) {
		super(userId, userPwd, userName, userTel);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student"+super.toString()+", major="+major;
	}
	
}
