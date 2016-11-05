package businesslogic.orderbl;
import util.ResultMessage;
import businesslogic.userbl.ClientController;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;
import businesslogicservice.orderblservice.*;

public class OrderController implements OrderBLService{
	Order order;
	String userid;
	public OrderController(){
		 userid=new ClientController().getuserId();
		order=new MockOrder(userid);
		
	}
	


	
	@Override
	public ListVO getAllList() {
		// TODO Auto-generated method stub
		return order.getAllList();
	}

	@Override
	public ListVO getHistoryList() {
		// TODO Auto-generated method stub
		return order.getHistoryList();
	}

	@Override
	public ListVO getCurrentList() {
		// TODO Auto-generated method stub
		return order.getCurrentList();
	}

	@Override
	public ListVO getUndoList() {
		// TODO Auto-generated method stub
		return order.getUndoList();
	}

	@Override
	public ListVO getAbnormalList() {
		// TODO Auto-generated method stub
		return order.getAbnormalList();
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

}
