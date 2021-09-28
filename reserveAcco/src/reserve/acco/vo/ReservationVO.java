package reserve.acco.vo;

public class ReservationVO {
	private Long resNo;
	private String resDate;
	private String resInDate;
	private String resOutDate;
	private String memId;
	private String roomId;
	
	public ReservationVO() {
	}
	
	
	public ReservationVO(String resInDate, String resOutDate, String roomId) {
		this.resInDate = resInDate;
		this.resOutDate = resOutDate;
		this.roomId = roomId;
	}


	public Long getResNo() {
		return resNo;
	}

	public void setResNo(Long resNo) {
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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


	@Override
	public String toString() {
		return "ReservationVO [" + (resNo != null ? "resNo=" + resNo + ", " : "")
				+ (resDate != null ? "resDate=" + resDate + ", " : "")
				+ (resInDate != null ? "resInDate=" + resInDate + ", " : "")
				+ (resOutDate != null ? "resOutDate=" + resOutDate + ", " : "")
				+ (memId != null ? "memId=" + memId + ", " : "") + (roomId != null ? "roomId=" + roomId : "") + "]";
	}

	
	

} // end of class