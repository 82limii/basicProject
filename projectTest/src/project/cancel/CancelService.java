package project.cancel;

public class CancelService {
	// 싱글톤 패턴
	private static CancelService instance = new CancelService();
	public static CancelService getInstance() {
		return instance;
	}
	private CancelService() {}
		
	// DAO
	private CancelDao cancelDao = CancelDao.getInstance();
	
	public int createCancel(CancelVO vo) {
		return cancelDao.createCancel(vo);
	}
	
	public CancelVO readCancel(int resNo) {
		return cancelDao.readCancel(resNo);
	}
}	// end of class
