package dataservice.hoteldataservice;

import java.util.ArrayList;
import java.util.List;

import po.*;
import util.*;


public interface HotelDataService {


	public HotelPO seekHotel(String hotel_name);
	public ArrayList<HotelPO> viewHistoryHotel();
	
	public ResultMessage addHotel(HotelPO po);
	public ResultMessage modifyHotel(HotelPO po);
	public ResultMessage evaluateHotel(HotelEvaluationPO po);
}
