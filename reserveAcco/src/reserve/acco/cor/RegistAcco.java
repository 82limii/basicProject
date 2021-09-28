package reserve.acco.cor;

import java.util.List;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.RoomDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.AccoVO;
import reserve.acco.vo.RoomVO;

public class RegistAcco {
	private RegistAcco(){}
	private static RegistAcco instance;
	public static RegistAcco getInstance(){
		if(instance == null){
			instance = new RegistAcco();
		}
		return instance;
	}	
	
	private AccoDAO accoDao = AccoDAO.getInstance();
	private RoomDAO roomDao = RoomDAO.getInstance();
	
	public int registGo() {
		System.out.println("===============숙소등록===============");
		System.out.println("[1] 숙소등록\t[2] 객실등록 [0] 이전메뉴");
		System.out.print("이동할 메뉴를 선택해주세요> ");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: registAcco();
			break;
		case 2: registRoom();
			break;
		case 0:
			return View.MAIN_COR;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
		return registGo();
	}
	
	private void registAcco() {
		LoginService service = LoginService.getInstance();
		System.out.println("숙소등록을 선택하셨습니다.");
		System.out.println("상세정보를 입력해주세요");
		System.out.print("숙소코드(ex.a000)> ");
		String accoId = ScanUtil.nextLine();
		System.out.print("숙소명> ");
		String accoName = ScanUtil.nextLine();
		System.out.print("숙소주소> ");
		String accoAdd = ScanUtil.nextLine();
		System.out.print("숙소 전화번호> ");
		String accoTel = ScanUtil.nextLine();
		System.out.print("숙소 상세소개> ");
		String accoIntro = ScanUtil.nextLine();
		
		int result = accoDao.insertAcco(new AccoVO(accoId, accoName, accoAdd, accoTel, accoIntro, service.corsession.getCorId()));
		if (result != 0) {
			System.out.println("숙소등록이 완료되었습니다.");
		} else {
			System.out.println("숙소등록을 실패했습니다.");
		}
	}
	
	private void registRoom() {
		LoginService service = LoginService.getInstance();
		System.out.println("객실등록을 선택하셨습니다.");
		List<AccoVO> list = accoDao.showAcco(service.corsession.getCorId());
		for (AccoVO vo : list) {
			System.out.println(vo);
		}
		System.out.print("객실을 등록할 숙소를 입력해주세요> ");
		String accoId = ScanUtil.nextLine();
		System.out.print("객실코드(ex.숙소코드+호실)> ");
		String roomId = ScanUtil.nextLine();
		System.out.print("가격> ");
		double roomCost = ScanUtil.nextDouble();
		System.out.print("객실명> ");
		String roomName = ScanUtil.nextLine();
		System.out.print("객실소개> ");
		String roomIntro = ScanUtil.nextLine();
		System.out.print("최대수용인원> ");
		int roomMaxPeople = ScanUtil.nextInt();
		
		int result = roomDao.insertRoom(new RoomVO(roomId, accoId, roomCost, roomIntro, roomName, roomMaxPeople));
		if (result != 0) {
			System.out.println("객실등록이 완료되었습니다.");
		} else {
			System.out.println("객실등록을 실패했습니다.");
		}
	}
}
