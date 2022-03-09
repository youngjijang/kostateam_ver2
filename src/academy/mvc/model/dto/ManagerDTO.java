package academy.mvc.model.dto;

public class ManagerDTO extends UserDTO {

	private String task;
	
	public ManagerDTO() {
		// TODO Auto-generated constructor stub
	}

	public ManagerDTO(String userId, int userPwd, String userName, String userTel, String task) {
		super(userId, userPwd, userName, userTel);
		this.task = task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "++++매니저"+super.toString()+"담당 업무: "+ task;
	}

	
}
