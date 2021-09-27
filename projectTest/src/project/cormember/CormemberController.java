package project.cormember;

import project.main.Application;
import project.main.HomeMenu;

public class CormemberController {
	// 싱글톤 패턴
	private static CormemberController instance = new CormemberController();
	public static CormemberController getInstance() {
		return instance;
	}
	private CormemberController() {}
	
	// 서비스 객체 생성
	private CormemberService cormemberService = CormemberService.getInstance();
	
	private CormemberVO corsession = Application.getCorSession();
	
	// 회원가입
	public int createCormember(CormemberVO vo) {
		try {
			if (cormemberService.createCormember(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		} catch (Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.HOME.getMenu();
	}
	
	// 법인회원 로그인
	public CormemberVO signInCormember(CormemberVO vo) {
		CormemberVO cor = cormemberService.findCormember(vo);
		if (cor == null) {
			return null;
		}
		corsession.setCorId(cor.getCorId());
		corsession.setCorName(cor.getCorName());
		return cor;
	}
	
	// 세션 초기화
	public int signOutCormem() {
		corsession.invalidate();
		return HomeMenu.HOME.getMenu();
	}
	// 회원정보 수정
	public int modifyCorPass(CormemberVO vo) {
		return cormemberService.modifyCorPass(vo);
	}
	
	public int modifyCorTel(CormemberVO vo) {
		return cormemberService.modifyCorTel(vo);
	}
	
	public int deleteCorMember(CormemberVO vo) {
		return cormemberService.deleteCorMember(vo);
	}
}	// end of class
