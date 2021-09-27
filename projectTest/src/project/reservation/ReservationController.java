package project.reservation;

import project.cormember.CormemberVO;
import project.member.MemberVO;

public class ReservationController {
	// 싱글톤 패턴
	private ReservationController instance = new ReservationController();
	public ReservationController getInstance() {
		return instance;
	}
	private ReservationController() {}
	
	private ReservationService reservationservice = ReservationService.getInstance();
	
	public int insertReservation(ReservationVO vo) {
		return reservationservice.insertReservation(vo);
	}
	
	public ReservationVO selectReservation(String resNo) {
		return reservationservice.selectReservation(resNo);
	}
	
	public MemberVO readReservationMemId(String memId) {
		return reservationservice.readReservationMemId(memId);
	}
	
	public CormemberVO readReservationCorNo(String corNo) {
		return reservationservice.readReservationCorNo(corNo);
	}
	
	public int deleteReservation(ReservationVO vo) {
		return reservationservice.deleteReservation(vo);
	}

}
