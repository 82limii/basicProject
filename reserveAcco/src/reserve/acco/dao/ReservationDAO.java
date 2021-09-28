package reserve.acco.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.ReservationVO;

public class ReservationDAO {
	private ReservationDAO(){}
	private static ReservationDAO instance;
	public static ReservationDAO getInstance(){
		if(instance == null){
			instance = new ReservationDAO();
		}
		return instance;
	}	

	// DB연동
	private JdbcTemplate template = Application.getTemplate();

	// 개인아이디로 예약내역 조회
	public List<ReservationVO> selectReservation(String memId) {
		return template.query("SELECT RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, MEM_ID, ROOM_ID FROM RESERVATION WHERE MEM_ID = ?",
					new BeanPropertyRowMapper<>(ReservationVO.class), memId);
	}
	
	// 법인아이디로 예약내역 조회
	public List<ReservationVO> selectReservationCor(String corId) {
		return template.query("SELECT A.RES_NO, A.RES_DATE, A.RES_IN_DATE, A.RES_OUT_DATE, A.MEM_ID, A.ROOM_ID FROM RESERVATION A, ROOM B, ACCO C WHERE A.ROOM_ID=B.ROOM_ID AND B.ACCO_ID=C.ACCO_ID AND COR_ID = ?",
					new BeanPropertyRowMapper<>(ReservationVO.class), corId);
	}
	
	// accoId 예약내역 조회
	public List<ReservationVO> selectReserveAccoId(String accoId) {
		return template.query("SELECT A.RES_NO, A.RES_DATE, A.RES_IN_DATE, A.RES_OUT_DATE, A.MEM_ID, A.ROOM_ID FROM RESERVATION A, ROOM B WHERE A.ROOM_ID = B.ROOM_ID AND B.ACCO_ID = ?"
				, new BeanPropertyRowMapper<>(ReservationVO.class), accoId);
	}
	
	// 예약하기 
	public int insertReserve(ReservationVO vo, String memId) {
		return template.update("INSERT INTO RESERVATION(RES_NO, RES_DATE, RES_IN_DATE, RES_OUT_DATE, MEM_ID, ROOM_ID) VALUES(REPLACE(TO_CHAR(SYSDATE,'YYYYMMDD')||TO_CHAR(SEQ_RES_NO.NEXTVAL,'0000'),' '), SYSDATE,?,?,?,?)"
				, vo.getResInDate(), vo.getResOutDate(), memId,vo.getRoomId());
	}
	
	// roomId, 기간데이터로 예약내역 조회
	public List<ReservationVO> callReserve(ReservationVO vo){
		return template.query("SELECT COUNT(*) CNT FROM RESERVATION WHERE ROOM_ID = ? AND TO_DATE(?) BETWEEN RES_IN_DATE AND (RES_OUT_DATE-1)"
				, new BeanPropertyRowMapper<ReservationVO>(ReservationVO.class)
				, vo.getRoomId(), vo.getResInDate());
	}
//	public int callReserve(ReservationVO vo) {
//		System.out.println(vo);
//		System.out.println(vo);
//		String sql = "SELECT count (*) FROM RESERVATION WHERE ROOM_ID = ? AND TO_DATE(?) BETWEEN RES_IN_DATE AND (RES_OUT_DATE-1)";
//		System.out.println("sql:"+sql);
//		ReservationVO rvo = template.queryForObject(sql
//				, new BeanPropertyRowMapper<>(ReservationVO.class)
//				, vo.getRoomId(), vo.getResInDate());
//		System.out.println(rvo);
//		return template.query("SELECT count (*) FROM RESERVATION WHERE ROOM_ID = ? AND TO_DATE(?) BETWEEN RES_IN_DATE AND (RES_OUT_DATE-1)"
//				, new BeanPropertyRowMapper<ReservationVO>(ReservationVO.class)
//				, vo.getRoomId(), vo.getResInDate());
//	}
}
