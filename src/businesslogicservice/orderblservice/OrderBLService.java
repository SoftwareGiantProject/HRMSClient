package businesslogicservice.orderblservice;

import vo.*;
import util.*;

public interface OrderBLService {

	public ListVO getAllList(String user_id);
	public ListVO getHistoryList(String user_id);
	public ListVO getCurrentList(String user_id);
	public ListVO getUndoList(String user_id);
	public ListVO getAbnormalList(String user_id);
	
	public OrderVO getOrder(String order_id);
	public OrderVO modifyOrder(OrderVO order,String type);
	
	public ResultMessage undoOrder(OrderVO order);
	public ResultMessage checkOrder(OrderVO order_info,RoomVO room_info,CreditVO credit_info);
	public ResultMessage saveOrder(OrderVO order);
	
}
