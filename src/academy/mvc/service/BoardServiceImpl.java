package academy.mvc.service;


import java.sql.SQLException;
import java.util.List;

import academy.mvc.board.dao.BoardDAO;
import academy.mvc.board.dao.BoardDAOImpl;
import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.ReplyDTO;

public class BoardServiceImpl implements BoardService {
   private BoardDAO boardDAO = new BoardDAOImpl();
   
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		 List<BoardDTO>  list = boardDAO.boardSelectAll();
		 //dao에 나온 결과를 가지고 제어
		 if(list.size()==0 || list.isEmpty()) {
			 throw new SQLException("게시물의 정보가 없어 검색할수 없습니다.");
		 }
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list.isEmpty()) throw new SQLException(keyWord+"단어를 포함한 레코드의 정보 없습니다.");
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if(boardDTO==null)throw new SQLException(boardNo+"해당하는 정보가 없습니다.");
		return boardDTO;
	}

	
	@Override
	public void insertBoard(String content, int boardPwd, String userId) throws SQLException {
		int result = boardDAO.insertBoard(content,boardPwd,userId);
		if(result==0)throw new SQLException("등록되지않았습니다.^^");

	}
	

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.boardUpdate(boardDTO);
		if(result==0)throw new SQLException("수정되지 않았습니다.");

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		int result = boardDAO.boardDelete(boardNo);
		if(result==0)throw new SQLException("삭제되지 않았습니다.");

	}

	@Override
	public void replyInsert(String content, int boardNo, String writer, int replyPwd) throws SQLException  {
	    int result = boardDAO.replyInsert(content,boardNo,writer,replyPwd);
		if(result==0)throw new RuntimeException("댓글 등록에 실패하였습니다.");
	}

	@Override
	public void replyDelete(int boardNo, int replyNo, int replyPwd) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

	

}



























