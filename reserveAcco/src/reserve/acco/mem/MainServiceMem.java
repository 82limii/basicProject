package reserve.acco.mem;

import reserve.acco.common.Controller;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.CormemberVO;
import reserve.acco.vo.MemberVO;

public class MainServiceMem {
	public static MemberVO Login;
	
	private MainServiceMem(){}
	private static MainServiceMem instance;
	public static MainServiceMem getInstance(){
		if(instance == null){
			instance = new MainServiceMem();
		}
		return instance;
	}	
	public static void main() {
		new MainServiceMem().service();
	}
	
	private ReserveMem reserve = ReserveMem.getInstance();
	private ReviewMem review = ReviewMem.getInstance();
	private MypageMem mypage = MypageMem.getInstance();
	
	public int service() {
		int view = View.MAIN_MEM;
		
		while(true) {
			switch(view) {			
			case View.MAIN_MEM: view = serviceList(); break;
			case View.RESERVE_MEM: view = reserve.reserveGo(); break;
			case View.REVIEW_MEM: view = review.reviewGo(); break;
			case View.MYPAGE_MEM: view = mypage.mypageGo(); break;
			case View.HOME: view = new Controller().start(); break;
			}
		}
	}
	
	public int serviceList() {
		System.out.println("==============================");
		System.out.println("[1] 예약하기\t[2] 후기작성\t[3] 마이페이지");
		System.out.println("[9] 로그아웃\t[0] 종료");
		System.out.println("==============================");
		System.out.print("> ");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.RESERVE_MEM;
		case 2: return View.REVIEW_MEM;
		case 3: return View.MYPAGE_MEM;
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
		return View.MAIN_MEM;
	}
}
