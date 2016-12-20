package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.networker.Hoteladd;
import businesslogicservice.hotelblservice.HotelBLService;
import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelController implements HotelBLService,Hoteladd {

	Hotel hotel;
	
	public HotelController() throws RemoteException {
		hotel = new Hotel();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<HotelVO> getHotelByArea(String area) {
		// TODO Auto-generated method stub
		return hotel.getHotelByArea(area);
	}

	@Override
	public ArrayList<HotelVO> getHotelByPrice(String area) {
		// TODO Auto-generated method stub
		return hotel.getHotelByPrice(area);
	}

	@Override
	public ArrayList<HotelVO> getHotelBylevel(String area) {
		// TODO Auto-generated method stub
		return hotel.getHotelBylevel(area);
	}

	@Override
	public ArrayList<HotelVO> getHotelByStar(String area) {
		// TODO Auto-generated method stub
		return hotel.getHotelByStar(area);
	}

	@Override
	public HotelVO viewHotel(String name) {
		// TODO Auto-generated method stub
		return hotel.viewHotel(name);
	}

	@Override
	public ArrayList<String> getAllCity() {
		// TODO Auto-generated method stub
		return hotel.getAllCity();
	}

	@Override
	public ArrayList<String> getAllAreaByCity(String city) {
		// TODO Auto-generated method stub
		return hotel.getAllAreaByCity(city);
	}

	@Override
	public ArrayList<HotelVO> viewAllHotel() {
		// TODO Auto-generated method stub
		return hotel.viewAllHotel();
	}

	@Override
	public ArrayList<HotelVO> search(String area, String room, int star, int lowscore, int highscore, int lowprice,
			int highprice) {
		// TODO Auto-generated method stub
		return hotel.search(area, room, star, lowscore, highscore, lowprice, highprice);
	}

	@Override
	public ArrayList<HotelVO> searchByRoom(String area, String room) {
		// TODO Auto-generated method stub
		return hotel.searchByRoom(area, room);
	}

	@Override
	public ArrayList<HotelVO> searchByStar(String area, int star) {
		// TODO Auto-generated method stub
		return hotel.searchByStar(area, star);
	}

	@Override
	public ArrayList<HotelVO> searchByScore(String area, int lowscore, int highscore) {
		// TODO Auto-generated method stub
		return hotel.searchByScore(area, lowscore, highscore);
	}

	@Override
	public ArrayList<HotelVO> searchByPrice(String area, int lowprice, int highprice, String room) {
		// TODO Auto-generated method stub
		return hotel.searchByPrice(area, lowprice, highprice, room);
	}

	@Override
	public HotelVO seekHotel(String name) {
		// TODO Auto-generated method stub
		return hotel.seekHotel(name);
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return hotel.addHotel(vo);
	}

	@Override
	public ArrayList<HotelVO> viewReservedHotel(String user_id) {
		// TODO Auto-generated method stub
		return hotel.viewReservedHotel(user_id);
	}

	@Override
	public ResultMessage modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return hotel.modifyHotel(vo);
	}

	@Override
	public ResultMessage evaluateHotel(HotelEvaluationVO vo, String hotel_name) {
		// TODO Auto-generated method stub
		return hotel.evaluateHotel(vo, hotel_name);
	}

	@Override
	public String getNmaeById(String hotel_id) {
		// TODO Auto-generated method stub
		return hotel.getHotelNameById(hotel_id);
	}

	
	
}
