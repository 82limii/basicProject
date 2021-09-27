package reserveAcco.controller;

import reserveAcco.service.JoinService;
import reserveAcco.service.LoginService;
import reserveAcco.service.MainServiceCor;
import reserveAcco.service.MainServiceMem;
import reserveAcco.util.ScanUtil;
import reserveAcco.util.View;

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
		System.out.print("번호를 입력해주세요.> ");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0:
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		default:
			System.out.println("다시 입력해 주세요");
			break;
		}
		return View.HOME;
	}
}
