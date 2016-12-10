package vo;

public class HotelVO {

    String hotel_id;
		
	String hotel_name;
	
	String hotel_address;
	
	String hotel_area;

	int hotel_level;
	
	double hotel_score;
	
	String hotel_intro;
	
	String hotel_serve;
	
	String hotel_room;
	
	
	public HotelVO(String hotel_id,String hotel_name,String hotel_address,String hotel_area,String hotel_intro,
			String hotel_serve,String hotel_room,int hotel_level, double hotel_score){
		this.hotel_address = hotel_address;
		this.hotel_area = hotel_area;
		this.hotel_intro = hotel_intro;
		this.hotel_name = hotel_name;
		this.hotel_room = hotel_room;
		this.hotel_serve = hotel_serve;
		this.hotel_level = hotel_level;
		this.hotel_score = hotel_score;
	}
	
	
	public int getHotel_level() {
		return hotel_level;
	}

	public double getHotel_score() {
		return hotel_score;
	}

	public String getHotelId(){
		return hotel_id;
	}
	
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}


	public void setHotel_area(String hotel_area) {
		this.hotel_area = hotel_area;
	}


	public void setHotel_level(int hotel_level) {
		this.hotel_level = hotel_level;
	}


	public void setHotel_score(double hotel_score) {
		this.hotel_score = hotel_score;
	}


	public void setHotel_intro(String hotel_intro) {
		this.hotel_intro = hotel_intro;
	}


	public void setHotel_serve(String hotel_serve) {
		this.hotel_serve = hotel_serve;
	}


	public void setHotel_room(String hotel_room) {
		this.hotel_room = hotel_room;
	}


	public String getHotelName(){
		return hotel_name;
	}
	
	public String getHotelAddress(){
		return hotel_address;
	}
	
	public String getHotelArea(){
		return hotel_area;
	}
	
	public String getHotelIntro(){
		return hotel_intro;
	}
	
	public String getHotelRoom(){
		return hotel_room;
	}
	
	public String getHotelServe(){
		return hotel_serve;
	}

	public HotelVO(){
		
	}
}
