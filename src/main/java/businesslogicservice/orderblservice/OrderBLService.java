package businesslogicservice.orderblservice;

import vo.*;

import java.util.ArrayList;

import util.*;

public interface OrderBLService {

	public ArrayList<OrderVO> getAllList();
	public ArrayList<OrderVO> getHistoryList();
	public ArrayList<OrderVO> getCurrentList();
	public ArrayList<OrderVO> getUndoList();
	public ArrayList<OrderVO> getAbnormalList();
	
	public OrderVO getOrder(String order_id);
	public OrderVO modifyOrder(OrderVO order,String type);
	
	public ResultMessage undoOrder(OrderVO order);
	public ResultMessage checkOrder(OrderVO order_info,RoomVO room_info,CreditVO credit_info);
	public ResultMessage saveOrder(OrderVO order);
	
}
