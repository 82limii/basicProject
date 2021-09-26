package comeon.showpage;

import java.util.List;
import java.util.Map;

import VO.ReservationVO;

public class ShowPageController {
	// �̱���
	private static ShowPageController instance = new ShowPageController();
	public static ShowPageController getInstance() {
		return instance;
	}
	private ShowPageController() {}
	
	// ���� ��ü ����
	private ShowPageService showPageService = ShowPageService.getInstance();
	
	
	public ReservationVO selectReservation(String memId){
		return showPageService.selectReservation(memId);
	}
}
