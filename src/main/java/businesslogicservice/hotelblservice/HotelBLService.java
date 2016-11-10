package businesslogicservice.hotelblservice;

import vo.*;
import util.*;
import java.util.List;

public interface HotelBLService {

	public HotelVO viewHotel();
	public List<HotelVO> viewHistoryHotel();
	public HotelVO seekHotel(String name);
	
	public ResultMessage addHotel(HotelVO vo);
	public ResultMessage modifyHotel(HotelVO vo);
	public ResultMessage evaluateHotel(HotelEvaluationVO vo);
}
