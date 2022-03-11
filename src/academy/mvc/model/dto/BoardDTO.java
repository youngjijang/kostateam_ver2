package academy.mvc.model.dto;

import java.util.List;

public class BoardDTO extends ReplyDTO {
	private int boardNo; // 글번호
	private String content; // 내용
	private String boardDate; // 등록일
	private int boardPwd;//비번
	private String writer; // 작성자
	
	private int replyNo; 
	private String replecontent; 
	private int replyPwd;
	private String userId;
	
	public BoardDTO(int boardNo, String content, String boardDate, int boardPwd, int replyNo, String replecontent,  String userId,int replyPwd,String writer) {
		super(replyNo, replecontent, replyPwd, userId);
		this.replyNo = replyNo;
		this.replecontent = replecontent;
		this.replyPwd = replyPwd;
		this.writer =writer;
		this.userId = userId;
		this.boardNo = boardNo;
		this.content = content;
		this.boardDate = boardDate; 
		this.boardPwd = boardPwd;
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

	@Override
	public String toString() {
		super.toString();
		StringBuilder builder = new StringBuilder();
		builder.append("BoardDTO [boardNo=");
		builder.append(boardNo);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardDate=");
		builder.append(boardDate);
		builder.append(", boardPwd=");
		builder.append(boardPwd);
		builder.append(", replyNo=");
		builder.append(replyNo);
	
		builder.append(", replecontent=");
		builder.append(replecontent);
		builder.append(", replyPwd=");
		builder.append(replyPwd);
		builder.append(", writer=");
		builder.append(writer);
		builder.append("]");
		
		return builder.toString();
	}

	public ReplyDTO[] getReplyList() {
		// TODO Auto-generated method stub
		return null;
	}

}
