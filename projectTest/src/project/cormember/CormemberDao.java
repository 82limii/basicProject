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
	 * Create (insert) 회원가입
	 * @param vo
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 */
	public int createCormember(CormemberVO vo) {
		try {
			return template.update("INSERT INTO CORMEMBER (COR_NO, COR_ID, COR_PASS, COR_NAME, COR_TEL) VALUES (?, ?, ?, ?, ?)", vo.getCorNo(), vo.getCorId(), vo.getCorPass(), vo.getCorName(), vo.getCorTel());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Read (select)
	 * Id가져와서 법인회원 정보 조회(내정보조회)
	 * @param corId
	 * @return 
	 */
	public CormemberVO readCormember(String corId) {
		try {
			return template.queryForObject("SELECT * FROM CORMEMBER WHERE COR_ID = ? ORDER BY DESC",
					new BeanPropertyRowMapper<>(CormemberVO.class),corId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Update (update)
	 * @param vo
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 */
	// 비밀번호 수정
	public int modifyCorPass(CormemberVO vo) {
		try {
			return template.update("UPDATE CORMEMBER SET COR_PASS = ? WHERE COR_ID = ?", vo.getCorPass());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 법인회원 이름 수정
	public int modifyCorName(CormemberVO vo) {
		try {
			return template.update("UPDATE CORMEMBER SET COR_NAME = ? WHERE COR_ID = ?", vo.getCorName());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 전화번호 수정
	public int modifyCorTel(CormemberVO vo) {
		try {
			return template.update("UPDATE CORMEMBER SET COR_TEL = ? WHERE COR_ID = ?", vo.getCorTel());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Delete (delete)
	 * 법인회원 삭제
	 * @param vo
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 */
	public int deleteCorMember(CormemberVO vo) {
		try {
		return template.update("DELETE FROM CORMEMBER WHERE COR_ID=?",vo.getCorId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
}	// end of class
