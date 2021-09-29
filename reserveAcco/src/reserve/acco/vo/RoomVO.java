package reserve.acco.vo;

public class RoomVO {
	private String roomId;
	private String accoId;
	private int roomCost;
	private String roomIntro;
	private String roomName;
	private int roomMaxPeople;
	
	public RoomVO() {
	}
	
	public RoomVO(String roomId, String accoId, int roomCost, String roomIntro, String roomName, int roomMaxPeople) {
		this.roomId = roomId;
		this.accoId = accoId;
		this.roomCost = roomCost;
		this.roomIntro = roomIntro;
		this.roomName = roomName;
		this.roomMaxPeople = roomMaxPeople;
	}
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getAccoId() {
		return accoId;
	}
	public void setAccoId(String accoId) {
		this.accoId = accoId;
	}
	public int getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}
	public String getRoomIntro() {
		return roomIntro;
	}
	public void setRoomIntro(String roomIntro) {
		this.roomIntro = roomIntro;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomMaxPeople() {
		return roomMaxPeople;
	}
	public void setRoomMaxPeople(int roomMaxPeople) {
		this.roomMaxPeople = roomMaxPeople;
	}

	@Override
	public String toString() {
		return  (roomId != null ? "객실코드 : " + roomId + ", " : "")
				+ (accoId != null ? "숙소코드 : " + accoId + ", " : "") + "예약금액 : " + roomCost + ", "
				+ (roomIntro != null ? "객실정보 : " + roomIntro + ", " : "")
				+ (roomName != null ? "객실명 : " + roomName + ", " : "") + "최대인원수 : " + roomMaxPeople;
	}
		
}	// end of class
