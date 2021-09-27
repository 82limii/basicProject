package project.member;



public class MemberService {
	// 싱글톤 패턴
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberService() {}
			
	// DAO
	private MemberDao memberDao = MemberDao.getInstance();
		
	public int insertMember(MemberVO vo) {
		return memberDao.insertMember(vo);
	}
		
	public MemberVO findMemUser(MemberVO vo) {
		return memberDao.findMemUser(vo);
	}
}	// end of class

