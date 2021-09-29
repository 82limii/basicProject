package reserve.acco.common;

import reserve.acco.dao.UserDAO;
import reserve.acco.util.Application;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;
import reserve.acco.vo.CormemberVO;
import reserve.acco.vo.MemberVO;

public class LoginService {
	private LoginService(){}
	private static LoginService instance;
	public static LoginService getInstance(){
		if(instance == null){
			instance = new LoginService();
		}
		return instance;
	}
	private UserDAO userDao = UserDAO.getInstance();
	public MemberVO memsession = Application.getMemsession();
	public CormemberVO corsession = Application.getCorsession();
	
	public int login() {
		System.out.println("===========로그인===========");
		System.out.println("[1] 개인회원\t[2] 기업회원\t[0] 뒤로가기");
		System.out.print("번호를 입력해주세요> ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return loginMem();
		case 2: 
			return loginCor();
		case 0: break;
		default:
			System.out.println("다시 입력해주세요");
			login();
			break;
		}
		return View.HOME;
	}	
	
	// 개인회원 로그인
	public int loginMem() {
		System.out.println("개인회원 로그인을 선택하셨습니다.");
		System.out.print("아이디> ");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String memPass = ScanUtil.nextLine();
		
		memsession.setMemId(memId);
		memsession.setMemPass(memPass);
		MemberVO vo = null;
		try {
			vo = userDao.selectMem(memsession);			
			if(vo == null) {
				System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
				return View.HOME;
			} else {
				System.out.println("로그인 성공");
				return View.MAIN_MEM;
			}
		} catch (Exception e) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}
		return View.HOME; 	
		
	}
	
	// 법인회원 로그인
	public int loginCor() {
		System.out.println("기업회원 로그인을 선택하셨습니다.");
		System.out.print("아이디> ");
		String corId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String corPass = ScanUtil.nextLine();
		
		corsession.setCorId(corId);
		corsession.setCorPass(corPass);
		CormemberVO vo = null;
		try {
			vo = userDao.selectCor(corsession);
			if(vo == null) {
				System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
				return View.HOME;
			} else {
				System.out.println("로그인 성공");
				return View.MAIN_COR;
			}			
		} catch (Exception e) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			e.printStackTrace();
		}
		return View.HOME; 	
	}
}
