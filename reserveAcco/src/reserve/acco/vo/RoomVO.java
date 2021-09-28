package reserve.acco.vo;

public class RoomVO {
	private String roomId;
	private String accoId;
	private double roomCost;
	private String roomIntro;
	private String roomName;
	private int roomMaxPeople;
	
	public RoomVO() {
	}
	
	public RoomVO(String roomId, String accoId, double roomCost, String roomIntro, String roomName, int roomMaxPeople) {
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
	public double getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(double roomCost) {
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
		return "RoomVO [" + (roomId != null ? "roomId=" + roomId + ", " : "")
				+ (accoId != null ? "accoId=" + accoId + ", " : "") + "roomCost=" + roomCost + ", "
				+ (roomIntro != null ? "roomIntro=" + roomIntro + ", " : "")
				+ (roomName != null ? "roomName=" + roomName + ", " : "") + "roomMaxPeople=" + roomMaxPeople + "]";
	}
		
}	// end of class
