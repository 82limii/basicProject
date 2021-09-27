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
	// 회원가입
	public int insertMember(MemberVO vo) {
		try {
			if (memberService.insertMember(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		} catch (Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.HOME.getMenu();
	}
	
	// 일반회원 로그인
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
