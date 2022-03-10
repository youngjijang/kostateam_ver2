package academy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.ReplyDTO;

public interface BoardDAO {
	/**
	 * 게시판 전체검색
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;

	/**
	 * 게시판 등록하기
	 * 
	 * @throws SQLException
	 */
	int insertBoard(String content, int boardPwd, String userId) throws SQLException;

	/**
	 * 게시판 삭제
	 */
	int deleteBoard(int boardNo) throws SQLException;

	/**
	 * 댓글 등록하기
	 */
	int replyInsert(String content, int boardNo, String writer, int replyPwd) throws SQLException;

	/**
	 * 댓글 삭제하기
	 */
	int replyDelete(int boardNo, int replyNo, int replyPwd) throws SQLException;

}
