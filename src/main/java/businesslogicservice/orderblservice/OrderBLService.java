package businesslogicservice.orderblservice;

import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import util.*;

public interface OrderBLService {


	public ArrayList<OrderVO> getExecutedOrderByHotelClient(String hotel_id, String client_id);
	
	public ArrayList<OrderVO> getExecutedOrders(String hotel_id);
	
	public ArrayList<OrderVO> getUndoOrders(String hotel_id);

	
	public ArrayList<OrderVO> getReversedOrders(String hotel_id);
	
	
	public ArrayList<OrderVO> getAbnormalOrders(String hotel_id);
	
	public ArrayList<OrderVO> getAllOrders(String hotel_id);
	
	
	public OrderVO getOrder(String order_id);
	
	
	public ArrayList<OrderVO> getAbnormalOrder();
		
	
	public ResultMessage evecuteOrder(String order_id, String executeTime);
	

	public ResultMessage undoOrder(String client_id, String order_id, String undoTime);
	
	
	public ResultMessage addOrder(OrderVO vo) throws RemoteException;
	
	public ArrayList<OrderVO> viewAllOrderByClient(String client_id);
	
	public ArrayList<OrderVO> viewExecutedOrderByClient(String client_id);
	
	public ArrayList<OrderVO> viewUndoOrderByClient(String client_id);
	
	public ArrayList<OrderVO> viewReversedOrderByClient(String client_id);
	

	public ArrayList<OrderVO> viewAbnormalOrderByClient(String client_id);

	public ResultMessage modifyOrder(OrderVO vo);
	
	

	
}
