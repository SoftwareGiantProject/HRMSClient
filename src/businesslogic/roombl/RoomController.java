
package businesslogic.roombl;

import businesslogicservice.roomblservice.RoomBLService;
import util.RoomConditon;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomController implements RoomBLService{
	
	MockRoom Room = new MockRoom();

	@Override
	public RoomVO addRoom(RoomVO room_info) {
		return Room.addRoom(room_info);
	}

	@Override
	public RoomVO checkOut(RoomVO room_info) {
		return Room.checkOut(room_info);
	}

	@Override
	public RoomVO reserve(RoomVO room_info) {
		return Room.reserve(room_info);
	}

	@Override
	public RoomConditon getRoomCondition(RoomConditionDateVO room_condition) {
		return Room.getRoomCondition(room_condition);
	}

	@Override
	public RoomVO getRoomInfo(RoomVO room) {
		return null;
	}

}
