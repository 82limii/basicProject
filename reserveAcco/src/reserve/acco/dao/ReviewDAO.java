package reserve.acco.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import reserve.acco.util.Application;
import reserve.acco.vo.ReviewVO;

public class ReviewDAO {
	private ReviewDAO(){}
	private static ReviewDAO instance;
	public static ReviewDAO getInstance(){
		if(instance == null){
			instance = new ReviewDAO();
		}
		return instance;
	}	
	
	private JdbcTemplate template = Application.getTemplate(); 
	
	// 리뷰작성
	public int insertReview(ReviewVO vo) {
		return template.update("INSERT INTO REVIEW(RE_CLEAN, RE_KIND, RE_CONVENIENCE, RE_DETAIL, res_no) VALUES(?,?,?,?,?)",vo.getReClean(),vo.getReKind(),vo.getReConvenience(),vo.getReDetail(), vo.getResNo());
	}
	
	// 리뷰 총별점 업데이트
	public int updateReTotal(ReviewVO vo) {
		return template.update("UPDATE REVIEW SET RE_TOTAL = (RE_CLEAN + RE_KIND + RE_CONVENIENCE) / 3 WHERE RES_NO =?", vo.getResNo());
	}
	
	// 리뷰 목록 보여주기(개인)
	public List<ReviewVO> selectReviewListMem(String memId){
		return template.query("SELECT a.re_total, a.RE_CLEAN, a.RE_KIND, a.RE_CONVENIENCE, a.RE_DETAIL, a.RES_NO FROM review a inner join reservation b on a.res_no = b.res_no WHERE b.mem_id =?"
				, new BeanPropertyRowMapper<>(ReviewVO.class)
				, memId);
	}
	
	
	// 리뷰 목록 보여주기(법인)
	public List<Map<String, Object>> selectReviewListCor(String corId){
		return template.queryForList("SELECT a.res_no, a.re_total, a.re_clean, a.re_kind, a.RE_CONVENIENCE, a.RE_DETAIL FROM REVIEW a, reservation b, room c, acco d where a.res_no = b.res_no and b.room_id = c.room_id and c.ACCO_ID = d.ACCO_ID and d.cor_id = ?",new BeanPropertyRowMapper<>(ReviewVO.class),corId);
	}
	
	// 리뷰보기
	public ReviewVO selectReview(long resNo) {
		return template.queryForObject("SELECT RE_TOTAL, RE_CLEAN, RE_KIND, RE_CONVENIENCE, RE_DETAIL, RES_NO FROM EVENT WHERE RES_NO = ? ", new BeanPropertyRowMapper<>(ReviewVO.class) , resNo);
	}
	
	
}
