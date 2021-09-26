package comeon.showpage;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import VO.ReservationVO;
import comeon.main.Application;

public class ShowPageDao {
	// ½Ì±ÛÅæ
	private static ShowPageDao instance = new ShowPageDao();
	public static ShowPageDao getInstacne() {
		return instance;
	}
	private ShowPageDao() {}
	
	// DB¿¬µ¿
	private JdbcTemplate template = Application.getTemplate();
	
	// Äõ¸®¹®
	public ReservationVO selectReservation(String memId){
		try {
			String query = "SELECT RES_NO"
					+ " ,RES_DATE"
					+ " ,RES_IN_DATE"
					+ " ,RES_OUT_DATE"
					+ " ,RES_PEOPLE"
					+ " ,RES_PRICE"
					+ " ,MEM_ID"
					+ " ,ROOM_ID"
					+ " FROM   RESERVATION"
					+ " WHERE  MEM_ID='"+memId+"'";
			
			return template.queryForObject(query, new BeanPropertyRowMapper<>(ReservationVO.class));
		} catch(DataAccessException e) {
			return null;
		}
	}
}
