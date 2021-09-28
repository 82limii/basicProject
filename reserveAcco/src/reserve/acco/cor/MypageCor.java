package reserve.acco.cor;

import reserve.acco.common.LoginService;
import reserve.acco.dao.UserDAO;
import reserve.acco.util.View;

public class MypageCor {
	private MypageCor(){}
	private static MypageCor instance;
	public static MypageCor getInstance(){
		if(instance == null){
			instance = new MypageCor();
		}
		return instance;
	}	
	
	private UserDAO userDao = UserDAO.getInstance();
	
	public int mypageGo() {
		System.out.println("===============마이페이지===============");
		System.out.println("내 정보를 조회합니다");
		LoginService service = LoginService.getInstance();
		System.out.println(userDao.showCorInfo(service.corsession.getCorId()));
		return View.MAIN_COR;
	}
}
