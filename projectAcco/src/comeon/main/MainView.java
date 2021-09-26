package comeon.main;

import java.util.Scanner;

public class MainView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("WELCOME TO 여기갈래"
				+ "[1]	로그인"
				+ "[2]	회원가입"
				+ "[0]	종료");
		int mainNum = scanner.nextInt();
		
		
	}
}
