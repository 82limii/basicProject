package project.event;

import java.util.List;
import java.util.Map;

public class EventService {
	private static EventService instance = new EventService();
	public static EventService getInstance() {
		return instance;
	}
	private EventService() {}

		private EventDao dao = EventDao.getInstance();
		
		public List<Map<String, Object>> selectEventList() {
			return dao.selectEventList();
		}
		
		public EventVO selectEvent(int eveNo) throws Exception{
			return dao.selectEvent(eveNo);
		}
		public int insertEvent(EventVO vo) throws Exception {
			return dao.insertEvent(vo);
		}
		public int updateEvent(EventVO vo) throws Exception {
			return dao.updateEventInfo(vo);
		}
		public int deleteEvent(int eveNo) throws Exception {
			return dao.deleteEvent(eveNo);
		}
		
}

