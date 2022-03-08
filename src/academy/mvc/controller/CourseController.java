package academy.mvc.controller;

import java.util.List;

import academy.mvc.model.dto.CourseDTO;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.service.CourseService;
import academy.mvc.view.FailView;
import academy.mvc.view.SuccessView;

public class CourseController {
	static CourseService courseService = new CourseService();

	/**
	 * 전체 강의 목록리턴
	 */
	public static void getCourseList() {
		try {
			List<CourseDTO> list = courseService.getCourseList();
			SuccessView.printCourseList(list);

		} catch (Exception e) {
//			 e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}

	}

	/**
	 * 강사 ID 받아서 해당 강사의 강의를 수강하는 학생 목록 리턴
	 * 
	 * @return
	 */
	public static List<StudentDTO> getStudentList() {
		try {
			StudentDTO studentDTO = new StudentDTO();
			List<StudentDTO> list = courseService.getStudentList(studentDTO.getUserName());

			SuccessView.printStudentList(list);

		} catch (Exception e) {
//			 e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return null;

	}



}
