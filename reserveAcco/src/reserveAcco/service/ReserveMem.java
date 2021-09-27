package reserveAcco.service;

public class ReserveMem {
	private ReserveMem(){}
	private static ReserveMem instance;
	public static ReserveMem getInstance(){
		if(instance == null){
			instance = new ReserveMem();
		}
		return instance;
	}	
}
