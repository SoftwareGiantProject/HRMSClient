
package businesslogic.roombl;

import java.util.ArrayList;

import businesslogicservice.roomblservice.RoomBLService;
import util.ResultMessage;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomController implements RoomBLService{
	
	Room room;
	public RoomController() {
		room = new Room();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ResultMessage reserve(String Type, int num, String hotel_id, String inTime, String outTime) {
		// TODO Auto-generated method stub
		return room.reserve(Type, num, hotel_id, inTime, outTime);
	}

	@Override
	public ArrayList<RoomVO> getAllRoomByHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return room.getAllRoomByHotel(hotel_id);
	}

	@Override
	public ResultMessage modifyCondition(RoomConditionDateVO vo) {
		// TODO Auto-generated method stub
		return room.modifyCondition(vo);
	}

	@Override
	public void update() {
		room.update();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UPDATE() {
		room.UPDATE();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage addRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		return room.addRoom(vo);
	}



	@Override
	public ArrayList<RoomVO> findRooms(String hotel_id, String roomType) {
		// TODO Auto-generated method stub
		return room.findRooms(hotel_id, roomType);
	}



	@Override
	public ArrayList<RoomConditionDateVO> getAllRoomCondition() {
		// TODO Auto-generated method stub
		return room.getAllRoomCondition();
	}

}
