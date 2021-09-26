package project.cormember;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class CormemberDao {
	// 싱글톤 패턴
	private static CormemberDao instance = new CormemberDao();
	public static CormemberDao getInstance() {
	return instance;
	}
	private CormemberDao() {}
	
	// DB 연동
	private JdbcTemplate template = Application.getTemplate();
	
	/**
	 * Create (insert)
	 * return 성공시 1, 실패시 0
	 * @param vo
	 * @return
	 */
	public int createCormember(CormemberVO vo) {
		try {
			return template.update("INSERT INTO CORMEMBER (COR_NO, COR_ID, COR_PASS, COR_NAME, COR_TEL) VALUES (?, ?, ?, ?, ?)", vo.getCorNo(), vo.getCorId(), vo.getCorPass(), vo.getCorName(), vo.getCorTel());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public CormemberVO readCormember(String corId) {
		try {
			return template.queryForObject("SELECT * FROM CORMEMBER WHERE COR_ID = ?",
					new BeanPropertyRowMapper<>(CormemberVO.class),
					corId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}	// end of class
