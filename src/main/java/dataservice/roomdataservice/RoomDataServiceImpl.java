package dataservice.roomdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomConditionDatePO;
import po.RoomPO;
import util.ResultMessage;
import util.RoomCondition;

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
	public ArrayList<RoomPO> findRoom(String hotel_id, String room_type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomPO> getAllRoom(String hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modifyRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomConditionDatePO> getAllByDate(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomConditionDatePO> getRoomConditionPO(String hotel_id, String room_number)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modify(RoomPO room) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomPO> getAllRooms() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomConditionDatePO> getAllRoomCondition() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<RoomConditionDatePO> getRoomConditionByOrder(String order_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
