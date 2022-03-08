package academy.mvc.model.dto;

public class ReplyDTO {
	
	private int replyNo; //댓글번호
	private String replyContent; //댓글내용
	private int boardNo; //글번호 
	private String replyName;//글쓴이
	private int replyPwd;//비번
	private String replyRegdate;

	  
	public ReplyDTO() {}
	
	
	public ReplyDTO(int replyNo, String replyContent, int boardNo, String replyName, int replyPwd) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.boardNo = boardNo;
		this.replyName = replyName;
		this.replyPwd = replyPwd;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getReplyName() {
		return replyName;
	}


	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}


	public int getReplyPwd() {
		return replyPwd;
	}


	public void setReplyPwd(int replyPwd) {
		this.replyPwd = replyPwd;
	}


	public String getReplyRegdate() {
		return replyRegdate;
	}


	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}
	  
}