package academy.mvc.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 각회원의 관련된 정보 저장하는 객체
 * 필드: 회원아이디, 강의리스트
 * */

import java.util.Set;



/**
 * 사용자 객체
 * */
public class Session {
	private String sessionId;
	private Map<String,Object> attributes; //휘발성 강의 장바구니 >>수강신청으로 이어진다
	
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
		attributes = new HashMap<>();
	}
	public String getSessionId() {
		return sessionId;
	}
	
	//추가
	public void setAttribute(String ID, Object values) {//String userId, courseList
		attributes.put(ID,values);
	}
	
	//조회
	public Object getAttribute(String ID) {//cart
		return attributes.get(ID);
	}
	
	//제거(장바구니를 비울때 사용한다)
	public void removeAttribute(String ID) {//cart

		attributes.remove(ID);
	}
	
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public Map<String,Object> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String,Object> attributes) {
		this.attributes = attributes;
	}
	
	
	@Override
	public String toString() {
		return "Session [접속중=" + sessionId + ", attributes=" + attributes + "]"+"\n";
	}

}
