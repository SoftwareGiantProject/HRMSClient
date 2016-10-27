package businesslogicservice.hotelblservice;

import vo.*;
import util.*;

public interface HotelBLService {

	public HotelVO viewHotel();
	public HotelVO seekHotel(String name);
	
	public ResultMessage addHotel(HotelVO vo);
	public ResultMessage modifyHotel(HotelVO vo);
	public ResultMessage evaluateHotel(HotelVO vo);
}
