package reserveAcco.vo;

public class CancelVO {
	private String canDate;
	private String canReason;
	private int resNo;
	
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
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	@Override
	public String toString() {
		return "CancelVO [canDate=" + canDate + ", canReason=" + canReason + ", resNo=" + resNo + "]";
	}
	
}	// end of class
