package reserveAcco.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class MemberDao {
	//싱글톤
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {}
	
	//DB연동
	private JdbcTemplate template = Application.getTemplate();
	
	// 개인회원가입
	public int insertMember(MemberVO vo) {
		try {
			return template.update("insert into member (mem_id, mem_pass, mem_name, mem_bir, mem_nick, mem_tel) values (?,?,?,?,?,?)", vo.getMemId(),vo.getMemPass(),vo.getMemName(),vo.getMemBir(),vo.getMemNick(),vo.getMemTel());
		}catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Id가져오기
	 * @param memId
	 * @return
	 */
	public MemberVO findMemUser (MemberVO vo) {
		try {
			return template.queryForObject("SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_PASS = ? ",
					new BeanPropertyRowMapper<>(MemberVO.class),
					vo.getMemId(), vo.getMemPass());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 개인회원 비밀번호 수정
	 * @param vo
	 * @return
	 */
	public int modifyMemPass(MemberVO vo) {
		try {
			return template.update("UPDATE MEMBER SET MEM_PASS = ? WHERE MEM_ID = ?", vo.getMemPass(), vo.getMemId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 개인회원 전화번호 수정
	 * @param vo
	 * @return
	 */
	public int modifyMemTel(MemberVO vo) {
		try {
			return template.update("UPDATE MEMBER SET MEM_TEL = ? WHERE MEM_ID = ?", vo.getMemTel(), vo.getMemId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 개인회원 삭제(회원 탈퇴)
	 * @param vo
	 * @return
	 */
	public int deleteMember(MemberVO vo) {
		try {
			return template.update("DELETE FROM MEMBER WHERE MEM_ID=?",vo.getMemId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
