package reserve.acco.vo;

public class CancelVO {
	private String canDate;
	private String canReason;
	private long resNo;
	
	public CancelVO() {
	}
	
	public CancelVO(String canReason, long resNo) {
		this.canReason = canReason;
		this.resNo = resNo;
	}

	public String getCanDate() {
		return canDate;
	}
	public void setCanDate(String canDate) {
		this.canDate = canDate;
	}
	public String getCanReason() {
		return canReason;
	}
	public void setCanReason(String canReason) {
		this.canReason = canReason;
	}
	public long getResNo() {
		return resNo;
	}
	public void setResNo(long resNo) {
		this.resNo = resNo;
	}
	
	@Override
	public String toString() {
		return "CancelVO [canDate=" + canDate + ", canReason=" + canReason + ", resNo=" + resNo + "]";
	}
	
}	// end of class
