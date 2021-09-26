package project.cancel;

public class CancelController {
	// �̱��� ����
	private static CancelController instance = new CancelController();
	public static CancelController getInstance() {
		return instance;
	}
	private CancelController() {}
	
	// ���� ��ü ����
	private CancelService cancelService = CancelService.getInstance();
	
	public int createCancel(CancelVO vo) {
		return cancelService.createCancel(vo);
	}
	
	public CancelVO readCancel(int resNo) {
		return cancelService.readCancel(resNo);
	}
	
}	// end of class
