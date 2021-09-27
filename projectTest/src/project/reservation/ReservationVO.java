package project.reservation;

import java.sql.Date;

public class ReservationVO {
	   private int resNo;
	   private Date resDate;
	   private Date resInDate;
	   private Date resOutDate;
	   private int resPeople;
	   private int resPrice;
	   private String memId;
	   private int roomId;
	   
	   public int getResNo() {
	      return resNo;
	   }
	   public void setResNo(int resNo) {
	      this.resNo = resNo;
	   }
	   public Date getResDate() {
	      return resDate;
	   }
	   public void setResDate(Date resDate) {
	      this.resDate = resDate;
	   }
	   public Date getResInDate() {
	      return resInDate;
	   }
	   public void setResInDate(Date resInDate) {
	      this.resInDate = resInDate;
	   }
	   public Date getResOutDate() {
	      return resOutDate;
	   }
	   public void setResOutDate(Date resOutDate) {
	      this.resOutDate = resOutDate;
	   }
	   public int getResPeople() {
	      return resPeople;
	   }
	   public void setResPeople(int resPeople) {
	      this.resPeople = resPeople;
	   }
	   public int getResPrice() {
	      return resPrice;
	   }
	   public void setResPrice(int resPrice) {
	      this.resPrice = resPrice;
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
	            + resOutDate + ", resPeople=" + resPeople + ", resPrice=" + resPrice + ", memId=" + memId + ", roomId="
	            + roomId + "]";
	   }
	   
	   
	}