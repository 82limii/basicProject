package comeon.main;

import java.util.List;
import java.util.Map;

import VO.ReservationVO;
import comeon.showpage.ShowPageController;

public class ReservationView {

	public static void main(String[] args) {
		ShowPageController controller = ShowPageController.getInstance();
		
		String memId = "narinari12";
		
		ReservationVO vo = controller.selectReservation(memId);

		System.out.println(vo.toString());
		
		
	}

}
