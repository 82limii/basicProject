package project.etc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project.event.EventController;
import project.event.EventVO;

public class EventView{

	public static void main(String[] args) throws Exception {
		EventController controller = EventController.getInstance();
//		
//		List<Map<String, Object>> list = controller.selectEventList();
//		
//		System.out.println("이벤트 목록보기");
//		System.out.println(list.get(0));
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		//int eveNo,String eveName,Date eveStart,Date eveEnd,String eveInfo,int eveDis
//		EventVO vo = new EventVO();
//		System.out.print("이벤트 코드(숫자) : ");
//		vo.setEveNo(Integer.parseInt(scanner.nextLine()));
//		System.out.print("이벤트 명 : ");
//		vo.setEveName(scanner.nextLine());
//		System.out.print("게시날짜 : ");
//		vo.setEveStart(scanner.nextLine());
//		System.out.print("종료날짜 : ");
//		vo.setEveEnd(scanner.nextLine());
//		System.out.print("설명 : ");
//		vo.setEveInfo(scanner.nextLine());
//		System.out.print("할인율 : ");
//		vo.setEveDis(Double.parseDouble(scanner.nextLine()));
//		
//		System.out.println("vo : " + vo.toString());
//		
//		int inEvent = controller.insertEvent(vo);
//
//		System.out.println("이벤트 삽입하기 : " + inEvent);
//		System.out.println(list); // 목록보기
//		
//		EventVO result = controller.selectEvent(210924); // 상세보기
//		System.out.println(result.toString());
//		
//		
//		int upEvent = controller.deleteEvent(220222);
//		
//		System.out.println("이벤트 삭제하기 :" + upEvent);
//		System.out.println(list); // 목록보기
		
		EventVO event = controller.selectEvent(210924);
		System.out.println(event);
		
	
		

	}

}
