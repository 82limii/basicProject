package project.review;

import java.util.List;
import java.util.Map;

public class ReviewController {
	private static ReviewController instance = new ReviewController();
	public static ReviewController getInstance() {
		return instance;
	}
	private ReviewController() {}
	
	ReviewService service = ReviewService.getInstance();
	
	public List<Map<String, Object>> selectEventList() {
		return service.selectEventList();
	}
	
	public ReviewVO selectReview(int resNo) throws Exception{
		return service.selectReview(resNo);
	}
	public int insertReview(ReviewVO vo) throws Exception {
		return service.insertReview(vo);
	}
	public int updateReviewDetail(ReviewVO vo) throws Exception {
		return service.updateReviewDetail(vo);
	}
	public int updateReviewClean(ReviewVO vo) throws Exception {
		return service.updateReviewClean(vo);
	}
	public int updateReviewKind(ReviewVO vo) throws Exception {
		return service.updateReviewKind(vo);
	}
	public int deleteReview(int resNo) throws Exception {
		return service.deleteReview(resNo);
	}

}
