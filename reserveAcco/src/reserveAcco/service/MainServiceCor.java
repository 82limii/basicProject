package reserveAcco.service;

import reserveAcco.util.ScanUtil;
import reserveAcco.util.View;
import reserveAcco.vo.CormemberVO;
import reserveAcco.vo.MemberVO;

public class MainServiceCor {
	public static CormemberVO Login;
	
	private MainServiceCor(){}
	private static MainServiceCor instance;
	public static MainServiceCor getInstance(){
		if(instance == null){
			instance = new MainServiceCor();
		}
		return instance;
	}	
	public static void main() {
		new MainServiceCor().service();
	}
	
	private RegistAcco regAcco = RegistAcco.getInstance();
	private ReserveCor reserve = ReserveCor.getInstance();
	private ReviewCor review = ReviewCor.getInstance();
	private MypageCor mypage = MypageCor.getInstance();
	
	public int service() {
		int view = View.MAIN_COR;
		
		while(true) {			
			switch(view) {
			case View.MAIN_COR: view = serviceList(); break;
			case View.REGIST_ACCO: view = regAcco; break;
			case View.RESERVE_COR: view = reserve; break;
			case View.REVIEW_COR: view = review; break;
			case View.MYPAGE_COR: view = mypage; break;
			}
		}
	}
	
	public int serviceList() {
		System.out.println("==============================");
		System.out.println("[1] 숙소등록\t[2] 예약조회\t[3] 리뷰조회");
		System.out.println("[4] 마이페이지\t[9] 로그아웃\t[0] 종료");
		System.out.println("==============================");
		System.out.print(">");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.REGIST_ACCO;
		case 2: return View.RESERVE_COR;
		case 3: return View.REVIEW_COR;
		case 4: return View.MYPAGE_COR;
		case 9: 
			Login = null;
			return View.HOME;
		case 0:
			System.out.println("종료합니다.");
			System.exit(0);
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		return View.MAIN_COR;
	}
}
