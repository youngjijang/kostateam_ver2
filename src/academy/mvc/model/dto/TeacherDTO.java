package academy.mvc.model.dto;

public class TeacherDTO extends UserDTO {
	private String courseCode;
	
	public TeacherDTO() {
		// TODO Auto-generated constructor stubㅎ
	}

	public TeacherDTO(String userId, int userPwd, String userName, String userTel,String courseCode) {
		super(userId, userPwd, userName, userTel);
		this.courseCode = courseCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "++++강사"+super.toString()+"강의 코드: "+courseCode;
	}
	
	
	

}
