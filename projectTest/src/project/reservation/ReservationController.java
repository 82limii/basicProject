package project.reservation;

public class ReservationController {
	// 싱글톤 패턴
	private ReservationController instance = new ReservationController();
	public ReservationController getInstance() {
		return instance;
	}
	ReservationController() {}
	
	private ReservationService reservationService = ReservationService.getInstance();
	
	public ReservationVO selectReservation(ReservationVO vo) {
		return reservationService.selectReservation(vo);
    }

}
