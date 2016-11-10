package businesslogic.hotelbl;

import java.util.List;

import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class MockHotel {

	private String hotel_id;
	private String hotel_name;
	private String hotel_address;
	private String hotel_area;
	private String hotel_intro;
	private String hotel_serve;
	private String hotel_room;
	
	
	public MockHotel(){
		
	}
	
	public MockHotel(String hotel_id,String hotel_name,String hotel_address,String hotel_area,String hotel_intro,
			String hotel_serve,String hotel_room){
		this.hotel_id = hotel_id;
		this.hotel_address = hotel_address;
		this.hotel_area = hotel_area;
		this.hotel_intro = hotel_intro;
		this.hotel_name = hotel_name;
		this.hotel_room = hotel_room;
		this.hotel_serve = hotel_serve;
		
	}
	
	public HotelVO viewHotel(){
		return null;
	}
	public List<HotelVO> viewHistoryHotel(){
		return null;
	}
	public HotelVO seekHotel(String name){
		return null;
	}
	
	public ResultMessage addHotel(HotelVO vo){
		return null;
	}
	public ResultMessage modifyHotel(HotelVO vo){
		return null;
	}
	public ResultMessage evaluateHotel(HotelEvaluationVO vo){
		return null;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public String getHotel_area() {
		return hotel_area;
	}

	public String getHotel_intro() {
		return hotel_intro;
	}

	public String getHotel_serve() {
		return hotel_serve;
	}

	public String getHotel_room() {
		return hotel_room;
	}
}
