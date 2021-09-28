package reserve.acco.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.CancelVO;

public class CancelDAO {
	private CancelDAO(){}
	private static CancelDAO instance;
	public static CancelDAO getInstance(){
		if(instance == null){
			instance = new CancelDAO();
		}
		return instance;
	}	
	
	// Jdbc
	private JdbcTemplate template = Application.getTemplate();
	
	// 숙소코드로 cancel입력
	public int insertCancel(CancelVO vo) {
		return template.update("insert into cancel (CAN_date, can_reason, res_no) values (sysdate,?,?)"
				, vo.getCanReason(), vo.getResNo());
	}
}
