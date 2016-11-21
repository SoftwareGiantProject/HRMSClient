package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
import po.RoomPO;
import util.ResultMessage;

public class HotelDataServiceImpl implements HotelDataService{

private static final long serialVersionUID = 1L;
	
	public HotelDataServiceImpl() throws RemoteException{
		super();
	}
	
	@Override
	public RoomPO seekHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evaluateHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPO> viewHistoryHotel() {
		// TODO Auto-generated method stub
		return null;
	}

}
