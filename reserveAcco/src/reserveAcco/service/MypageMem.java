package reserveAcco.service;

public class MypageMem {
	private MypageMem(){}
	private static MypageMem instance;
	public static MypageMem getInstance(){
		if(instance == null){
			instance = new MypageMem();
		}
		return instance;
	}	
}
