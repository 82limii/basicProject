package reserve.acco.mem;

import java.util.List;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.dao.RoomDAO;
import reserve.acco.util.Application;
import reserve.acco.util.ScanUtil;
import reserve.acco.vo.AccoVO;
import reserve.acco.vo.ReservationVO;
import reserve.acco.vo.RoomVO;

public class ReserveMem {
	private ReserveMem(){}
	private static ReserveMem instance;
	public static ReserveMem getInstance(){
		if(instance == null){
			instance = new ReserveMem();
		}
		return instance;
	}	
	
	private AccoDAO accoDAO = AccoDAO.getInstance();
	private RoomDAO roomDAO = RoomDAO.getInstance();
	private ReservationDAO reserveDAO = ReservationDAO.getInstance();
	public ReservationVO session = Application.getSession();
	
	public int reserveGo() {
		LoginService service = LoginService.getInstance();
		System.out.println("===============예약페이지===============");
		System.out.print("체크인 날짜를 입력해주세요> ");
		String checkIn = ScanUtil.nextLine();
		System.out.print("체크아웃 날짜를 입력해주세요> ");
		String checkOut = ScanUtil.nextLine();
		System.out.println("숙소를 불러옵니다");
		List<AccoVO> accoList = accoDAO.selectAcco();
		for (AccoVO accoVo : accoList) {
			System.out.println(accoVo);
		}
		System.out.print("이용할 숙소의 숙소코드를 입력해주세요> ");
		String accoId = ScanUtil.nextLine();
		System.out.println(accoId+"의 객실을 불러옵니다");
		List<RoomVO> roomList = roomDAO.selectRoom(accoId);
		for (RoomVO roomVO : roomList) {
			System.out.println(roomVO);
		}
		System.out.print("이용할 객실코드를 입력해주세요> ");
		String roomId = ScanUtil.nextLine();
		
		session.setRoomId(roomId);
		session.setResInDate(checkIn);
		session.setResOutDate(checkOut);
//		ReservationVO reserveVO = new ReservationVO();
//		reserveVO.setResInDate(checkIn);
//		reserveVO.setResOutDate(checkOut);
//		reserveVO.setRoomId(roomId);
		
		ReservationVO vo = null;
		try {
			int num = reserveDAO.callReserve(session);
			if(vo == null) {
				reserveDAO.insertReserve(session, service.memsession.getMemId());
				System.out.println("예약이 완료되었습니다.");
			} else {
				System.out.println("이미 예약이 완료된 객실입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			vo = reserveDAO.callReserve(session);
//			System.out.println("이미예약이 완료되었습니다.");
//		} catch (Exception e) {
//			reserveDAO.insertReserve(vo, service.memsession.getMemId());
//			System.out.println("예약이 완료되었습니다.");
//		}
		
//		if (reserveDAO.callReserve(session)!= null) {
//			System.out.println("이미 예약이 완료된 객실입니다.\n다른 객실을 이용해주세요");
//		} else {
//			reserveDAO.insertReserve(session, service.memsession.getMemId());
//			System.out.println("예약이 완료되었습니다.");
//		}
		return reserveGo();
	}
}
