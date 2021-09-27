package reserveAcco.service;

import reserveAcco.dao.UserDao;
import reserveAcco.util.ScanUtil;
import reserveAcco.util.View;
import reserveAcco.vo.CormemberVO;
import reserveAcco.vo.MemberVO;

public class JoinService {
	private JoinService(){}//생성자
	private static JoinService instance;//변수생성
	public static JoinService getInstance(){
		if(instance == null){
			instance = new JoinService();
		}
		return instance;
	}
	private UserDao userDao = UserDao.getInstance();
	
	public int join() {
		System.out.println("===========회원가입===========");
		System.out.println("회원유형을 선택하세요");
		System.out.println("[1] 개인회원가입\t[2] 법인회원가입");
		System.out.print("번호를 입력해주세요> ");
	int input = ScanUtil.nextInt();
	
	switch(input) {
	case 1: joinMem();
		break;
	case 2: joinCormem();
		break;
	default:
		System.out.println("다시 입력해주세요.");
		break;
	}
	return View.HOME;
	}
	
	// 개인회원 가입정보 입력
	private void joinMem() {
		System.out.println("개인회원 가입을 선택하셨습니다.");
		System.out.println("상세정보를 입력해주세요");
		System.out.print("아이디> ");
		String memId = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String memPass = ScanUtil.nextLine();
		System.out.print("이름> ");
		String memName = ScanUtil.nextLine();
		System.out.print("생년월일(ex.20210928)> ");
		String memBir = ScanUtil.nextLine();
		System.out.print("전화번호> ");
		String memTel = ScanUtil.nextLine();
		
		int result = userDao.insertMem(new MemberVO(memId, memPass, memName, memBir, memTel));
		if(result != 0) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("회원가입 실패");
		}
	}
	
	// 법인회원 가입정보 입력
	private void joinCormem() {
		System.out.println("법인회원 가입을 선택하셨습니다.");
		System.out.println("상세정보를 입력해주세요");
		System.out.print("아이디> ");
		String corId = ScanUtil.nextLine();
		System.out.print("사업자번호(ex.123-22-42356)> ");
		String corNo = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String corPass = ScanUtil.nextLine();
		System.out.print("이름> ");
		String corName = ScanUtil.nextLine();
		System.out.print("전화번호> ");
		String corTel = ScanUtil.nextLine();
		
		int result = userDao.insertCor(new CormemberVO(corId, corNo, corPass, corName, corTel));
		if (result != 0) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("회원가입 실패");
		}
	}
}
