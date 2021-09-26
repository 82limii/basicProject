package VO;

public class RoomVO {
	private int roomId;
	private String accoId;
	private String roomName;
	private int roomMaxPeople;
	private int roomCost;
	private String roomIntro;
	private int roomTotal;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getAccoId() {
		return accoId;
	}
	public void setAccoId(String accoId) {
		this.accoId = accoId;
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
	public int getRoomTotal() {
		return roomTotal;
	}
	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}
	@Override
	public String toString() {
		return "RoomVO [roomId=" + roomId + ", accoId=" + accoId + ", roomName=" + roomName + ", roomMaxPeople="
				+ roomMaxPeople + ", roomCost=" + roomCost + ", roomIntro=" + roomIntro + ", roomTotal=" + roomTotal
				+ "]";
	}
	
	
}
