package project.event;

import java.util.List;
import java.util.Map;

public class EventView{

	public static void main(String[] args) {
		Eventcontroller controller = Eventcontroller.getInstance();
		
		List<Map<String, Object>> list = controller.selectEventList();
		
		System.out.println("이벤트 목록보기");
		System.out.println(list.get(0));

		
		

	}

}
