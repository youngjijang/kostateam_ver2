package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.ReplyDTO;



public interface BoardService {
	/**
	 * 모든 레코드 검색
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;

	/**
	 * 제목에 특정문자열 포함한 레코드 검색
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

	/**
	 * 글번호에 해당하는 레코드 검색
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;

	
	

	/**
	 * 게시물 수정
	 */
	void boardUpdate(BoardDTO boardDTO) throws SQLException;

	/**
	 * 게시물 삭제
	 */
	void boardDelete(int boardNo) throws SQLException;
	
	/**
	 * 게시물 등록 
	 * @throws SQLException 
	 */
	void insertBoard(String content, int boardPwd, String userId) throws SQLException;
	
	/**
	 * 댓글 삭제하기
	 * */
	 void replyDelete(int boardNo, int replyNo, int replyPwd)throws SQLException;
	 
	/**
	 * 댓글등록하기
	* */	

	void replyInsert(String content, int boardNo, String writer, int replyPwd)throws SQLException;

	
}
