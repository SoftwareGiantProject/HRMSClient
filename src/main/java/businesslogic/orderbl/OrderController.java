package businesslogic.orderbl;
import util.ResultMessage;

import java.util.ArrayList;

import businesslogic.userbl.client.ClientController;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;
import businesslogicservice.orderblservice.*;

public class OrderController implements OrderBLService{

	public Order order = new Order();
	
	@Override
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		return order.getOrder(order_id);
	}

	@Override
	public ArrayList<OrderVO> getExecutedOrders(String hotel_id) {
		// TODO Auto-generated method stub	
		return null;
	}

	@Override
	public ArrayList<OrderVO> getUndoOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> getReversedOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> getAbnormalOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> getAllOrders(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evecuteOrder(String order_id, String executeTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage undoOrder(String client_id, String order_id, String undoTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewAllOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewExecutedOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewUndoOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewReversedOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewAbnormalOrderByClient(String client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
