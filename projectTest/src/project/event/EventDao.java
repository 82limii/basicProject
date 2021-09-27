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
	
	
	// 紐⑸줉 蹂닿린!
	/**
	 * �씠踰ㅽ듃 紐⑸줉蹂닿린
	 * @param vo : �씠踰ㅽ듃 �젙蹂� 蹂닿린 List<Map<String,Object>>
	 * @return �꽦怨� �뿬遺�(�꽦怨� : 1 , �떎�뙣 : 0)
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

	// 紐⑸줉 �긽�꽭蹂닿린!
	/**
	 * �씠踰ㅽ듃 紐⑸줉蹂닿린
	 * @param vo : �씠踰ㅽ듃 �젙蹂� 蹂닿린 EventVO
	 * @return �꽦怨� �뿬遺�(�꽦怨� : 1 , �떎�뙣 : 0)
	 * @throws Exception
	 */
	
	public EventVO selectEvent(int eveNo) {
		try {
			String query = "SELECT EVE_NO"
					+ " , EVE_NAME"
					+ " ,EVE_START"
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
	
	
	  
	// �씠踰ㅽ듃 �벑濡� 
	/**
	 * �씠踰ㅽ듃 �벑濡�
	 * @param vo : �씠踰ㅽ듃 �젙蹂� EventVO
	 * @return �꽦怨� �뿬遺�(�꽦怨� : 1 , �떎�뙣 : 0)
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
		
	// �씠踰ㅽ듃 �닔�젙(update)
	/**
	 * �씠踰ㅽ듃 �젙蹂� �닔�젙
	 * @param vo : �닔�젙�븷 �씠踰ㅽ듃 �젙蹂�
	 * @return �꽦怨� �뿬遺�(�꽦怨� : 1, �떎�뙣 : 0)
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
	
	// �씠踰ㅽ듃 �궘�젣(delete)
	/**
	 * �씠踰ㅽ듃 �젙蹂� �궘�젣
	 * @param vo : �궘�젣�븷 �씠踰ㅽ듃 �젙蹂�
	 * @return �꽦怨� �뿬遺�(�꽦怨� : 1, �떎�뙣 : 0)
	 * @throws Exception
	 */
	public int deleteEvent(int eveNo) throws Exception {
		String query = "DELETE FROM EVENT WHERE EVE_NO = '" + eveNo + "'";
		return template.update(query);
	}

}
