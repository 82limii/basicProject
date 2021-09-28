package reserve.acco.common;

import reserve.acco.cor.MainServiceCor;
import reserve.acco.mem.MainServiceMem;
import reserve.acco.util.ScanUtil;
import reserve.acco.util.View;

public class Controller {
	public static void main(String[] args) {
		new Controller().start();
	}
	private JoinService joinService = JoinService.getInstance();
	private LoginService loginService = LoginService.getInstance();
	private MainServiceMem mainServiceMem = MainServiceMem.getInstance();
	private MainServiceCor mainServiceCor = MainServiceCor.getInstance();
	
	public int start() {
		int view = View.HOME;
		
		while(true) {
			switch(view) {
			case View.HOME: view = home(); break;
			case View.LOGIN:view = loginService.login(); break;
			case View.JOIN: view = joinService.join(); break;
			case View.MAIN_MEM: view = mainServiceMem.service(); break;
			case View.MAIN_COR: view = mainServiceCor.service(); break;
			}
		}
	}
	
	private int home() {
		System.out.println("WELCOME TO 어디갈래?");
		System.out.println("[1] 로그인\t[2] 회원가입\t[0] 프로그램 종료");
		System.out.print("번호를 입력해주세요> ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0:
			System.out.println("이용해주셔서 감사합니다.\n시스템을 종료합니다.");
			System.exit(0);
		default:
			System.out.println("다시 입력해 주세요");
			break;
		}
		return View.HOME;
	}
}
