package project.review;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project.main.Application;

public class ReviewDao {
	private static ReviewDao instance = new ReviewDao();
	public static ReviewDao getInstance() {
		return instance;
	}
	private ReviewDao() {}
	
	private JdbcTemplate template = Application.getTemplate();
	
	//목록보기
	public List<Map<String, Object>> selectReviewList(){
		try {
			return template.queryForList("SELECT * FROM REVIEW",new BeanPropertyRowMapper<>(ReviewVO.class));
		} catch (DataAccessException e) {
			return null;
		}	
	}
	
	// 상세보기 	
	public ReviewVO selectReview(int resNo) {
		try {
			return template.queryForObject("SELECT RE_TOTAL, RE_CLEAN, RE_KIND, RE_CONVENIENCE, RE_DETAIL, RES_NO FROM EVENT WHERE RES_NO = ? ", new BeanPropertyRowMapper<>(ReviewVO.class) , resNo);
		} catch (DataAccessException e) {
			return null;
		}
	}
	// 리뷰 작성 (삽입) 조인?? 
	public int insertReview(ReviewVO vo) {
		try {
			return template.update("INSERT INTO REVIEW(RE_CLEAN, RE_KIND, RE_CONVENIENCE, RE_DETAIL, res_no) VALUES(?,?,?,?,?)",vo.getReClean(),vo.getReKind(),vo.getReConvenience(),vo.getReDetail(), vo.getResNo());
		}catch(DataAccessException e) {
			return 0;
		}
	}
	// 상세리뷰 수정  (update)
	public int updateReviewDetail(ReviewVO vo) throws Exception {
		try {
			return template.update("UPDATE REVIEW  SET RE_DETAIL = ? , WHERE = RES_NO = ? ", vo.getReDetail(),vo.getResNo());
		}catch(DataAccessException e) {
			return 0;
		}
	}
	// 청결도별점 수정
	public int updateReviewClean(ReviewVO vo) throws Exception {
		try {
			return template.update("UPDATE REVIEW  SET RE_CLEAN = ? , WHERE = RES_NO = ? ", vo.getReClean(),vo.getResNo());
		}catch(DataAccessException e) {
			return 0;
		}
	}
	// 서비스&편의성 수정
	public int updateReviewKind(ReviewVO vo) throws Exception {
		try {
			return template.update("UPDATE REVIEW  SET RE_KIND = ? , WHERE = RES_NO = ? ", vo.getReKind(),vo.getResNo());
		}catch(DataAccessException e) {
			return 0;
		}
	}
	
	// 리뷰 총별점 업데이트
	public int updateReTotal(ReviewVO vo) {
		try {
			return template.update("UPDATE REVIEW SET RE_TOTAL = (RE_CLEAN + RE_KIND + RE_CONVENIENCE) / 3 WHERE RES_NO =?", vo.getResNo());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	// 리뷰 삭제 (delete) 
	public int deleteReview(int resNo) throws Exception {
		try {
		return template.update("DELETE FROM REVIEW WHERE RES_NO = ?", resNo);
		}catch(DataAccessException e){
			return 0;
		}
	}
	
}

