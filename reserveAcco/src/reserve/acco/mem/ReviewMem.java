package reserve.acco.mem;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import reserve.acco.common.LoginService;
import reserve.acco.dao.ReservationDAO;
import reserve.acco.dao.ReviewDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.ReservationVO;
import reserve.acco.vo.ReviewVO;

public class ReviewMem {
	public static void main(String[] args) {
		new ReviewMem().writeReview();
	}
	private ReviewMem(){}
	private static ReviewMem instance;
	public static ReviewMem getInstance(){
		if(instance == null){
			instance = new ReviewMem();
		}
		return instance;
	}	
	
	private ReviewDAO reviewdao = ReviewDAO.getInstance();
	private ReservationDAO reservationDAO = ReservationDAO.getInstance();
	
	public int reviewGo() {
		System.out.println("=====================");
		writeReview();
		return View.MAIN_MEM;
	}
	
	private void writeReview() {
		try {
			LoginService service = LoginService.getInstance();
			System.out.println("예약 목록");
			List<ReservationVO> reservationList = reservationDAO.selectReservation(service.memsession.getMemId());
			for (ReservationVO vo : reservationList) {
				System.out.println(vo);
			}
			System.out.print("예약번호 선택:");
			long reservationId = ScanUtil.nextLong();
			
			System.out.println("===============후기작성===============");
			System.out.print("청결도 별점을 입력해주세요(5점 만점)> ");
			double clean = ScanUtil.nextDouble();
			System.out.print("친절도 별점을 입력해주세요(5점 만점)> ");
			double kind = ScanUtil.nextDouble();
			System.out.print("편의시설 별점을 입력해주세요(5점 만점)> ");
			double convenience = ScanUtil.nextDouble();
			System.out.print("상세리뷰를 작성해주세요> ");
			String detail = ScanUtil.nextLine();
			ReviewVO vo = new ReviewVO(clean, kind, convenience, detail, reservationId);
			
			int result = reviewdao.insertReview(vo);
			if(result != 0) {
				System.out.println("리뷰작성이 완료되었습니다.");
				reviewdao.updateReTotal(vo);
			} else {
				System.out.println("리뷰작석이 실패되었습니다.");
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (DataIntegrityViolationException e) {
			System.out.println("양식에 맞게 입력해주세요.");
		} catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생했습니다.");
			e.printStackTrace();
		}
	}
}
