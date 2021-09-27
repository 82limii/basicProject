package project.reservation;

import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class ReservationDAO {
	private static ReservationDAO instance = new ReservationDAO();
	public static ReservationDAO getInstance() {
		return instance;
	}
	ReservationDAO() {}
	
	// DB연동
    private JdbcTemplate template = Application.getTemplate();
    
    //전체 조회
    public List<Map<String,Object>> selectReservationList(ReservationVO vo) {
    	try {
    	return template.queryForList("SELECT RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, RES_PEOPLE, RES_PRICE, MEM_ID, ROOM_ID FROM RESERVATION ORDER BY RES_NO DESC");
    	} catch (DataAccessException e) {
    		return null;
    	}
    }
    
    // 개인회원 예약 조회
    public ReservationVO selectReservation(ReservationVO vo) {
    	try {
    	return template.queryForObject("SELECT RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, RES_PEOPLE, RES_PRICE, MEM_ID, ROOM_ID FROM RESERVATION WHERE MEM_ID = ?"
    			,new BeanPropertyRowMapper<>(ReservationVO.class)
    			,vo.getMemId()
    			);
    	} catch (DataAccessException e) {
    		return null;
    	}
    }
    // 법인회원의 (숙소or객실)아이디로 예약조회 (아웃조인)
    
    // 입력
    public int insertReservation(ReservationVO vo) {
    	try {
	    	String query = "INSERT INTO RESERVARTION(RES_NO"
	    			+ ",RES_DATE"
	    			+ ",RES_IN_DATE"
	    			+ ",RES_OUT_DATE"
	    			+ ",RES_PEOPLE"
	    			+ ",RES_PRICE"
	    			+ ",MEM_ID"
	    			+ ",ROOM_ID)"
	    			+ " VALUES(?,?,?,?,?,?,?,?)";
	    	return template.update(query,vo.getResNo(),vo.getResDate(),vo.getResInDate(),vo.getResOutDate(),
	    			vo.getResPeople(),vo.getResPrice(),vo.getMemId(),vo.getRoomId());
    	} catch (DataAccessException e) {
    		return 0;
    	}
    }
    
    // 삭제: 회원아이디에 맞는 예약 내역 삭제
    public int deleteReservation(ReservationVO vo) {
    	try {
	    	return template.update("DELETE FROM RESERVARTION WHERE MEM_ID=?",vo.getMemId());
    	} catch (DataAccessException e) {
    		return 0;
    	}
    }

}
