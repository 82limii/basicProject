package reserve.acco.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.AccoVO;


public class AccoDAO {
	private AccoDAO(){}
	private static AccoDAO instance;
	public static AccoDAO getInstance(){
		if(instance == null){
			instance = new AccoDAO();
		}
		return instance;
	}	
	
	// Jdbc
	private JdbcTemplate template = Application.getTemplate();
	
	// 숙소정보 조회(전체)
	public List<AccoVO> selectAcco() {
		return template.query("SELECT ACCO_ID, ACCO_NAME, ACCO_ADD, ACCO_TEL, ACCO_INTRO FROM ACCO", new BeanPropertyRowMapper<>(AccoVO.class));
	}
	
	// 숙소조회 (법인아이디)
	public List<AccoVO> showAcco(String corId){
		return template.query("SELECT ACCO_ID, ACCO_NAME, ACCO_ADD, ACCO_TEL, ACCO_INTRO, COR_ID FROM ACCO WHERE COR_ID = ?"
				, new BeanPropertyRowMapper<>(AccoVO.class)
				, corId);
	}
	
	// 숙소등록
	public int insertAcco(AccoVO vo) {
		return template.update("INSERT INTO ACCO (ACCO_ID, ACCO_NAME, ACCO_ADD, ACCO_TEL, ACCO_INTRO, COR_ID) VALUES (?, ?, ?, ?, ?, ?)"
				, vo.getAccoId(), vo.getAccoName(), vo.getAccoAdd(), vo.getAccoTel(), vo.getAccoIntro(), vo.getCorId());
	}
}
