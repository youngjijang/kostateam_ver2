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
	public static void selectCourseList() {
		try {
			List<CourseDTO> list = courseService.selectCourseList();
			SuccessView.printCourseList(list);

		} catch (Exception e) {
//			 e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}

	}

	/**
	 * 내 강의 조회-강사
	 */
	public static void selectTeacherCourse(String teacherId) {
		try {
			List<CourseDTO> list = courseService.selectTeacherCourse(teacherId);
			SuccessView.printCourseList(list);
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}
