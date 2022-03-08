package academy.mvc.model.dto;

import java.util.List;

public class BoardDTO {
	private int boardNo; // 글번호
	private String content; // 내용
	private String boardDate; // 등록일
	private int boardPwd;//비번
	private String writer; // 작성자

	private List<ReplyDTO> repliesList ;
	
	public BoardDTO() {}


	public BoardDTO(int boardNo, String content, String boardDate, int boardPwd, String writer) {
		super();
		this.boardNo = boardNo;
		this.content = content;
		this.boardDate = boardDate;
		this.boardPwd = boardPwd;
		this.writer = writer;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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


	public int getBoardPwd() {
		return boardPwd;
	}


	public void setBoardPwd(int boardPwd) {
		this.boardPwd = boardPwd;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}

	public List<ReplyDTO> getReplyList() {
		return repliesList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardDTO [boardNo=");
		builder.append(boardNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardDate=");
		builder.append(boardDate);
		builder.append(", boardPwd=");
		builder.append(boardPwd);
		builder.append(", writer=");
		builder.append(writer);
		builder.append("]");
		return builder.toString();
	}
	
	
}
