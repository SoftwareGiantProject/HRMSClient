package businesslogicservice.orderblservice;

import vo.*;
import util.*;

public interface OrderBLService {

	public ListVO getAllList();
	public ListVO getHistoryList();
	public ListVO getCurrentList();
	public ListVO getUndoList();
	public ListVO getAbnormalList();
	
	public OrderVO getOrder(String order_id);
	public OrderVO modifyOrder(OrderVO order,String type);
	
	public ResultMessage undoOrder(OrderVO order);
	public ResultMessage checkOrder(OrderVO order_info,RoomVO room_info,CreditVO credit_info);
	public ResultMessage saveOrder(OrderVO order);
	
}
