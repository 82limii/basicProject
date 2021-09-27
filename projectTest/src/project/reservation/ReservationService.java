package project.reservation;

import project.cormember.CormemberVO;
import project.member.MemberVO;

public class ReservationService {
	private static ReservationService instance = new ReservationService();
	public static ReservationService getInstance() {
		return instance;
	}
	private ReservationService() {}
	
	// Data Access Object(DAO): DB 접속
	private ReservationDao reservationDao = ReservationDao.getInstance();
	
	public int insertReservation(ReservationVO vo) {
		return reservationDao.insertReservation(vo);
	}
	
	public ReservationVO selectReservation(String resNo) {
		return reservationDao.selectReservation(resNo);
	}
	
	public MemberVO readReservationMemId(String memId) {
		return reservationDao.readReservationMemId(memId);
	}
	
	public CormemberVO readReservationCorNo(String corNo) {
		return reservationDao.readReservationCorNo(corNo);
	}
	
	public int deleteReservation(ReservationVO vo) {
		return reservationDao.deleteReservation(vo);
	}
}
