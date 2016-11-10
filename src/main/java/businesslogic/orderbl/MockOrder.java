package businesslogic.orderbl;
import util.ResultMessage;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;


public class MockOrder extends Order{
	String user_id;
	OrderVO  order;
	String order_id;
	RoomVO room;
	CreditVO credit;
	
	
	public MockOrder(String user_id){
		
		this.user_id=user_id;
		
	}
	public ListVO getAllList() {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	public ListVO getHistoryList() {
		// TODO Auto-generated method stub
		System.out.println("getHistoryList");
		return null;
	}

	
	public ListVO getCurrentList() {
		// TODO Auto-generated method stub
		System.out.println("getCurrentList");
		return null;
	}

	
	public ListVO getUndoList() {
		// TODO Auto-generated method stub
		System.out.println("getundoList");
		return null;
	}

	
	public ListVO getAbnormalList() {
		// TODO Auto-generated method stub
		System.out.println("getAbnormalList");
		return null;
	}

	
	public OrderVO getOrder(String order_id) {
		// TODO Auto-generated method stub
		System.out.println("getOrder");
		return null;
	}

	
	public OrderVO modifyOrder(OrderVO order, String type) {
		// TODO Auto-generated method stub
		System.out.println("modifyOrder");
		return null;
	}

	
	public ResultMessage undoOrder(OrderVO order) {
		// TODO Auto-generated method stub
		System.out.println("undoOrder");
		return null;
	}


	public ResultMessage checkOrder(OrderVO order_info, RoomVO room_info,
			CreditVO credit_info) {
		// TODO Auto-generated method stub
		System.out.println("checkOrder");
		return null;
	}

	
	public ResultMessage saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		System.out.println("saveOrder");
		return null;
	}
	

}