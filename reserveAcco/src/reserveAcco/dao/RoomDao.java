package reserveAcco.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;


public class RoomDao {
	private static RoomDao instance = new RoomDao();
	public static RoomDao getInstance() {
		return instance;
	}
	private RoomDao() {}
	
	private JdbcTemplate template = Application.getTemplate();
	
	// DB자료 불러오기

	 /**
	    * Create (insert) 객실정보 생성
	    * return 성공시 1, 실패시 0
	    * @param vo
	    * @return
	    */
	   public int createRoom(RoomVO vo) {
	      try {
	         return template.update("INSERT INTO ROOM (ROOM_ID, ACCO_ID, ROOM_NAME, ROOM_MAX_PEOPLE, ROOM_COST, ROOM_INTRO) VALUES (?, ?, ?, ?, ?, ?)", vo.getRoomId(), vo.getAccoId(), vo.getRoomName(), vo.getRoomMaxpeple(), vo.getRoomcost(), vo.getRoomIntro());
	      } catch (DataAccessException e) {
	         e.printStackTrace();
	         return 0;
	      }
	   }
	   
	   /**
	    * Read (select) 객실정보 불러오기
	    * @param accoId
	    * @return
	    */
	   public RoomVO readRoom() {
	      try {
	         return template.queryForObject("SELECT * FROM ROOM",
	               new BeanPropertyRowMapper<>(RoomVO.class));
	      } catch (DataAccessException e) {
	         e.printStackTrace();
	         return null;
	      }
	   }

	   /**
	    * Update (update)
	    * return 성공시 1, 실패시 0
	    * @param vo
	    * @return
	    */
	   public int updateRoomName(RoomVO vo) {
	      try {
	         return template.update("UPDATE ROOM SET ROOM_NAME WHERE ROOM_id  = ? ", vo.getRoomName(), vo.getRoomId());
	      } catch (DataAccessException e) {
	         e.printStackTrace();
	         return 0;
	      }
	   }
	   public int updateRoomcost(RoomVO vo) {
		   try {
			   return template.update("UPDATE ROOM SET ROOM_COST WHERE ROOM_ID = ? ", vo.getRoomId(),vo.getRoomcost());
		   } catch (DataAccessException e) {
			   e.printStackTrace();
			   return 0;
		   }
	   }
	   public int updateRoomIntro(RoomVO vo) {
		   try {
			   return template.update("UPDATE ROOM SET ROOM_INTRO WHERE ROOM_ID = ? ", vo.getRoomIntro(),vo.getRoomId());
		   } catch (DataAccessException e) {
			   e.printStackTrace();
			   return 0;
		   }
	   }
	   
	   /**
	    * Delete (delete)
	    * return 성공시 1, 실패시 0
	    * @param vo
	    * @return
	    */
	   public int delteRoom(RoomVO vo) {
	      try {
	         return template.update("DELETE FROM ROOM WHERE ROOM_ID = ?", vo.getRoomId());
	      } catch (DataAccessException e) {
	         return 0;
	      }
	   }
}
