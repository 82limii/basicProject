package project.cormember;

public class CormemberService {
	// ΩÃ±€≈Ê ∆–≈œ
	private static CormemberService instance = new CormemberService();
	public static CormemberService getInstance() {
		return instance;
	}
	private CormemberService() {}
		
	// DAO
	private CormemberDao cormemberDao = CormemberDao.getInstance();
	
	public int createCormember(CormemberVO vo) {
		return cormemberDao.createCormember(vo);
	}
	
	public CormemberVO readCormember(String corId) {
		return cormemberDao.readCormember(corId);
	}
}	// end of class
