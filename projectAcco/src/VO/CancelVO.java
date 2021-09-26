package VO;

import java.util.Date;

public class CancelVO {
	private Date canDate;
	private String canReason;
	private int canPrice;
	private int resNo;
	public Date getCanDate() {
		return canDate;
	}
	public void setCanDate(Date canDate) {
		this.canDate = canDate;
	}
	public String getCanReason() {
		return canReason;
	}
	public void setCanReason(String canReason) {
		this.canReason = canReason;
	}
	public int getCanPrice() {
		return canPrice;
	}
	public void setCanPrice(int canPrice) {
		this.canPrice = canPrice;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	@Override
	public String toString() {
		return "CancelVO [canDate=" + canDate + ", canReason=" + canReason + ", canPrice=" + canPrice + ", resNo="
				+ resNo + "]";
	}
	
	
}
