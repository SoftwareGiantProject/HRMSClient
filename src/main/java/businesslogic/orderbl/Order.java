package businesslogic.orderbl;
import util.ResultMessage;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;

import businesslogicservice.orderblservice.*;
public class Order implements OrderBLService{


	@Override
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO modifyOrder(OrderVO order, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage undoOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkOrder(OrderVO order_info, RoomVO room_info,
			CreditVO credit_info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
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