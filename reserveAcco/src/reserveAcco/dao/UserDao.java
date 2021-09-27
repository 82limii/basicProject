package reserveAcco.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserveAcco.util.Application;
import reserveAcco.vo.CormemberVO;
import reserveAcco.vo.MemberVO;

public class UserDao {
	private UserDao(){}
	private static UserDao instance;
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
	private JdbcTemplate template = Application.getTemplate();
	
	// 개인회원 가입
	public int insertMem(MemberVO vo) {
		return template.update("insert into member (mem_id, mem_pass, mem_name, mem_bir, mem_tel) values (?,?,?,to_date(?),?)"
				, vo.getMemId(),vo.getMemPass(),vo.getMemName(),vo.getMemBir(),vo.getMemTel());
	}
	
	// 법인회원 가입
	public int insertCor(CormemberVO vo) {
		return template.update("INSERT INTO CORMEMBER (COR_ID, COR_NO, COR_PASS, COR_NAME, COR_TEL) VALUES (?, ?, ?, ?, ?)"
				, vo.getCorId(), vo.getCorNo(), vo.getCorPass(), vo.getCorName(), vo.getCorTel());
	}
	
	// 개인회원 로그인
	public MemberVO selectMem(MemberVO vo) {
		return template.queryForObject("SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_PASS = ? ",
				new BeanPropertyRowMapper<>(MemberVO.class)
				, vo.getMemId(), vo.getMemPass());
	}
	
	// 법인회원 로그인
	public CormemberVO selectCor(CormemberVO vo) {
		return template.queryForObject("SELECT * FROM CORMEMBER WHERE COR_ID = ? AND COR_PASS = ? ",
				new BeanPropertyRowMapper<>(CormemberVO.class)
				, vo.getCorId(), vo.getCorPass());
	}
	
}
