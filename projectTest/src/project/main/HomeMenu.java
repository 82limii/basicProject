package project.main;

import java.util.Scanner;

import project.util.MenuNotFoundException;

public enum HomeMenu {
	HOME(-1, "[1] 로그인\t[2] 회원가입\t [0]프래그램 종료\n메뉴를 선택하세요: "),
	QUIT(0, "프로그램을 종료합니다."),
	
	CHOOSE_LOGIN(1, "[11] 개인회원\t[12] 법인회원\t[13] 관리자\n회원의 종류를 선택하세요: "),
	MEM_LOGIN(11, "아이디와 비밀번호를 입력하세요\n"),
	COR_LOGIN(12, "아이디와 비밀번호를 입력하세요\n"),
	ADMIN_LOGIN(13, "아이디와 비밀번호를 입력하세요\n"),

	CHOOSE_JOIN(2, "[21] 개인회원가입\t[22] 법인회원가입\n가입할 회원의 종류를 선택하세요: "),
	MEM_JOIN(21, "회원가입에 필요한 정보를 입력합니다.\n"),
	COR_JOIN(22, "회원가입에 필요한 정보를 입력합니다.\n"),
	
	MEM_LOGOUT(91,"로그아웃 되었습니다!\n"),
	COR_LOGOUT(92, "로그아웃 되었습니다!\n"),
	ADMIN_LOGOUT(93, "로그아웃 되었습니다!\n"),

	MEM_MAIN(31, "[311] 예약하기\t[312] 후기남기기\t[313] 마이페이지\n메뉴를 선택하세요: "),
	RESERVE(311, ""),
	WRITE_REVIEW(312, ""),
	MEM(313, "[3131] 개인정보 확인\t[3132] 개인정보 수정\t[3133] 회원탈퇴\n메뉴를 선택하세요: "),
	MEM_INFO(3131, "개인정보 확인\n"),
	MEM_MODIFY_INFO(3132, "[31321] 비밀번호\t[31322] 전화번호\t[313] 이전메뉴\n수정할 항목을 선택하세요: "),
	MEM_MODIFY_PASS(31321, "비밀번호 수정\n수정할 비밀번호를 입력하세요: "),
	MEM_MODIFY_TEL(31322, "전화번호 수정\n수정할 전화번호를 입력하세요: "),
	MEM_DELETE(3133, "회원을 탈퇴합니다."),
	
	COR_MAIN(32, "[321] 숙소등록\t[322] 예약관리\t[323] 마이페이지\n메뉴를 선택하세요: "),
	REGIST_ACC(321, "숙소정보를 입력해주세요."),
	COR(323, "[3231] 개인정보 확인\t[3232] 개인정보 수정\t[3233] 숙소정보 확인\t[3234] 숙소정보 수정\n메뉴를 선택하세요: "),
	REGIST_ROOM(3211, "객실정보를 입력해주세요."),
	COR_INFO(3231, "개인정보 확인\n"),
	COR_MODIFY_INFO(3232, "[32321] 비밀번호\t[32322] 전화번호\t[323] 이전메뉴 \n수정할 항목을 선택하세요: "),
	COR_MODIFY_PASS(32321, "비밀번호 수정\n수정할 비밀번호를 입력하세요: "),
	COR_MODIFY_TEL(32322, "전화번호 수정\n수정할 전화번호를 입력하세요: "),
	
	ACC_INFO(3233, "숙소정보 확인\n"),
	ACC_MODIFY_INFO(3234,"[32341] 이름\t[32342] 편의시설\t[32343] 숙소소개\t [323] 이전메뉴\n수정할 항목을 선택하세요: "),
	ACC_MODIFY_NAME(32341, "이름 수정\n이름을 수정해주세요: "),
	ACC_MODIFY_FACILITY(32342, "편의시설 수정\n편의시설을 수정해주세요: "),
	ACC_MODIFY_INTRO(32343, "숙소소개 수정\n숙소소개를 수정해주세요: "),
	ROOM_INFO(32331, "객실정보 확인\t[3233] 이전메뉴"),
//	ROOM_MODIFY_INFO(),
//	ROOM_MODIFY_NAME,
//	ROOM_MODIFY_COST,
//	ROOM_MODIFY_INTRO,
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
