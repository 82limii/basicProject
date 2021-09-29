package reserve.acco.vo;

public class ReservationVO {
	private long resNo;
	private String resDate;
	private String resInDate;
	private String resOutDate;
	private String memId;
	private String roomId;
	private int cnt;
	
	public ReservationVO() {
	}
	
	
	public ReservationVO(String resInDate, String resOutDate, String roomId) {
		this.resInDate = resInDate;
		this.resOutDate = resOutDate;
		this.roomId = roomId;
	}


	public long getResNo() {
		return resNo;
	}

	public void setResNo(long resNo) {
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

	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "예약번호 : " + resNo + ", " 
				+ (resDate != null ? "예약일자 : " + resDate + ", " : "")
				+ (resInDate != null ? "체크인" + resInDate + ", " : "")
				+ (resOutDate != null ? "체크아웃" + resOutDate + ", " : "")
				+ (roomId != null ? "객실코드 : " + roomId : "");
	}



} // end of class