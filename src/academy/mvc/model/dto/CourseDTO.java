package academy.mvc.model.dto;

//ㅎ
public class CourseDTO {
	private String cCode;
	private String cName;
	private int cCapa;
	private int cHour;
	private String cContent;
	private int cStart;
	private int cEnd;
	

	public CourseDTO() {}


	public CourseDTO(String cCode, String cName, int cCapa, int cHour, String cContent, int cStart, int cEnd) {
		super();
		this.cCode = cCode;
		this.cName = cName;
		this.cCapa = cCapa;
		this.cHour = cHour;
		this.cContent = cContent;
		this.cStart = cStart;
		this.cEnd = cEnd;
	}


	public String getcCode() {
		return cCode;
	}


	public void setcCode(String cCode) {
		this.cCode = cCode;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public int getcCapa() {
		return cCapa;
	}


	public void setcCapa(int cCapa) {
		this.cCapa = cCapa;
	}


	public int getcHour() {
		return cHour;
	}


	public void setcHour(int cHour) {
		this.cHour = cHour;
	}


	public String getcContent() {
		return cContent;
	}


	public void setcContent(String cContent) {
		this.cContent = cContent;
	}


	public int getcStart() {
		return cStart;
	}


	public void setcStart(int cStart) {
		this.cStart = cStart;
	}


	public int getcEnd() {
		return cEnd;
	}


	public void setcEnd(int cEnd) {
		this.cEnd = cEnd;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[강의코드 : ");
		builder.append(cCode);
		builder.append(" , 강의명 : ");
		builder.append(cName);
		builder.append(" , 수강인원 : ");
		builder.append(cCapa);
		builder.append(" , 시간 : ");
		builder.append(cHour);
		builder.append(" , 내용 : ");
		builder.append(cContent);
		builder.append(" , 시작 : ");
		builder.append(cStart);
		builder.append(" , 끝 : ");
		builder.append(cEnd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
