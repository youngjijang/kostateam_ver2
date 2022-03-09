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

	/**
	 * 강의 등록
	 */
	public static void insertCourse(CourseDTO courseDTO) {
		try {
			courseService.insertCourse(courseDTO);
			SuccessView.printMessage("강의 등록에 성공하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 강의 수정
	 */
	public static void updateCourese(String cCode, String cContent) {
		try {
			courseService.updateCourse(cCode, cContent);
			SuccessView.printMessage("강의 수정에 성공하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 강의 삭제
	 */
	public static void deleteCourse(String cCode) {
		try {
			courseService.deleteCourse(cCode);
			SuccessView.printMessage("강의 삭제에 성공하였습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}
