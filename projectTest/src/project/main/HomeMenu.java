package project.main;

import java.util.Scanner;

import project.util.MenuNotFoundException;

public enum HomeMenu {
	HOME(-1, "[1] 로그인\t[2] 회원가입\t [0]프래그램 종료\n메뉴를 선택하세요: "),
	QUIT(0, "프로그램을 종료합니다."),
	CHOOSELOGIN(1, "[11] 개인회원\t[12] 법인회원\t[13] 관리자\n회원의 종류를 선택하세요: "),
	MEM_LOGIN(11, "아이디와 비밀번호를 입력하세요\n"),
	COR_LOGIN(12, "아이디와 비밀번호를 입력하세요\n"),
	ADMIN_LOGIN(13, "아이디와 비밀번호를 입력하세요\n"),
	CHOOSEJOIN(2, "[21] 개인회원가입\t[22] 법인회원가입\n가입할 회원의 종류를 선택하세요: "),
	MEM_JOIN(21, "회원가입에 필요한 정보를 입력합니다.\n"),
	COR_JOIN(22, "회원가입에 필요한 정보를 입력합니다.\n"),
	;
	
	
	private final int menu;
	private final String menuString;
	
	HomeMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}
	
	public int getMenu() {
		return menu;
	}
	
	public String getMenuString() {
		return menuString;
	}
	
	public static HomeMenu findMenu(int number) throws MenuNotFoundException {
		for (HomeMenu menu: values()) {
			if(menu.getMenu() == number) {
				return menu;
			}
		}
		throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
	}
	
	public void display(Scanner scanner) {
		
	}
}
