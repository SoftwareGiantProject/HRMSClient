package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ListPO;
import po.OrderPO;
import util.ListType;
import util.ResultMessage;

public class OrderDataServiceImpl implements OrderDataService{
	
	private static final long serialVersionUID = 1L;
	
	public OrderDataServiceImpl() throws RemoteException{
		super();
	}
	@Override
	public OrderPO findOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage undoOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> findList(String user_id,String ListType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<OrderPO> getOrderByHotel(String hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
