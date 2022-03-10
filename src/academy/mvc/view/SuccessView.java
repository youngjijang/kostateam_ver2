package academy.mvc.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.ReplyDTO;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.SugangDTO;
import academy.mvc.model.dto.UserDTO;


public class SuccessView {
    /**
	 * 강의 list 검색
	 * @param list
	 * */
	public static void printCourseList(List<CourseDTO> list){
		System.out.println("---------강의 " + list.size() + "---------");
		for(CourseDTO course: list) {
			System.out.println(course);
		}
		
		System.out.println();
	}
	
	/**
	 * 수강중인 과목 list 검색
	 * */
	public static void printSugangList(List<SugangDTO> list) {
		System.out.println("---------수강과목 " + list.size() + "---------");
		for (SugangDTO sugangDTO : list) {
			System.out.println(sugangDTO);
		}
		
	}
	
	
	/**
	 * 강의 출력
	 * */
	public static void printCourse(CourseDTO course) {
		System.out.println(course);
		System.out.println();
	}

	/**
	 * StudentDTO를 받아 성적 출력
	 * */
	public static void printScoreByStudentId(List<SugangDTO> list){
		for (SugangDTO sugangDTO : list) {
			System.out.println("과목 : "+sugangDTO.getcName()+" , 성적 : "+sugangDTO.getScore());
		}
		
	}
	
	/**
	 * 학생 list 출력
	 * */
	public static void printStudentList(List<StudentDTO> list) {
		for(StudentDTO student : list) {
			System.out.println(student);
		}
		System.out.println();
	}
	
	/**
	 * 학생 출력
	 * */
	public static void printStudent(StudentDTO student) {
		System.out.println(student);
		System.out.println();
	}
	
	/**
	 * 강사별 학생+성적 출력
	 * */
	public static void printAllScorebyTeacherId(List<SugangDTO> list) {
		for(SugangDTO sugang : list) {
			System.out.println(sugang);
		}
		System.out.println();
		
	}
	
	/**
	 * 게시글 list 출력
	 * */
	public static void printBoardList(List<BoardDTO> list) {
		for(BoardDTO Board : list) {
			System.out.println(Board);
		}
		System.out.println();
	}

	/**
	 * 글번호로 게시글과 댓글 출력
	 * */
	public static void printBoardWithReply(BoardDTO board){
		System.out.println(board);
		for(ReplyDTO reply : board.getReplyList()){
			System.out.println(reply);
		}
	}
	
	/**
	 * 성공 메시지 출력
	 * */
	public static void printMessage(String message){
		System.out.println(message);
	}
	
	/**
	 * 개인정보 출력
	 */
	public static void printUserInfo(UserDTO user) {
		System.out.println(user);
	}
	
	/**
	 *장바구니
	 * */
	public static void printViewCart(String id , Map<CourseDTO,String> cart) {
		for(CourseDTO courseDTO: cart.keySet()) {
		String cCode = courseDTO.getcCode();//강의번호
		String cName = courseDTO.getcName();//강의이름
		String cContent = courseDTO.getcContent();//내용
		
		
		System.out.println(cCode+" : "+cName+" : "+cContent);
		}
	
	}

	
	
}
