//package project.main;
//
//import java.util.Scanner;
//import basicProjectCommon.HomeMenu;
//import basicProjectCommon.ScannerUtil;
//
//public class CorMemberView {
//	private static CorMemberView instance = new CorMemberView();
//	private CorMemberView() {}
//	public static CorMemberView getInstance() {
//		return instance;
//	}
//
//	private Scanner scanner = ScannerUtil.scanner();	
//	
//    public int init() {
//        System.out.println("[기업회원 가입화면]");
//        System.out.print(HomeMenu.HOME.getMenuString());
//        return scanner.nextInt();
//    }
//	
//    public int getMenu() {
//    	return scanner.nextInt();
//    }
//    
//    public int CorMemberJoin(CorMemberJoinController controller) {
//        int number;
//        System.out.print("아이디: ");
//        int custId = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("이름: ");
//        String name = scanner.nextLine();
//        System.out.print("주소: ");
//        String address = scanner.nextLine();
//        System.out.print("전화번호: ");
//        String phone = scanner.nextLine();
//        System.out.print("패스워드: ");
//        String password = scanner.nextLine();
//		number = controller.corMemberJoin(new CorMemberVO(corNo, corId, corPass, corName, corTel));
//        if (number == HomeMenu.HOME.getMenu()) {
//            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
//        } else {
//            System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
//            String inputFlag = scanner.nextLine();
//            if (inputFlag.equalsIgnoreCase("y")) {
//                number = HomeMenu.JOIN.getMenu();
//            } else {
//                number = HomeMenu.HOME.getMenu();
//            }
//        }
//        return number;
//    }	
//}
