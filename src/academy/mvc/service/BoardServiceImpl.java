package academy.mvc.service;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dao.BoardDAO;
import academy.mvc.model.dao.BoardDAOImpl;
import academy.mvc.model.dto.BoardDTO;

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
	public void insertBoard(String content, int boardPwd, String userId) throws SQLException {
		int result = boardDAO.insertBoard(content,boardPwd,userId);
		if(result==0)throw new SQLException("등록되지않았습니다.^^");

	}
	
	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		int result = boardDAO.deleteBoard(boardNo);
		if(result==0)throw new SQLException("삭제되지 않았습니다.");

	}

	@Override
	public void replyInsert(String content, int boardNo, String writer, int replyPwd) throws SQLException  {
	    int result = boardDAO.replyInsert(content,boardNo,writer,replyPwd);
		if(result==0)throw new RuntimeException("댓글 등록에 실패하였습니다.");
	}

	@Override
	public void replyDelete(int boardNo, int replyNo, int replyPwd) throws SQLException {
		int result = boardDAO.replyDelete(boardNo,replyNo,replyPwd);
		if(result==0)throw new RuntimeException("댓글 삭제에 실패하였습니다.");
	}


}



























