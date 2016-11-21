package dataservice.roomdataservice;

import java.rmi.RemoteException;

import po.RoomPO;
import util.ResultMessage;

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
	public ResultMessage modify(RoomPO room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomPO find(RoomPO room) {
		// TODO Auto-generated method stub
		return null;
	}

}
