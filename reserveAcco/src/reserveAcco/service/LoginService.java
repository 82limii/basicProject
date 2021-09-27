package reserveAcco.service;

import reserveAcco.dao.UserDao;
import reserveAcco.util.Application;
import reserveAcco.util.ScanUtil;
import reserveAcco.util.View;
import reserveAcco.vo.CormemberVO;
import reserveAcco.vo.MemberVO;

public class LoginService {
	private LoginService(){}
	private static LoginService instance;
	public static LoginService getInstance(){
		if(instance == null){
			instance = new LoginService();
		}
		return instance;
	}
	private UserDao userDao = UserDao.getInstance();
	private MemberVO memsession = Application.getMemsession();
	private CormemberVO corsession = Application.getCorsession();
	
	public int login() {
		System.out.println("===========로그인===========");
		System.out.println("[1] 개인회원\t[2] 기업회원\t[0] 뒤로가기");
		System.out.print("번호를 입력해주세요>");
		int input =ScanUtil.nextInt();
		
		switch(input) {
		case 1: loginMem();
			return View.MAIN;
		case 2: loginCor();
			return View.MAIN;
		case 0: break;
		default:
			System.out.println("다시 입력해주세요");
			login();
			break;
		}
		return View.HOME;
	}	
	
	// 개인회원 로그인
	public MemberVO loginMem() {
		System.out.print("아이디> ");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String memPass = ScanUtil.nextLine();
		
		memsession.setMemId(memId);
		memsession.setMemPass(memPass);
		
		MemberVO vo = userDao.selectMem(memsession);
		if(vo == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			System.out.println(MainService.LoginMem);
		}
		return vo; 	
	}
	
	// 법인회원 로그인
	public CormemberVO loginCor() {
		System.out.print("아이디> ");
		String corId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String corPass = ScanUtil.nextLine();
		
		corsession.setCorId(corId);
		corsession.setCorPass(corPass);
		
		CormemberVO vo = userDao.selectCor(corsession);
		if(vo == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			System.out.println(MainService.LoginCor);
		}
		return vo; 	
	}
}
