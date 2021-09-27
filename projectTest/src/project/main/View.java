package project.main;

import java.util.Scanner;

import project.cormember.CormemberController;
import project.cormember.CormemberVO;
import project.member.MemberController;
import project.member.MemberVO;
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
	
	// 개인회원 회원가입
	public int memJoin(MemberController memcont) {
		int number;
		System.out.print("아이디: ");
		String memId = scanner.nextLine();
		System.out.print("비밀번호: ");
		String memPass = scanner.nextLine();
		System.out.print("이름: ");
		String memName = scanner.nextLine();
		System.out.print("생년월일: ");
		String memBir = scanner.nextLine();
		System.out.print("닉네임: ");
		String memNick = scanner.nextLine();
		System.out.print("연락처: ");
		String memTel = scanner.nextLine();
		
		number = memcont.insertMember(new MemberVO(memId, memPass, memName, memBir, memNick, memTel));
		if(number == HomeMenu.HOME.getMenu()) {
			System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
		} else {
			System.out.print("회원가입 실패! 다시 회원가입을 하시겠습니까? (y / n 입력): ");
			String inputFlag = scanner.nextLine();
			if(inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.MEM_JOIN.getMenu();
			} else {
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}
	
	// 법인회원 회원가입
	public int corJoin(CormemberController corcont) {
		int number;
		System.out.print("사업자번호: ");
		String corNo = scanner.nextLine();
		System.out.print("아이디: ");
		String corId = scanner.nextLine();
		System.out.print("비밀번호: ");
		String corPass = scanner.nextLine();
		System.out.print("이름: ");
		String corName = scanner.nextLine();
		System.out.print("연락처: ");
		String corTel = scanner.nextLine();
		
		number = corcont.createCormember(new CormemberVO(corNo, corId, corPass, corName, corTel));
		if(number == HomeMenu.HOME.getMenu()) {
			System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
		} else {
			System.out.print("회원가입 실패! 다시 회원가입을 하시겠습니까? (y / n 입력): ");
			String inputFlag = scanner.nextLine();
			if(inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.COR_JOIN.getMenu();
			} else {
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}
}
