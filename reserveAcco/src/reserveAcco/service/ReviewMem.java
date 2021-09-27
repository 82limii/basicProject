package reserveAcco.service;

public class ReviewMem {
	private ReviewMem(){}
	private static ReviewMem instance;
	public static ReviewMem getInstance(){
		if(instance == null){
			instance = new ReviewMem();
		}
		return instance;
	}	
}
