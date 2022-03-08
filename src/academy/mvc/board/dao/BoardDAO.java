package academy.mvc.board.dao;


import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.ReplyDTO;

public interface BoardDAO {
	/**
	 * 게시판 전체검색
	 */
	List<BoardDTO> boardSelectAll() throws SQLException ;
	
	/**
	 * 제목 레코드 검색
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;
	
	
	/**
	 * 번호선택
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException ;
	
	
	
	/**
	 * 게시판 등록하기
	 */
	int boardInsert(BoardDTO boardDTO) throws SQLException;
	
	
	/**
	 * 게시판 수정하기
	 */
	int boardUpdate(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * 게시판 삭제
	 */
	int boardDelete(int boardNo) throws SQLException;
	
	/**
	 * 댓글 등록하기
	 * */
	int replyInsert(ReplyDTO replyDTO) throws SQLException;
	
}
