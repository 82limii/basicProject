package project.main;

import java.util.Scanner;

public class JoinView {
	public static void main(String[] args) {
		while(true) {
			System.out.println("선택해주세요.");
			System.out.println("1.회원가입 2.종료");
			Scanner scanner = new Scanner(System.in);
			
			String choice = scanner.nextLine();
			
			if(choice.equals("2")) {
				break;
			}else if(choice.equals("1")) {
				//아이디 입력
				System.out.println("아이디를 입력하세요.");
				
				//비번 입력
				//연락처 입력
				//개인-이름,닉네임, 생년월일
				//법인-사업자번호, 사업자명
				
			}
		}
		
	}
}