package academy.mvc.model.dto;

public class SugangDTO {
	private int sNo;
	private String cCode;
	private String sID;
	private int score;
	
	public SugangDTO() {}

	//ㅎ
	public SugangDTO(int sNo, String cCode, String sID, int score) {
		super();
		this.sNo = sNo;
		this.cCode = cCode;
		this.sID = sID;
		this.score = score;
	}
	
	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 수강번호 : ");
		builder.append(sNo);
		builder.append(" , 강의코드 : ");
		builder.append(cCode);
		builder.append(" , 학생아이디 : ");
		builder.append(sID);
		builder.append(" , 성적 : ");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

	
}
