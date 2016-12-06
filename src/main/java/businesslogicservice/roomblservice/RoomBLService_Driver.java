package businesslogicservice.roomblservice;

import util.RoomCondition;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomBLService_Driver {
	
	public void drive(RoomBLService roomblservice){
		RoomVO room1 = roomblservice.addRoom(new RoomVO("大床房", 1, 198, "101", RoomCondition.UNRESERVED, "123"));
		if(room1 == new RoomVO()){
			System.out.println("Add Room Successfully ");
		}
		
		RoomVO room2 = roomblservice.reserve(new RoomVO("大床房", 1, 198, "101", RoomCondition.UNRESERVED,  "123"));
		if(room2 == new RoomVO()){
			System.out.println("Reserve Room Successfully ");
		}
		
		RoomVO room3 = roomblservice.checkOut(new RoomVO("大床房", 1, 198, "101", RoomCondition.CHECKIN, "123"));
		if(room3 == new RoomVO()){
			System.out.println("Checkout Room Successfully ");
		}
		
		RoomConditionDateVO roomcondition = new RoomConditionDateVO();
		RoomCondition rom = roomblservice.getRoomCondition(roomcondition);
		if(rom == RoomCondition.CHECKIN){
			System.out.println("The RoomCondition Is CheckIn");
		}
		
	}

}
