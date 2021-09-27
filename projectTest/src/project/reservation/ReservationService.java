package project.reservation;

public class ReservationService {
	private static ReservationService instance = new ReservationService();
	public static ReservationService getInstance() {
		return instance;
	}
	private ReservationService() {}
	
	// Data Access Object(DAO): DB 접속
	private ReservationDAO reservationDao = ReservationDAO.getInstance();
	
	public ReservationVO selectReservation(ReservationVO vo) {
		return reservationDao.selectReservation(vo);
	}
	
	public int deleteReservation(ReservationVO vo) {
		return reservationDao.deleteReservation(vo);
	}
	
	public int insertReservation(ReservationVO vo) {
		return reservationDao.deleteReservation(vo);
	}
	
	public int updateReservation(ReservationVO vo) {
		return reservationDao.deleteReservation(vo);
	}
}
