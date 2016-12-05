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
	Order order;
	String userid;
	public OrderController(){
		order=new MockOrder(userid);
		
	}
	
	@Override
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		return order.getOrder(order_id);
	}

	@Override
	public OrderVO modifyOrder(OrderVO ordervo, String type) {
		// TODO Auto-generated method stub
		return order.modifyOrder(ordervo,type);
	}

	@Override
	public ResultMessage undoOrder(OrderVO ordervo) {
		// TODO Auto-generated method stub
		return order.undoOrder(ordervo);
	}

	@Override
	public ResultMessage checkOrder(OrderVO order_info, RoomVO room_info,
			CreditVO credit_info) {
		// TODO Auto-generated method stub
		return order.checkOrder(order_info, room_info, credit_info);
	}

	@Override
	public ResultMessage saveOrder(OrderVO ordervo) {
		// TODO Auto-generated method stub
		return order.saveOrder(ordervo);
	}






	@Override
	public ArrayList<OrderVO> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public ArrayList<OrderVO> getHistoryList() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public ArrayList<OrderVO> getCurrentList() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public ArrayList<OrderVO> getUndoList() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public ArrayList<OrderVO> getAbnormalList() {
		// TODO Auto-generated method stub
		return null;
	}

}
