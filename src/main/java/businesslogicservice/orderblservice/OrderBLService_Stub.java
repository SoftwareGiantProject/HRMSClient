package businesslogicservice.orderblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;

public class OrderBLService_Stub implements  OrderBLService{

	String user_id;
	OrderVO  order;
	String order_id;
	RoomVO room;
	CreditVO credit;
	
	public OrderBLService_Stub(String user_id,OrderVO  order,RoomVO room,CreditVO credit,String order_id){
		this.user_id=user_id;
		this.order=order;
		this.order_id=order_id;
		this.room=room;
		this.credit=credit;
	}


	@Override
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		return new OrderVO(order_id);
	}

	@Override
	public OrderVO modifyOrder(OrderVO order, String type) {
		// TODO Auto-generated method stub
		return new OrderVO(order,type);
	}

	@Override
	public ResultMessage undoOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkOrder(OrderVO order_info, RoomVO room_info, CreditVO credit_info) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
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
