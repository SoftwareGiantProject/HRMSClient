package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.HotelEvaluationPO;
import po.HotelPO;
import po.RoomPO;
import util.ResultMessage;

public class HotelDataServiceImpl implements HotelDataService{

private static final long serialVersionUID = 1L;
	
	public HotelDataServiceImpl() throws RemoteException{
		super();
	}
	
	@Override
	public HotelPO seekHotel(String hotel_name) {
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
	public ResultMessage evaluateHotel(HotelEvaluationPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> viewHistoryHotel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> getReservedHotel(String user_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> getHotelByArea(String area) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> getHotelByLevel(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelEvaluationPO> getAllHotelEvaluation(String hotel_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> getAllHotel(String user_id, String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
