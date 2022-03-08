package academy.mvc.model.dto;

public class BoardDTO {
	private int boardNo; // 글번호
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String boardDate; // 등록일

	
	public BoardDTO() {}

	
	public BoardDTO(int boardNo, String subject, String writer, String content, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.boardDate = boardDate;
	}


	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("board [boardNo=");
		builder.append(boardNo);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardDate=");
		builder.append(boardDate);
		builder.append("]");
		return builder.toString();
	}


	public ReplyDTO[] getReplyList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
