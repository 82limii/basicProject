package reserve.acco.vo;

public class RoomVO {
	private String roomId;
	private String accoId;
	private double roomcost;
	private String roomIntro;
	private String roomName;
	private int roomMaxpeple;
	
	
	
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
	public double getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(double roomcost) {
		this.roomcost = roomcost;
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
	public int getRoomMaxpeple() {
		return roomMaxpeple;
	}
	public void setRoomMaxpeple(int roomMaxpeple) {
		this.roomMaxpeple = roomMaxpeple;
	}
	
	@Override
	public String toString() {
		return "RoomVO [roomId=" + roomId + ", roomcost=" + roomcost + ", roomIntro=" + roomIntro
				+ ", roomName=" + roomName + ", roomMaxpeple=" + roomMaxpeple + "]";
	}
		
}	// end of class
