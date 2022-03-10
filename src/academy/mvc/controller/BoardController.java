package academy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.ReplyDTO;
import academy.mvc.service.BoardService;
import academy.mvc.service.BoardServiceImpl;
import academy.mvc.view.FailView;
import academy.mvc.view.SuccessView;



public class BoardController {
	  private static BoardService boardService = new BoardServiceImpl();
	  	 
	  /**
	    * 전체검색
	    * */
	   public static void boardSelectByAll() {
		   try {
		    List<BoardDTO> list = boardService.boardSelectAll();
		     SuccessView.printBoardList(list);
		   }catch (SQLException e) {
			  //e.printStackTrace();
			  FailView.errorMessage(e.getMessage()); 
		   }
	   }
	   
	   public static void deleteBoard(int deleteNo) {
			try {
				  boardService.deleteBoard(deleteNo);
				  SuccessView.printMessage("삭제되었습니다.");
				}catch (SQLException e) {
					//e.printStackTrace();
					FailView.errorMessage(e.getMessage());
				}
		}
	   
	   public static void insertBoard(String content, int boardPwd, String userId) {
			try {
				   boardService.insertBoard(content,boardPwd,userId);
				   SuccessView.printMessage("등록되었습니다.");
				}catch (SQLException e) {
					//e.printStackTrace();
					FailView.errorMessage(e.getMessage());
				}
			
		}




		public static void replyDelete(int boardNo, int replyNo, int replyPwd) {
			try {
				boardService.replyDelete(boardNo,replyNo,replyPwd);
				 SuccessView.printMessage("댓글이 삭제되었습니다.");
			}catch (SQLException e) {
				e.printStackTrace();
				FailView.errorMessage(e.getMessage());
			}
			
		}
		
		
		/**
		 * 댓글등록하기
		 * */

		  public static void replyInsert(String content, int boardNo, String writer, int replyPwd) { 
			  try {
			       boardService.replyInsert(content,boardNo,writer,replyPwd);  
				}catch (SQLException e) {
					//e.printStackTrace();
					FailView.errorMessage("댓글등록에 실패하였습니다.");
					
				}catch (RuntimeException e) {
					FailView.errorMessage(e.getMessage());
				}
		  }

	

		
		
		


		
	
}
//
