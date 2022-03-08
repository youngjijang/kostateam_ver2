package academy.mvc.session;
import java.util.ArrayList;
/**
 * 각회원의 관련된 정보 저장하는 객체
 * 필드: 회원아이디, 강의리스트
 * */
import java.util.List;

/**
 * 사용자 객체
 * */
public class Session {
	private String sessionId;
	private List <String> attributes; //휘발성 강의 장바구니 >>수강신청으로 이어진다
	
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
		attributes = new ArrayList<String>();
	}
	public String getSessionId() {
		return sessionId;
	}
	
	//추가
	public void setAttribute(String name, String courseCode) {//String userId, courseList
		attributes.add(courseCode);
	}
	
	//조회(list에 no에 해당하는 courseCode 찾기)
	public String getAttribute(int no) {//cart
		return attributes.get(no);
	}
	
	//제거(장바구니를 비울때 사용한다)
	public void removeAttribute(int no) {//cart
		attributes.remove(no);
	}
	
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public List<String> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}
	
	
	@Override
	public String toString() {
		return "Session [접속중=" + sessionId + ", attributes=" + attributes + "]"+"\n";
	}

}
