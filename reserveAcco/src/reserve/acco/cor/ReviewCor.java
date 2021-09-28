package reserve.acco.cor;

import java.util.List;

import reserve.acco.common.LoginService;
import reserve.acco.dao.AccoDAO;
import reserve.acco.dao.ReviewDAO;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.AccoVO;

public class ReviewCor {
	private ReviewCor(){}
	private static ReviewCor instance;
	public static ReviewCor getInstance(){
		if(instance == null){
			instance = new ReviewCor();
		}
		return instance;
	}	
	
	private AccoDAO accoDAO = AccoDAO.getInstance();
	private ReviewDAO reviewDAO = ReviewDAO.getInstance();
	
	public int reviewGo() {
		System.out.println("===============리뷰조회===============");
		showReview();
		return View.MAIN_COR;
	}
	
	public void showReview() {
		LoginService service = LoginService.getInstance();
		List<AccoVO> list = accoDAO.showAcco(service.corsession.getCorId());
		for (AccoVO vo : list) {
			System.out.println(vo);
		}
		System.out.print("후기를 조회할 숙소코드를 입력해주세요> ");
		String accoId = ScanUtil.nextLine();
		System.out.println(reviewDAO.selectReviewAccoId(accoId));
	}
}
