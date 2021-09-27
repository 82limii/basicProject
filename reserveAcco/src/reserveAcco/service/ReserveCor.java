package reserveAcco.service;

public class ReserveCor {
	private ReserveCor(){}
	private static ReserveCor instance;
	public static ReserveCor getInstance(){
		if(instance == null){
			instance = new ReserveCor();
		}
		return instance;
	}	
}
