package project.cancel;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.acco.AccoVO;
import project.main.Application;

public class CancelDao {
	// �̱��� ����
	private static CancelDao instance = new CancelDao();
	public static CancelDao getInstance() {
	return instance;
	}
	private CancelDao() {}
	
	// DB ����
	private JdbcTemplate template = Application.getTemplate();
	
	/**
	 * Create (select)
	 * return ������ 1, ���н� 0
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
	
	public CancelVO readCancel(int resNo) {
		try {
			return template.queryForObject("SELECT * FROM CANCEL where res_no = ?",
					new BeanPropertyRowMapper<>(CancelVO.class),
					resNo);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}	// end of class
