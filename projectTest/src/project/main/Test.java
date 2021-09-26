package project.main;

import project.acco.AccoController;
import project.acco.AccoVO;
import project.cancel.CancelController;
import project.cancel.CancelVO;
import project.cormember.CormemberController;
import project.cormember.CormemberVO;

public class Test {
	public static void main(String[] args) {
		System.out.println("시작");
		
		AccoController accoController = AccoController.getInstance();
		
		AccoVO accoVO = new AccoVO();
		
//		AccoVO result = accoController.readAcco();
//		System.out.println(result.toString());
		
//		accoVO.setAccoRate(3.5);
//		accoVO.setAccoId("a001");
//		
//		int result = accoController.updateAccoRate(accoVO);
//		if (result == 1) {
//			System.out.println("평점이 업데이트 되었습니다.");
//		}
		
		System.out.println("------");
		
		CancelController cancelController = CancelController.getInstance();
		
		CancelVO cancelVO = new CancelVO();
		
		CancelVO result1 = cancelController.readCancel(88875);
		System.out.println("cancel : " + result1.toString());
		
		CormemberController cormemberController = CormemberController.getInstance();
		
		CormemberVO cormemberVO = new CormemberVO();
		
		CormemberVO result2 = cormemberController.readCormember("jaja01");
		System.out.println("cormember : " + result2.toString());
		
	}	// end of main
}	// end of class
