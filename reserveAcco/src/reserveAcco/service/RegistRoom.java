package reserveAcco.service;

public class RegistRoom {
	private RegistRoom(){}
	private static RegistRoom instance;
	public static RegistRoom getInstance(){
		if(instance == null){
			instance = new RegistRoom();
		}
		return instance;
	}	
}
