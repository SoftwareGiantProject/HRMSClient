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
	
	String city;
	
	
	public HotelVO(String hotel_id,String hotel_name,String hotel_address,String hotel_area,int hotel_level,double hotel_score,String hotel_intro,
			String hotel_serve,String hotel_room,String city){
		this.hotel_id = hotel_id;
		this.hotel_address = hotel_address;
		this.hotel_area = hotel_area;
		this.hotel_intro = hotel_intro;
		this.hotel_name = hotel_name;
		this.hotel_room = hotel_room;
		this.hotel_serve = hotel_serve;
		this.hotel_level = hotel_level;
		this.hotel_score = hotel_score;
		this.city = city;
	}
	
	public String getCity(){
		return city;
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
