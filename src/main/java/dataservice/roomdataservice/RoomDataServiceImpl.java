package dataservice.roomdataservice;

import java.rmi.RemoteException;

import po.RoomConditionDatePO;
import po.RoomPO;
import util.ResultMessage;
import util.RoomConditon;

public class RoomDataServiceImpl implements RoomDataService{

	private static final long serialVersionUID = 1L;
	
	public RoomDataServiceImpl() throws RemoteException{
		super();
	}
	@Override
	public ResultMessage add(RoomPO room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomPO checkOut(RoomPO room_info) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RoomPO reserve(RoomPO room_info) {
		// TODO Auto-generated method stub
		return null;
	}

}
