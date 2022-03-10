package academy.mvc.model.dto;

public class SugangDTO {
	private int sNo;
	private String cName;
	private String cCode;
	private String sID;
	private int score;
	
	private String sName;
	private String sTel;
	private String sMajor;
	
	public SugangDTO() {}
	
	
	public SugangDTO(String cName, int score) {
		super();
		this.cName = cName;
		this.score = score;
	}


	public SugangDTO(int sNo, String cCode, String sID, int score) {
		super();
		this.sNo = sNo;
		this.cCode = cCode;
		this.sID = sID;
		this.score = score;
	}
	
	public SugangDTO(int sNo, String cCode, String sID, String sName, String sTel, String sMajor, int score) {
		this(sNo, cCode,sID, score);
		this.sName = sName;
		this.sTel = sTel;
		this.sMajor = sMajor;
	}
	
	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
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
