package academy.mvc.view;

public class StartView {

	public static void main(String[] args) {
		try {
			MenuView.loginMenu();
		}catch(NumberFormatException e) {
			FailView.errorMessage("제대로 입력하세요.");
			MenuView.loginMenu();
		}
	}

}
