package reserveAcco.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class AccoDao {
	// 싱글톤 패턴
	private static AccoDao instance = new AccoDao();
	public static AccoDao getInstance() {
	return instance;
	}
	private AccoDao() {}
	
	// DB 연동
	private JdbcTemplate template = Application.getTemplate();
	
	/**
	 * Create (insert)
	 * return 성공시 1, 실패시 0
	 * @param vo
	 * @return
	 */
	public int createAcco(AccoVO vo) {
		try {
			return template.update("INSERT INTO ACCO (ACCO_ID, ACCO_NAME, ACCO_ADD, ACCO_TEL, ACCO_FACILITY, ACCO_INTRO, COR_NO) VALUES (?, ?, ?, ?, ?, ?, ?)", vo.getAccoId(), vo.getAccoName(), vo.getAccoAdd(), vo.getAccoTel(), vo.getAccoFacility(), vo.getAccoIntro(), vo.getCorNo());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Read (select)
	 * @param accoId
	 * @return
	 */
	public List<AccoVO> readAcco() {
		try {
			return template.query("SELECT * FROM ACCO", new BeanPropertyRowMapper<>(AccoVO.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Update (update)
	 * return 성공시 1, 실패시 0
	 * @param vo
	 * @return
	 */
	public int updateAccoName(AccoVO vo) {
		try {
			return template.update("UPDATE ACCO SET ACCO_ADD = ? WHERE ACCO_ID = ?", vo.getAccoAdd(), vo.getAccoId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateAccoFacility(AccoVO vo) {
		try {
			return template.update("UPDATE ACCO SET ACCO_FACILITY = ? WHERE ACCO_ID = ?", vo.getAccoFacility(), vo.getAccoId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int updateAccoIntro(AccoVO vo) {
		try {
			return template.update("UPDATE ACCO SET ACCO_INTRO = ? WHERE ACCO_ID = ?", vo.getAccoIntro(), vo.getAccoId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Delete (delete)
	 * return 성공시 1, 실패시 0
	 * @param vo
	 * @return
	 */
	public int delteAcco(AccoVO vo) {
		try {
			return template.update("DELETE FROM ACCO WHERE ACCO_ID = ?", vo.getAccoAdd());
		} catch (DataAccessException e) {
			return 0;
		}
	}
}	// end of class
