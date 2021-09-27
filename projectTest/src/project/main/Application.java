package project.main;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.pool.OracleDataSource;
import project.cormember.CormemberVO;
import project.member.MemberVO;

public class Application {
	//회원세션
	private static MemberVO memSession = new MemberVO();
	//법인세션
	private static CormemberVO corSession = new CormemberVO();	
	// JdbcTemplate : 리턴타입(Java Database Connectivity)
	private static JdbcTemplate template = new JdbcTemplate();

	public static void main(String[] args) {
		new Home().initialize();
	}
	
	public static MemberVO getMemberSession() {
		return memSession;
	}
	public static CormemberVO getCorSession() {
		return corSession;
	}
	
	public static JdbcTemplate getTemplate() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@112.220.114.130:1521:xe");
			dataSource.setUser("team1_20210809s");
			dataSource.setPassword("java");
			template.setDataSource(dataSource);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return template;
	}
}	// end of class
