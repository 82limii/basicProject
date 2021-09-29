package reserve.acco.mem;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.dao.RoomDAO;
import reserve.acco.util.Application;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
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
		try {
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
			
			List<ReservationVO> list = reserveDAO.callReserve(session);
			int cnt_reserve = list.get(0).getCnt();
			if(cnt_reserve == 0) {
				reserveDAO.insertReserve(session, service.memsession.getMemId());
				System.out.println("예약이 완료되었습니다.");
			} else {
				System.out.println("이미 예약이 완료된 객실입니다.");
				return reserveGo();
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (DataIntegrityViolationException e) {
			System.out.println("양식에 맞게 입력해주세요.");
		} catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생했습니다.");
			e.printStackTrace();
		}
		return View.MAIN_MEM;
	}
}
