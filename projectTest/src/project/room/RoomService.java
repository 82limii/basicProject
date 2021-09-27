package project.room;

public class RoomService {
	private static RoomService instance = new RoomService();
 	public static RoomService getInstance() {
 		return instance;
 	}
	private RoomService() {}
	
	private RoomDao roomDao = RoomDao.getInstance();
	
	public int createRoom(RoomVO vo) {
		return roomDao.createRoom(vo);
	}
	
	public RoomVO readRoom() {
		return roomDao.readRoom();
	}
	
	public int updateRoomId(RoomVO vo) {
		return roomDao.updateRoomName(vo);
	}
	
	public int updateRoomcost(RoomVO vo) {
		return roomDao.updateRoomcost(vo);
	}
	
	public int delteRoom(RoomVO vo) {
		return roomDao.delteRoom(vo);
	}
}
