package businesslogicservice.hotelblservice;

import vo.*;
import util.*;

import java.util.ArrayList;
import java.util.List;

public interface HotelBLService {

	public String getNmaeById (String hotel_id);
	public ArrayList<HotelVO> getHotelByArea(String area);
	public ArrayList<HotelVO> getHotelByPrice(String area);
	public ArrayList<HotelVO> getHotelBylevel(String area);
	public ArrayList<HotelVO> getHotelByStar(String area);
	public HotelVO viewHotel(String name);
	public ArrayList<String> getAllCity();
	public ArrayList<String> getAllAreaByCity(String city);
	public ArrayList<HotelVO> viewAllHotel();
	public ArrayList<HotelVO> search(String area, String room, int star, int lowscore, int highscore, int lowprice, int highprice);
	public ArrayList<HotelVO> searchByRoom(String area, String room);
	public ArrayList<HotelVO> searchByStar(String area, int star);
	public ArrayList<HotelVO> searchByScore(String area, int lowscore, int highscore);
	public ArrayList<HotelVO> searchByPrice(String area, int lowprice, int highprice);
	public HotelVO seekHotel(String name);
	public ResultMessage addHotel(HotelVO vo);
	public ArrayList<HotelVO> viewReservedHotel(String user_id);
	public ResultMessage modifyHotel(HotelVO vo);
	public ResultMessage evaluateHotel(HotelEvaluationVO vo, String hotel_name);
}
