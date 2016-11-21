package dataservice.roomdataservice;

import po.*;
import util.*;


public interface RoomDataService {

	public ResultMessage add(RoomPO room);
	
	public RoomPO checkOut(RoomPO room_info);
	public RoomPO reserve(RoomPO room_info);
	
}
