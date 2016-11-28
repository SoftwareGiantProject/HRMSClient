package businesslogic.hotelbl;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.hotelblservice.HotelBLService;
import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelController implements HotelBLService {

	Hotel hotel = new Hotel();

	@Override
	public HotelVO viewHotel(String name) {
		return hotel.viewHotel(name);
	}

	@Override
	public ArrayList<HotelVO> viewHistoryHotel() {
		return hotel.viewHistoryHotel();
	}

	@Override
	public HotelVO seekHotel(String name) {
		return hotel.seekHotel(name);
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) {
		return hotel.addHotel(vo);
	}

	@Override
	public ResultMessage modifyHotel(HotelVO vo) {
		return hotel.modifyHotel(vo);
	}

	@Override
	public ResultMessage evaluateHotel(HotelEvaluationVO vo) {
		return hotel.evaluateHotel(vo);
	}
	
}
