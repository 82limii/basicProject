package project.cancel;

public class CancelController {
	// ½Ì±ÛÅæ ÆÐÅÏ
	private static CancelController instance = new CancelController();
	public static CancelController getInstance() {
		return instance;
	}
	private CancelController() {}
	
	// ¼­ºñ½º °´Ã¼ »ý¼º
	private CancelService cancelService = CancelService.getInstance();
	
	public int createCancel(CancelVO vo) {
		return cancelService.createCancel(vo);
	}
	
	public CancelVO readCancel(int resNo) {
		return cancelService.readCancel(resNo);
	}
	
}	// end of class
