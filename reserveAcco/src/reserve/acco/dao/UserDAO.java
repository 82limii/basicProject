package reserve.acco.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.CormemberVO;
import reserve.acco.vo.MemberVO;

public class UserDAO {
	private UserDAO(){}
	private static UserDAO instance;
	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
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
		return template.queryForObject("SELECT * FROM CORMEMBER WHERE COR_ID = ? AND COR_PASS = ? "
				,new BeanPropertyRowMapper<>(CormemberVO.class)
				, vo.getCorId(), vo.getCorPass());
	}
	
	// 개인회원 정보 조회
	public MemberVO showMemInfo(String memId) {
		return template.queryForObject("SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_BIR, MEM_TEL FROM MEMBER WHERE MEM_ID = ?"
				, new BeanPropertyRowMapper<>(MemberVO.class)
				, memId);
	}
	
	// 법인회원 정보 조회
	public CormemberVO showCorInfo (String corId) {
		return template.queryForObject("SELECT COR_ID, COR_NO, COR_PASS, COR_NAME, COR_TEL FROM CORMEMBER WHERE COR_ID = ?"
				, new BeanPropertyRowMapper<>(CormemberVO.class)
				, corId);
	}
}
