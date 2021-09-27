package project.event;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;


public class EventDao {
	private static EventDao instance = new EventDao();
	public static EventDao getInstance() {
		return instance;
	}
	private EventDao() {}
	
	private JdbcTemplate template = Application.getTemplate();
	
	
	// 목록 보기!
	/**
	 * 이벤트 목록보기
	 * @param vo : 이벤트 정보 보기 List<Map<String,Object>>
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 * @throws Exception
	 */
	
	public List<Map<String, Object>> selectEventList() {
		try {
			String query = "SELECT EVE_NO"
					+ " , EVE_NAME"
					+ " ,EVE_START"
					+ " ,EVE_END"
					+ " ,EVE_INFO"
					+ " ,EVE_DIS"
					+ " FROM EVENT "
					+  " ORDER BY EVE_NO";
			return template.queryForList(query);
		} catch (DataAccessException e) {
			return null;
		}
	}

	// 목록 상세보기!
	/**
	 * 이벤트 목록보기
	 * @param vo : 이벤트 정보 보기 EventVO
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 * @throws Exception
	 */
	
	public EventVO selectEvent(int eveNo) {
		try {
			String query = "SELECT EVE_NO"
					+ " , EVE_NAME"
					+ " ,TO_CHAR(EVE_START, 'YYYY-MM-DD') EVE_START"
					+ " ,EVE_END"
					+ " ,EVE_INFO"
					+ " ,EVE_DIS"
					+ " FROM EVENT "
					+  " WHERE EVE_NO="+eveNo;
			return template.queryForObject(query, new BeanPropertyRowMapper<>(EventVO.class));
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	  
	// 이벤트 등록 
	/**
	 * 이벤트 등록
	 * @param vo : 이벤트 정보 EventVO
	 * @return 성공 여부(성공 : 1 , 실패 : 0)
	 * @throws Exception
	 */
	public int insertEvent(EventVO vo) {
		String query = "insert into event(eve_no, eve_name, eve_start, eve_end, eve_info, eve_dis) values('"
					+ vo.getEveNo() +"', '" 
					+ vo.getEveName() + "', '" 
					+ vo.getEveStart() +"', '" 
					+ vo.getEveEnd() +"','"
					+ vo.getEveInfo() +"','" 
					+ vo.getEveDis() 
					+ "')";
		return template.update(query);
	}
		
	// 이벤트 수정(update)
	/**
	 * 이벤트 정보 수정
	 * @param vo : 수정할 이벤트 정보
	 * @return 성공 여부(성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int updateEvent(EventVO vo) throws Exception {
		String query = "update event  set eve_no = '" + vo.getEveNo() 
					+ "', eve_name = '" + vo.getEveName() 
					+ "', eve_start = '" + vo.getEveStart()
					+ "', eve_end = '" + vo.getEveEnd() 
					+ "', eve_info ='" + vo.getEveInfo() 
					+ "', eve_dis ='" + vo.getEveDis() 
					+ "'  where eve_no = '"+vo.getEveNo()+"'";
		return template.update(query);
	}
	
//	public int updateEvent(EventVO vo) throws Exception {
//		String query = "update event  set eve_no = '" + vo.getEveNo() 
//					+ "', eve_name = '" + vo.getEveName() 
//					+ "', eve_start = '" + vo.getEveStart()
//					+ "', eve_end = '" + vo.getEveEnd() 
//					+ "', eve_info ='" + vo.getEveInfo() 
//					+ "', eve_dis ='" + vo.getEveDis() 
//					+ "'  where eve_no = '"+vo.getEveNo()+"'";
//		return template.update(query);
//	}
//	
	// 이벤트 삭제(delete)
	/**
	 * 이벤트 정보 삭제
	 * @param vo : 삭제할 이벤트 정보
	 * @return 성공 여부(성공 : 1, 실패 : 0)
	 * @throws Exception
	 */
	public int deleteEvent(int eveNo) throws Exception {
		String query = "DELETE FROM EVENT WHERE EVE_NO = '" + eveNo + "'";
		return template.update(query);
	}

}
