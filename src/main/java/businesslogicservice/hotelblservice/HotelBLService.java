package businesslogicservice.hotelblservice;

import vo.*;
import util.*;

import java.util.ArrayList;
import java.util.List;

public interface HotelBLService {

	public HotelVO viewHotel(String name);
	public ArrayList<HotelVO> viewHistoryHotel();
	public HotelVO seekHotel(String name);
	
	public ResultMessage addHotel(HotelVO vo);
	public ResultMessage modifyHotel(HotelVO vo);
	public ResultMessage evaluateHotel(HotelEvaluationVO vo);
}
