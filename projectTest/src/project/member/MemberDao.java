package project.member;

import org.springframework.dao.DataAccessException;
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
}
