package academy.mvc.view;

import java.util.List;

import academy.mvc.model.dto.BoardDTO;
import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.ReplyDTO;
import academy.mvc.model.dto.StudentDTO;

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
	 * 강의 출력
	 * */
	public static void printCourse(CourseDTO course) {
		System.out.println(course);
		System.out.println();
	}
	
	/**
	 * StudentDTO를 받아 성적 출력
	 * */
	public static void printScoreByStudentId(){
		System.out.println();
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
}
