package project.room;

public class RoomVO {
	private int roomId;
	private String accoId;
	private String roomName;
	private int roomMaxpeple;
	private double roomcost;
	private int roomIntro;
	
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
	public int getRoomMaxpeple() {
		return roomMaxpeple;
	}
	public void setRoomMaxpeple(int roomMaxpeple) {
		this.roomMaxpeple = roomMaxpeple;
	}
	
	public double getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(double roomcost) {
		this.roomcost = roomcost;
	}
	public int getRoomIntro() {
		return roomIntro;
	}
	public void setRoomIntro(int roomIntro) {
		this.roomIntro = roomIntro;
	}
	
	@Override
	public String toString() {
		return "RoomVO [roomId=" + roomId + ", accoId=" + accoId + ", roomName=" + roomName + ", roomMaxpeple="
				+ roomMaxpeple + ", roomIntro=" + roomIntro + ", roomToatal=" +  "]";
	}

		
}
