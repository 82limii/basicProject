package project.cormember;

public class CormemberController {
	// 싱글톤 패턴
	private static CormemberController instance = new CormemberController();
	public static CormemberController getInstance() {
		return instance;
	}
	private CormemberController() {}
	
	// 서비스 객체 생성
	private CormemberService cormemberService = CormemberService.getInstance();
	
	public int createCormember(CormemberVO vo) {
		return cormemberService.createCormember(vo);
	}
	
	public CormemberVO readCormember(String corId) {
		return cormemberService.readCormember(corId);
	}
}	// end of class
