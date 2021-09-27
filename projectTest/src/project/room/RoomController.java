package project.room;

public class RoomController {
	private static RoomController instance = new RoomController();
	public static RoomController getInstance() {
		return instance;
	}
	private RoomController() {}
	
	private RoomService roomService = RoomService.getInstance();
	
	public int createRoom(RoomVO vo) {
		return roomService.createRoom(vo);
	}
	
	public RoomVO readRoom() {
		return roomService.readRoom();
	}
	
	public int updateRoomId(RoomVO vo) {
		return roomService.updateRoomId(vo);
	}
	
	public int updateRoomcost(RoomVO vo) {
		return roomService.updateRoomcost(vo);
	}
	
	public int delteRoom(RoomVO vo) {
		return roomService.delteRoom(vo);
	}
}
