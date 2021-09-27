package project.member;

import project.main.Application;
import project.main.HomeMenu;

public class MemberController {
	// 싱글톤 패턴
	private static MemberController instance = new MemberController();
	public static MemberController getInstance() {
		return instance;
	}
	private MemberController() {}
	
	// 서비스 객체 생성
	private MemberService memberService = MemberService.getInstance();
	
	private MemberVO memsession = Application.getMemberSession();
	
	public int insertMember(MemberVO vo) {
		return memberService.insertMember(vo);
	}
	
	// 멤버 로그인
	public MemberVO signInMem(MemberVO vo) {
		MemberVO mem = memberService.findMemUser(vo);
		if (mem == null) {
			return null;
		}
		memsession.setMemId(mem.getMemId());
		memsession.setMemName(mem.getMemName());
		return mem;
	}
	
	//세션 초기화
	public int signOutMem() {
		memsession.invalidate();
		return HomeMenu.HOME.getMenu();
	}
	
}	// end of class
