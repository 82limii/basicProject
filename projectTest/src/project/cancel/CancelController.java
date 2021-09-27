package project.cancel;

public class CancelController {
	// 싱글톤 패턴
	private static CancelController instance = new CancelController();
	public static CancelController getInstance() {
		return instance;
	}
	private CancelController() {}
	
	// 서비스 객체 생성
	private CancelService cancelService = CancelService.getInstance();
	
	public int createCancel(CancelVO vo) {
		return cancelService.createCancel(vo);
	}
	
	public CancelVO readCancel(int resNo) {
		return cancelService.readCancel(resNo);
	}
	
}	// end of class
