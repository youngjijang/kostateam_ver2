package academy.mvc.view;

import java.util.List;

import academy.mvc.controller.CourseController;
import academy.mvc.controller.SugangController;
import academy.mvc.controller.UserController;
import academy.mvc.model.dto.StudentDTO;
import academy.mvc.model.dto.UserDTO;

public class MenuView {
    public static void studentMenu(String userId){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("-------------------------------학생 메뉴-----------------------------");
			System.out.println("1.강의목록 2.수강신청 3.성적확인 4.개인정보확인 5.개인정보수정 9.로그아웃");
			int menuNo = StartView.sc.nextInt();
			switch(menuNo) {
				case 1 :
					CourseController.getCourseList();
					break;
					
				case 2 :
					//수강코드 키보드입력받음
					String courseCode = StartView.sc.nextLine();
					CourseController.insertSugang(courseCode);
					break;
					
				case 3 :
					//SugangController.selectScore();
					break;
					
				case 4 :
					UserController.showUser("student", userId);
					break;
					
				case 5 :
					//연락처 키보드 입력받음
					System.out.println("변경할 연락처> ");
					String newTel = StartView.sc.nextLine();
					UserController.updateUser("student", userId, newTel); //Session추가 후 수정...
					//비밀번호 변경(미정)
					break;

				case 9 :
					//StartView로 이동한다
					System.exit(0);
					//session...
			
			}
		}	
	}

	
	public static void teacherMenu(String userId){
		//controller로 이동해서 id, pwd체크하고 왔다
		while(true){
			System.out.println("-------------------------------강사 메뉴-----------------------------");
			System.out.println("1.학생목록 2.성적등록 3.성적수정 4.개인정보확인 5.개인정보수정 9.로그아웃");
			int menuNo = StartView.sc.nextInt();
				switch(menuNo) {
					case 1 :
						List<StudentDTO> list = CourseController.getStudentList();
						break;
					case 2 :
						//성적입력받는다
						int score = StartView.sc.nextInt(); //개행 읽기 필요?
						CourseController.insertScore(score);
						break;
					case 3 :
						//SugangController.updateScore();
						break;
					case 4 :
						UserController.showUser("teacher", userId);
						break;
					case 5 :
						System.out.println("변경할 연락처> ");
						String newTel = StartView.sc.nextLine();
						UserController.updateUser("teacher", userId, newTel);
						break;
					case 9 : System.exit(0);
					//StartView로 이동한다
					//session...
				}
			
		}
	}
}
