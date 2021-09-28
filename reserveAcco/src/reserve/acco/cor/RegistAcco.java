package reserve.acco.cor;

public class RegistAcco {
	private RegistAcco(){}
	private static RegistAcco instance;
	public static RegistAcco getInstance(){
		if(instance == null){
			instance = new RegistAcco();
		}
		return instance;
	}	
}
