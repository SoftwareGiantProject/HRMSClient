package vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HotelVO {

    SimpleStringProperty hotel_id;
		
    SimpleStringProperty hotel_name;
	
    SimpleStringProperty hotel_address;
	
    SimpleStringProperty hotel_area;

	SimpleIntegerProperty hotel_level;
	
	SimpleDoubleProperty hotel_score;
	
	SimpleStringProperty hotel_intro;
	
	SimpleStringProperty hotel_serve;
	
	SimpleStringProperty hotel_room;
	
	SimpleStringProperty city;
	
	
	public HotelVO(String hotel_id,String hotel_name,String hotel_address,String hotel_area,int hotel_level,double hotel_score,String hotel_intro,
			String hotel_serve,String hotel_room,String city){
		this.hotel_id=new SimpleStringProperty(hotel_id);
		this.hotel_address = new SimpleStringProperty(hotel_address);
		this.hotel_area =new SimpleStringProperty( hotel_area);
		this.hotel_name = new SimpleStringProperty(hotel_name);
		this.hotel_room =new SimpleStringProperty( hotel_room);
		this.hotel_serve = new SimpleStringProperty(hotel_serve);
		this.hotel_level = new SimpleIntegerProperty(hotel_level);
		this.hotel_score =new SimpleDoubleProperty( hotel_score);
		this.hotel_intro=new SimpleStringProperty(hotel_intro);
		this.city =new SimpleStringProperty( city);
	}
	
	
	
	public SimpleStringProperty getCity(){
		return city;
	}
	
	public SimpleIntegerProperty getHotel_level() {
		return hotel_level;
	}

	public SimpleDoubleProperty getHotel_score() {
		return hotel_score;
	}

	public SimpleStringProperty getHotelId(){
		return hotel_id;
	}
	
	public SimpleStringProperty getHotelName(){
		return hotel_name;
	}
	
	public SimpleStringProperty getHotelAddress(){
		return hotel_address;
	}
	
	public SimpleStringProperty getHotelArea(){
		return hotel_area;
	}
	
	public SimpleStringProperty getHotelIntro(){
		return hotel_intro;
	}
	
	public SimpleStringProperty getHotelRoom(){
		return hotel_room;
	}
	
	public SimpleStringProperty getHotelServe(){
		return hotel_serve;
	}

	public HotelVO(){
		
	}
}
