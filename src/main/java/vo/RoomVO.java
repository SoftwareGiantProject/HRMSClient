package vo;

import util.RoomCondition;

public class RoomVO {

	//房间类型
	String Room_type;
	
	//房间价格
	double Room_price;
	
	//房间编号
	String Room_number;
	
	//房间状态
	RoomCondition Room_condition;
	
	//酒店编号
	String Hotel_id;
	
	
	public RoomVO(String rt, int rn, double rp, String rnb, RoomCondition rc, String ho){
		
		Room_type = rt;
		Room_price = rp;
		Room_number = rnb;
		Room_condition = rc;
		Hotel_id = ho;
		
	}
	
	public RoomVO(){
		
	}

	public String getRoomType(){
		return Room_type;
	}
	
	public double getRoomPrice(){
		return Room_price;
	}
	
	public String getRoomNumber(){
		return Room_number;
	}
	
	public RoomCondition getRoomCondition(){
		return Room_condition;
	}
	
	public String getHotel_id(){
		return Hotel_id;
	}
	
	public RoomVO getRoomVO(){
		return this;		
	}
	
}

