package businesslogicservice.roomblservice;


import java.util.ArrayList;
import util.ResultMessage;
import vo.*;

public interface RoomBLService {

	public ArrayList<RoomConditionDateVO> getRoomConditionByOrder(String order_id);
	
	public ArrayList<RoomVO> findRooms(String hotel_id, String roomType);
	
	public ResultMessage addRoom(RoomVO vo);
	
	public ResultMessage reserve(String Type, int num, String hotel_id, String inTime, String outTime, String order_id);
	
	public ArrayList<RoomVO> getAllRoomByHotel(String hotel_id);

	public ResultMessage modifyCondition(RoomConditionDateVO vo);
	
	public ArrayList<RoomConditionDateVO> getAllRoomCondition();
	
	public void update();
	
	public void UPDATE();
}
