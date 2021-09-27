package reserveAcco.service;

import reserveAcco.util.View;
import reserveAcco.vo.CormemberVO;
import reserveAcco.vo.MemberVO;

public class MainService {
	public static MemberVO LoginMem;
	public static CormemberVO LoginCor;
	
	private MainService(){}
	private static MainService instance;
	public static MainService getInstance(){
		if(instance == null){
			instance = new MainService();
		}
		return instance;
	}	
	public static void main() {
		new MainService().service();
	}
	
	public int service() {
		int view = View.MAIN;
		
	}
}
