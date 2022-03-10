package academy.mvc.model.dto;

public class CourseDTO {
	private String cCode;
	private String cName;
	private int cCapa;
	private int cHour;
	private String cContent;
	private String cStart;
	private String cEnd;
	private String tName;
	
	public CourseDTO() {
	}

	public CourseDTO(String cCode, String cName, int cCapa, int cHour, String cContent, String cStart, String cEnd) {
		super();
		this.cCode = cCode;
		this.cName = cName;
		this.cCapa = cCapa;
		this.cHour = cHour;
		this.cContent = cContent;
		this.cStart = cStart;
		this.cEnd = cEnd;
	}
	
	public CourseDTO(String cCode, String cName, String tName, int cCapa, int cHour, String cContent, String cStart, String cEnd) {
		this(cCode, cName, cCapa, cHour, cContent, cStart, cEnd);
		this.tName = tName;
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

	public String getcStart() {
		return cStart;
	}

	public void setcStart(String cStart) {
		this.cStart = cStart;
	}

	public String getcEnd() {
		return cEnd;
	}

	public void setcEnd(String cEnd) {
		this.cEnd = cEnd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[강의코드 : ");
		builder.append(cCode);
		builder.append(" , 강의명 : ");
		builder.append(cName);
		builder.append(" , 강사명 : ");
		builder.append(tName);
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
