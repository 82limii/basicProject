package project.review;

import java.util.List;
import java.util.Map;

public class ReviewService {
	private static ReviewService instance = new ReviewService();
	public static ReviewService getInstance() {
		return instance;
	}
	private ReviewService() {}

		private ReviewDao dao = ReviewDao.getInstance();
		
		public List<Map<String, Object>> selectEventList() {
			return dao.selectReviewList();
		}
		public ReviewVO selectReview(int resNo) throws Exception{
			return dao.selectReview(resNo);
		}
		public int insertReview(ReviewVO vo) throws Exception {
			return dao.insertReview(vo);
		}
		public int updateReviewDetail(ReviewVO vo) throws Exception {
			return dao.updateReviewDetail(vo);
		}
		public int updateReviewClean(ReviewVO vo) throws Exception {
			return dao.updateReviewClean(vo);
		}
		public int updateReviewKind(ReviewVO vo) throws Exception {
			return dao.updateReviewKind(vo);
		}
		public int deleteReview(int resNo) throws Exception {
			return dao.deleteReview(resNo);
		}

}
