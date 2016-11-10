package businesslogic.orderbl;
import util.ResultMessage;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;
import businesslogicservice.orderblservice.*;
public class Order implements OrderBLService{

	@Override
	public ListVO getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVO getHistoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVO getCurrentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVO getUndoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVO getAbnormalList() {
		// TODO Auto-generated method stub
		return null;
	}

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

}