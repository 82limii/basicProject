//package project.main;
//
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import VO.CormemberVO;
//import VO.MemberVO;
//import oracle.jdbc.pool.OracleDataSource;
//
//public class Application2 {
//	private static JdbcTemplate template = new JdbcTemplate();
//	//회원세션
//	private static MemberVO memberSession = new MemberVO();
//	//법인세션
//	private static CormemberVO corSession = new CormemberVO();
//	
//	public static MemberVO getMemberSession() {
//		return memberSession;
//	}
//	
//	public static CormemberVO getCorSession() {
//		return corSession;
//	}
//	
//	public static JdbcTemplate getTemplate() {
//		try {
//			OracleDataSource dataSource = new OracleDataSource();
//			dataSource.setURL("jdbc:oracle:thin:@112.220.114.130:1521:xe");
//			dataSource.setUser("team1_20210809s");
//			dataSource.setPassword("java");
//			template.setDataSource(dataSource);
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
//		return template;
//	}
//}
