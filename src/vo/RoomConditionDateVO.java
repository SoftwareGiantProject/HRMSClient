package vo;

import java.util.Date;

import util.RoomConditon;

public class RoomConditionDateVO {
	
	//����Ԥ��ס��ʱ��
	Date RoomDate;
		
	//������
	String RoomNumber;
		
	//����״̬
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
