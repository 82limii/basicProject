package project.cormember;

public class CormemberController {
	// ½Ì±ÛÅæ ÆÐÅÏ
	private static CormemberController instance = new CormemberController();
	public static CormemberController getInstance() {
		return instance;
	}
	private CormemberController() {}
	
	// ¼­ºñ½º °´Ã¼ »ý¼º
	private CormemberService cormemberService = CormemberService.getInstance();
	
	public int createCormember(CormemberVO vo) {
		return cormemberService.createCormember(vo);
	}
	
	public CormemberVO readCormember(String corId) {
		return cormemberService.readCormember(corId);
	}
}	// end of class
