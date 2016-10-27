package po;

public class RoomPO {

	String Room_type;
	int Room_num;
	double Room_price;
	
	
	public RoomPO(String rt, int rn, double rp){
		Room_type = rt;
		Room_num = rn;
		Room_price = rp;
	}
	
	public void setRoom_type(String rt){
		this.Room_type = rt;
	}
	public void setRoom_num(int rn){
		this.Room_num = rn;
	}
	public void setRoom_price(double rp){
		this.Room_price = rp;
	}
	
	public String getRoom_type(){
		return Room_type;
	}
	public int getRoom_num(){
		return Room_num;
	}
	public double getRoom_price(){
		return Room_price;
	}
	

}
