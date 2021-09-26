package project.main;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.pool.OracleDataSource;

public class Application {
private static JdbcTemplate template = new JdbcTemplate();
	// JdbcTemplate : 리턴타입(Java Database Connectivity)
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
