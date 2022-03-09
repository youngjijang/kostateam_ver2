package academy.mvc.model.dto;

public class ReplyDTO {
	
	private int replyNo; 
	private String content; 
	private int boardNo;  
	private String writer;
	private int replyPwd;
	private String userId;


	public ReplyDTO() {}


	public ReplyDTO(int replyNo, String content, int boardNo, String writer, int replyPwd, String userId) {
		super();
		this.replyNo = replyNo;
		this.content = content;
		this.boardNo = boardNo;
		this.writer = writer;
		this.replyPwd = replyPwd;
		this.userId = userId;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getReplyPwd() {
		return replyPwd;
	}


	public void setReplyPwd(int replyPwd) {
		this.replyPwd = replyPwd;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyDTO [replyNo=");
		builder.append(replyNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", replyPwd=");
		builder.append(replyPwd);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}