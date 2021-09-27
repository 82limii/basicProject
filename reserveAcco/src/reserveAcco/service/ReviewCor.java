package reserveAcco.service;

public class ReviewCor {
	private ReviewCor(){}
	private static ReviewCor instance;
	public static ReviewCor getInstance(){
		if(instance == null){
			instance = new ReviewCor();
		}
		return instance;
	}	
}
