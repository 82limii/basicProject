package reserve.acco.cor;

import java.util.List;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.AccoVO;
import reserve.acco.vo.ReservationVO;

public class ReserveCor {
	private ReserveCor(){}
	private static ReserveCor instance;
	public static ReserveCor getInstance(){
		if(instance == null){
			instance = new ReserveCor();
		}
		return instance;
	}	
	
	private ReservationDAO reservationDAO = ReservationDAO.getInstance();
	private AccoDAO accoDAO = AccoDAO.getInstance();
	
	public int reserveGo() {
		System.out.println("===============예약조회===============");
		showReserve();
		return View.MAIN_COR;
	}
	
	public void showReserve() {		
		LoginService service = LoginService.getInstance();
		List<AccoVO> list = accoDAO.showAcco(service.corsession.getCorId());
		for (AccoVO vo : list) {
			System.out.println(vo);
		}
		System.out.print("예약을 조회할 숙소코드를 입력해주세요>");
		String accoId = ScanUtil.nextLine();
		System.out.println(reservationDAO.selectReserveAccoId(accoId));
	}
}
