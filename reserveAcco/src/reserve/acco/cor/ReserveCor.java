package reserve.acco.cor;

import java.util.List;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.CancelDAO;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.AccoVO;
import reserve.acco.vo.CancelVO;
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
	private CancelDAO cancelDAO = CancelDAO.getInstance();
	
	public int reserveGo() {
		System.out.println("===============예약조회===============");
		showReserve();
		System.out.print("예약을 취소하겠습니까? (y or n으로 입력)> ");
		String input = ScanUtil.nextLine();
		
		if (input.equalsIgnoreCase("y")) {
			insertCancel();
			return View.MAIN_COR;
		} else if(input.equalsIgnoreCase("n")){	
			System.out.println("메인화면으로 돌아갑니다.");
			return View.MAIN_COR;
		} else {
			System.out.println("y or n으로 입력해주세요.");
			return reserveGo();
		}
	}
	
	private void showReserve() {		
		LoginService service = LoginService.getInstance();
		List<AccoVO> list = accoDAO.showAcco(service.corsession.getCorId());
		for (AccoVO vo : list) {
			System.out.println(vo);
		}
		System.out.print("예약을 조회할 숙소코드를 입력해주세요>");
		String accoId = ScanUtil.nextLine();
		System.out.println(reservationDAO.selectReserveAccoId(accoId));
	}
	
	private void insertCancel() {
		System.out.print("취소할 예약의 예약코드를 입력해주세요> ");
		long resNo = ScanUtil.nextLong();
		System.out.print("취소사유를 입력해주세요> ");
		String canReason = ScanUtil.nextLine();
		
		int result = cancelDAO.insertCancel(new CancelVO(canReason, resNo));
		if (result != 0) {
			System.out.println("예약을 취소했습니다.");
		} else {
			System.out.println("예약취소를 실패했습니다.");
		}
	}
}
