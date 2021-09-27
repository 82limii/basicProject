package project.cancel;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.acco.AccoVO;
import project.main.Application;

public class CancelDao {
	// 싱글톤 패턴
	private static CancelDao instance = new CancelDao();
	public static CancelDao getInstance() {
	return instance;
	}
	private CancelDao() {}
	
	// DB 연동
	private JdbcTemplate template = Application.getTemplate();
	
	/**
	 * Create (select)
	 * return 성공시 1, 실패시 0
	 * @param vo
	 * @return
	 */
	public int createCancel(CancelVO vo) {
		try {
			return template.update("INSERT INTO CANCEL (CAN_DATE, CAN_REASON, CAN_PRICE, RES_NO) VALUES (?, ?, ?, ?, ?)", vo.getCanDate(), vo.getCanReason(), vo.getCanPrice(), vo.getResNo(), vo.getCanDate());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// (숙소or객실)정보(아이디)로 취소내역불러오기(아웃조인)
	// 개인아이디로 취소내역 불러오기(아웃조인)
	public CancelVO readCancel(int resNo) {
		try {
			return template.queryForObject("SELECT * FROM CANCEL WHERE RES_NO = ?",
					new BeanPropertyRowMapper<>(CancelVO.class),
					resNo);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 삭제
}	// end of class
