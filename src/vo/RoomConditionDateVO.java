package vo;

import java.util.Date;

import util.RoomConditon;

public class RoomConditionDateVO {
	
	//房间预定住宿时间
	Date RoomDate;
		
	//房间编号
	String RoomNumber;
		
	//房间状态
	RoomConditon roomcondition;
		
	public RoomConditionDateVO(){
			
	}
		
	public RoomConditionDateVO(Date rd, String rn, RoomConditon rc){
	    	
	    RoomDate = rd;
	    RoomNumber = rn;
	    roomcondition = rc;
			
	}
	    
	public Date getRoomDate(){
	    return RoomDate;
	}
	    
	public String getRoomNumber(){
	    return RoomNumber;
	}
	    
	public RoomConditon getRoomCondition(){
	    return roomcondition;
	}

}
