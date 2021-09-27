package reserveAcco.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.cormember.CormemberVO;
import project.main.Application;
import project.member.MemberVO;

public class ReservationDao {
	private static ReservationDao instance = new ReservationDao();
	public static ReservationDao getInstance() {
		return instance;
	}
	ReservationDao() {}
	
	// DB연동
    private JdbcTemplate template = Application.getTemplate();
    
	/**
	 * Create(insert) 예약정보 입력
	 * @param vo
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 */
    public int insertReservation(ReservationVO vo) {
    	try {
    		return template.update("INSERT INTO RESERVARTION(RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, RES_PEOPLE, RES_PRICE, MEM_ID, ROOM_ID) VALUES(?,?,?,?,?,?,?,?)", vo.getResNo(), vo.getResDate(), vo.getResInDate(), vo.getResOutDate(), vo.getResPeople(), vo.getResPrice(), vo.getMemId(), vo.getRoomId());
    	} catch (DataAccessException e) {
    		return 0;
    	}
    }
    
	/**
	 * Read (select)
	 * 예약내역 전체조회
	 * @param corId
	 * @return 
	 */
    public List<Map<String,Object>> selectReservationList(ReservationVO vo) {
    	try {
    	return template.queryForList("SELECT RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, RES_PEOPLE, RES_PRICE, MEM_ID, ROOM_ID FROM RESERVATION ORDER BY RES_NO DESC");
    	} catch (DataAccessException e) {
    		return null;
    	}
    }
    
	 // 예약번호로 예약내역 조회
    public ReservationVO selectReservation(String resNo) {
    	try {
    	return template.queryForObject("SELECT * FROM RESERVATION WHERE RES_NO = ? ORDER BY DESC",
    			new BeanPropertyRowMapper<>(ReservationVO.class),resNo);
    	} catch (DataAccessException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    // 일반회원의 아이디로 예약조회
    public MemberVO readReservationMemId(String memID) {
    	try {
    	return template.queryForObject("SELECT A.MEM_ID, B.RES_NO, B.RES_DATE, B.RES_IN_DATE, B.RES_OUT_DATE, B.RES_PEOPLE, B.RES_PRICE, B.MEM_ID, B.ROOM_ID FROM MEMBER A RIGHT OUTER JOIN RESERVATION B ON(A.MEM_ID = B.MEM_ID) WHERE A.MEM_ID = ?",
				new BeanPropertyRowMapper<>(MemberVO.class),memID);  
    	} catch (DataAccessException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    // 법인회원의 아이디로 예약조회
    public CormemberVO readReservationCorNo(String CorId) {
    	try {
    	return template.queryForObject("SELECT A.COR_ID, C.RES_NO, C.RES_DATE, C.RES_IN_DATE, C.RES_OUT_DATE, C.RES_PEOPLE, C.RES_PRICE, C.ROOM_ID, C.ACCO_ID FROM CORMEMBER A RIGHT OUTER JOIN ACCO B ON(A.COR_NO = B.COR_NO) RIGHT OUTER JOIN RESERVATION C ON(B.ACCO_ID = C.ACCO_ID) WHERE A.COR_ID = ?",
    			new BeanPropertyRowMapper<>(CormemberVO.class),CorId);
    	} catch (DataAccessException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
	/**
	 * Delete (delete)
	 * 회원아이디 가져와서 개인 예약내역 삭제
	 * @param memId
	 * @return 
	 */
    public int deleteReservation(ReservationVO vo) {
    	try {
	    	return template.update("DELETE FROM RESERVARTION WHERE MEM_ID= ?",vo.getMemId());
    	} catch (DataAccessException e) {
    		return 0;
    	}
    }

}
