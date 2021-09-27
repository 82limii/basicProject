package reserveAcco.vo;

import java.sql.Date;

public class ReservationVO {
	   private int resNo;
	   private String resDate;
	   private String resInDate;
	   private String resOutDate;
	   private String memId;
	   private int roomId;
	   
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getResInDate() {
		return resInDate;
	}
	public void setResInDate(String resInDate) {
		this.resInDate = resInDate;
	}
	public String getResOutDate() {
		return resOutDate;
	}
	public void setResOutDate(String resOutDate) {
		this.resOutDate = resOutDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	@Override
	public String toString() {
		return "ReservationVO [resNo=" + resNo + ", resDate=" + resDate + ", resInDate=" + resInDate + ", resOutDate="
				+ resOutDate + ", memId=" + memId + ", roomId=" + roomId + "]";
	}
	      
	}	// end of class