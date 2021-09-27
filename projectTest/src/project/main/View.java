package project.main;

import java.util.Scanner;

import project.member.MemberController;
import project.util.ScannerUtil;

public class View {
	// 싱글톤 패턴
	private static View instance = new View();
	public static View getInstance() {
		return instance;
	}
	private View() {}
	
	// scanner
	private Scanner scanner = ScannerUtil.scanner();
	
	public int init() {
		System.out.println("WELCOME TO 여기갈래?");
		System.out.println(HomeMenu.HOME.getMenuString());
		return scanner.nextInt();
	}
	
	public int getMenu() {
		return scanner.nextInt();
	}
	
	public int memJoin (MemberController memcontroller) {
		int number;
		System.out.println("아이디: ");
		String memId = scanner.nextLine();
		
	}
}
