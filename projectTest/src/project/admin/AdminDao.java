package project.admin;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class AdminDao {
	// �̱��� ����
	private static AdminDao instance = new AdminDao();
	public static AdminDao getInstance() {
	return instance;
	}
	private AdminDao() {}
	
	// DB ����
	private JdbcTemplate template = Application.getTemplate();
	
	/**
	 * Read (login admin)
	 * return ������ 1, ���н� 0
	 * @param adminId
	 * @return
	 */
	public AdminVO findAdmin(String adminId) {
		try {
			return template.queryForObject("select admin_id, admin_pass where admin_id = ?", 
					new BeanPropertyRowMapper<>(AdminVO.class),
					adminId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}	// end of class
