package businesslogic.hotelbl;

import java.util.List;

import businesslogicservice.hotelblservice.HotelBLService;
import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelController implements HotelBLService {

	MockHotel hotel = new MockHotel();

	@Override
	public HotelVO viewHotel() {
		return hotel.viewHotel();
	}

	@Override
	public List<HotelVO> viewHistoryHotel() {
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
