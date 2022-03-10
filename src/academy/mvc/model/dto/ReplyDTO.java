package academy.mvc.model.dto;

public class ReplyDTO {
	
	private int replyNo; 
	private String replecontent; 
	private int replyPwd;
	private String userId;

	
	public ReplyDTO(int replyNo, String replecontent, int replyPwd, String userId) {
		// TODO Auto-generated constructor stub
		super();
		this.replyNo = replyNo;
		this.replecontent = replecontent;
		this.replyPwd = replyPwd;
		this.userId = userId;
	}


	public int getReplyNo() {
		return replyNo;
	}
	
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getReplecontent() {
		return replecontent;
	}


	public void setReplecontent(String replecontent) {
		this.replecontent = replecontent;
	}


	/*
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
*/

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

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyDTO [replyNo=");
		builder.append(replyNo);
		builder.append(", content=");
		builder.append(replecontent);
		builder.append(", boardNo=");
		//builder.append(boardNo);
		builder.append(", writer=");
		//builder.append(writer);
		builder.append(", replyPwd=");
		builder.append(replyPwd);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}