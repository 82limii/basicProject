package reserveAcco.service;

public class MypageCor {
	private MypageCor(){}
	private static MypageCor instance;
	public static MypageCor getInstance(){
		if(instance == null){
			instance = new MypageCor();
		}
		return instance;
	}	
}
