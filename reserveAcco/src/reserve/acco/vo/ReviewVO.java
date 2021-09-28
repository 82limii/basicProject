package reserve.acco.vo;

public class ReviewVO {
	private double reTotal;
	private double reClean;
	private double reKind;
	private double reConvenience;
	private String reDetail;
	private long resNo;
	
	public ReviewVO() {
	}
	public ReviewVO(double reClean, double reKind, double reConvenience, String reDetail, long resNo) {
		this.reClean = reClean;
		this.reKind = reKind;
		this.reConvenience = reConvenience;
		this.reDetail = reDetail;
		this.resNo = resNo;
	}
	
	public double getReTotal() {
		return reTotal;
	}
	public void setReTotal(double reTotal) {
		this.reTotal = reTotal;
	}
	public double getReClean() {
		return reClean;
	}
	public void setReClean(double reClean) {
		this.reClean = reClean;
	}
	public double getReKind() {
		return reKind;
	}
	public void setReKind(double reKind) {
		this.reKind = reKind;
	}
	public double getReConvenience() {
		return reConvenience;
	}
	public void setReConvenience(double reConvenience) {
		this.reConvenience = reConvenience;
	}
	public String getReDetail() {
		return reDetail;
	}
	public void setReDetail(String reDetail) {
		this.reDetail = reDetail;
	}
	public long getResNo() {
		return resNo;
	}
	public void setResNo(long resNo) {
		this.resNo = resNo;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [reTotal=" + reTotal + ", reClean=" + reClean + ", reKind=" + reKind + ", reConvenience="
				+ reConvenience + ", reDetail=" + reDetail + ", resNo=" + resNo + "]";
	}
	
}	// end of class