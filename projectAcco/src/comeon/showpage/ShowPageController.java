package comeon.showpage;

import java.util.List;
import java.util.Map;

import VO.ReservationVO;

public class ShowPageController {
	// 教臂沛
	private static ShowPageController instance = new ShowPageController();
	public static ShowPageController getInstance() {
		return instance;
	}
	private ShowPageController() {}
	
	// 辑厚胶 按眉 积己
	private ShowPageService showPageService = ShowPageService.getInstance();
	
	
	public ReservationVO selectReservation(String memId){
		return showPageService.selectReservation(memId);
	}
}
