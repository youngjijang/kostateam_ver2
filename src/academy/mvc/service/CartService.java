package academy.mvc.service;

import java.sql.SQLException;
import java.util.Map;

import academy.mvc.model.dto.CourseDTO;

public class CartService {
	public void allInsertCart(String sID, Map<CourseDTO,String> cart)throws SQLException {
		SugangService sugangService = new SugangService();
				
		for(CourseDTO courseDTO : cart.keySet()) {
			String cCode = courseDTO.getcCode();
			sugangService.insertSugang(sID, cCode);
		}		
	} 	
}
