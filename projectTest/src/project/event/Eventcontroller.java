package project.event;

import java.util.List;
import java.util.Map;

public class Eventcontroller {
	private static Eventcontroller instance = new Eventcontroller();
	public static Eventcontroller getInstance() {
		return instance;
	}
	private Eventcontroller() {}
	
	EventService service = EventService.getInstance();
	
	public List<Map<String, Object>> selectEventList() {
		return service.selectEventList();
	}
	
	public EventVO selectEvent(int eveNo) throws Exception{
		return service.selectEvent(eveNo);
	}
	public int insertEvent(EventVO vo) throws Exception {
		return service.insertEvent(vo);
	}
	public int updateEvent(EventVO vo) throws Exception {
		return service.updateEvent(vo);
	}
	public int deleteEvent(int eveNo) throws Exception {
		return service.deleteEvent(eveNo);
	}
}
