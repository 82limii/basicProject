package reserve.acco.mem;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import reserve.acco.common.LoginService;
import reserve.acco.dao.CancelDAO;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.dao.ReviewDAO;
import reserve.acco.dao.UserDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.CancelVO;
import reserve.acco.vo.ReservationVO;
import reserve.acco.vo.ReviewVO;

public class MypageMem {
	private MypageMem(){}
	private static MypageMem instance;
	public static MypageMem getInstance(){
		if(instance == null){
			instance = new MypageMem();
		}
		return instance;
	}	
	
	private UserDAO userDAO = UserDAO.getInstance();
	private ReservationDAO reservationDAO = ReservationDAO.getInstance();
	private ReviewDAO reviewDAO = ReviewDAO.getInstance();
	private CancelDAO cancelDAO = CancelDAO.getInstance();
	
	public int mypageGo() {
		try {
			System.out.println("===============마이페이지===============");
			System.out.println("[1] 내정보조회\t[2] 예약목록 조회\t[3] 후기목록 조회\t[0] 이전메뉴");
			System.out.print("이동할 메뉴를 선택해주세요> ");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: showMyInfo();
			break;
			case 2: showMyReserve();
			System.out.print("예약을 취소하시겠습니까? (y or n으로 입력)> ");
			String inputCan = ScanUtil.nextLine();
			
			if (inputCan.equalsIgnoreCase("y")) {
				insertCancel();
			} else if (inputCan.equalsIgnoreCase("n")) {
				
			} else {
				System.out.println("y or n으로 입력해주세요.");
				return 2;
			}
			break;
			case 3: showMyReview();
			break;
			case 0: 
				return View.MAIN_MEM;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (DuplicateKeyException e) {
			System.out.println("이미 이용된 예약입니다.");
		} catch (DataIntegrityViolationException e) {
			System.out.println("이미 이용된 예약입니다.");
		}
		catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생했습니다.");
			e.printStackTrace();
		}
		return mypageGo();
	}
	
	private void showMyInfo() {
		LoginService service = LoginService.getInstance();
		System.out.println(userDAO.showMemInfo(service.memsession.getMemId()));
	}
	
	private void showMyReserve() {
		LoginService service = LoginService.getInstance();
		List<ReservationVO> list = reservationDAO.selectReservation(service.memsession.getMemId());
		for (ReservationVO vo : list) {
			System.out.println(vo);
		}
	}
	
	private void showMyReview() {
		LoginService service = LoginService.getInstance();
		List<ReviewVO> list = reviewDAO.selectReviewListMem(service.memsession.getMemId());
		for (ReviewVO vo : list) {
			System.out.println(vo);
		}
	}
	
	private void insertCancel() {
		System.out.print("취소할 예약의 예약코드를 입력해주세요> ");
		long resNo = ScanUtil.nextLong();
		System.out.print("취소사유를 입력해주세요> ");
		String canReason = ScanUtil.nextLine();
		
		int resultCan = cancelDAO.insertCancel(new CancelVO(canReason, resNo));
		int resultRe = reservationDAO.deleteReserve(resNo);
		if ((resultCan != 0) && (resultRe != 0)) {
			System.out.println("예약을 취소했습니다.");
		} else {
			System.out.println("예약취소를 실패했습니다.");
		}
	}
}
