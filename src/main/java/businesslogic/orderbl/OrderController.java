package businesslogic.orderbl;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.OrderVO;
import businesslogicservice.orderblservice.*;

public class OrderController implements OrderBLService{
	Order order;
	
	public OrderController() throws RemoteException{
		order = new Order();
		
	}

	@Override
	public ArrayList<OrderVO> getExecutedOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return order.getExecutedOrders(hotel_id);
	}

	@Override
	public ArrayList<OrderVO> getUndoOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return order.getUndoOrders(hotel_id);
	}

	@Override
	public ArrayList<OrderVO> getReversedOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return order.getReversedOrders(hotel_id);
	}

	@Override
	public ArrayList<OrderVO> getAbnormalOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return order.getAbnormalOrders(hotel_id);
	}

	@Override
	public ArrayList<OrderVO> getAllOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return order.getAllOrders(hotel_id);
	}

	@Override
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		return order.getOrder(order_id);
	}

	@Override
	public ArrayList<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return order.getAbnormalOrder();
	}

	@Override
	public ResultMessage evecuteOrder(String order_id, String executeTime) {
		// TODO Auto-generated method stub
		return order.evecuteOrder(order_id, executeTime);
	}

	@Override
	public ResultMessage undoOrder(String client_id, String order_id, String undoTime) {
		// TODO Auto-generated method stub
		return order.undoOrder(client_id, order_id, undoTime);
	}

	@Override
	public ResultMessage addOrder(OrderVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return order.addOrder(vo);
	}

	@Override
	public ArrayList<OrderVO> viewAllOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return order.viewAllOrderByClient(client_id);
	}

	@Override
	public ArrayList<OrderVO> viewExecutedOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return order.viewExecutedOrderByClient(client_id);
	}

	@Override
	public ArrayList<OrderVO> viewUndoOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return order.viewUndoOrderByClient(client_id);
	}

	@Override
	public ArrayList<OrderVO> viewReversedOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return order.viewReversedOrderByClient(client_id);
	}

	@Override
	public ArrayList<OrderVO> viewAbnormalOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return order.viewAbnormalOrderByClient(client_id);
	}

	@Override
	public ResultMessage modifyOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return order.modifyOrder(vo);
	}

	@Override
	public ArrayList<OrderVO> getExecutedOrderByHotelClient(String hotel_id, String client_id) {
		// TODO Auto-generated method stub
		return order.getExecutedOrderByHotelClient(hotel_id, client_id);
	}
	
	
}
