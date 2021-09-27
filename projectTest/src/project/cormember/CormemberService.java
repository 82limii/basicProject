package project.cormember;

public class CormemberService {
	// 싱글톤 패턴
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
	
	public CormemberVO findCormember(CormemberVO vo) {
		return cormemberDao.findCormember(vo);
	}
	
	public int modifyCorPass(CormemberVO vo) {
		return cormemberDao.modifyCorPass(vo);
	}
	
	public int modifyCorTel(CormemberVO vo) {
		return cormemberDao.modifyCorTel(vo);
	}
	
	public int deleteCorMember(CormemberVO vo) {
		return cormemberDao.deleteCorMember(vo);
	}
	
}	// end of class
