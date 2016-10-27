package vo;

public class RoomVO {

	String Room_type;
	int Room_num;
	double Room_price;
	
	
	public RoomVO(String rt, int rn, double rp){
		Room_type = rt;
		Room_num = rn;
		Room_price = rp;
	}
	public RoomVO(){
		
	}
	
	public int getRoomNum(){
		return Room_num;
	}
	
	public String getRoomType(){
		return Room_type;
	}
	
	public double getRoomPrice(){
		return Room_price;
	}
	
	public RoomVO getRoomVO(){
		return this;
		
	}
}
