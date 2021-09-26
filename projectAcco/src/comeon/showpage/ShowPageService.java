package comeon.showpage;

import java.util.List;
import java.util.Map;

import VO.ReservationVO;

public class ShowPageService {
	// ΩÃ±€≈Ê ∆–≈œ
	private static ShowPageService instance = new ShowPageService();
	public static ShowPageService getInstance() {
		return instance;
	}
	private ShowPageService() {}
	
	// DAO
	ShowPageDao dao = ShowPageDao.getInstacne();
	
	public ReservationVO selectReservation(String memId){
		return dao.selectReservation(memId);
	}
}
