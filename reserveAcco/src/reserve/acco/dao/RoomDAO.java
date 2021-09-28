package reserve.acco.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.RoomVO;

public class RoomDAO {
	private RoomDAO(){}
	private static RoomDAO instance;
	public static RoomDAO getInstance(){
		if(instance == null){
			instance = new RoomDAO();
		}
		return instance;
	}
	
	// Jdbc
	private JdbcTemplate template = Application.getTemplate();
	
	// 객실정보 조회(숙소 아이디)
	public List<RoomVO> selectRoom(String accoId) {
		return template.query("SELECT ROOM_ID, ROOM_NAME, ROOM_COST, ROOM_INTRO, ROOM_MAX_PEOPLE FROM ROOM WHERE ACCO_ID = ?"
				, new BeanPropertyRowMapper<>(RoomVO.class)
				, accoId);
	}
	
	// 객실등록
	public int insertRoom(RoomVO vo) {
		return template.update("INSERT INTO ROOM (ROOM_ID, ACCO_ID, ROOM_COST, ROOM_INTRO, ROOM_NAME, ROOM_MAX_PEOPLE) VALUES (?, ?, ?, ?, ?, ?)"
				, vo.getRoomId(), vo.getAccoId(), vo.getRoomCost(), vo.getRoomIntro(), vo.getRoomName(), vo.getRoomMaxPeople());
	}

}
