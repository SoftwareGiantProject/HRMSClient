package businesslogictest;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.orderbl.OrderController;
import util.ListType;
import vo.OrderVO;

public class OrderTest {

	OrderController orderController;
	
	@Before
	public void init() throws RemoteException{
		orderController = (OrderController) ControllerFactory.getOrderBLServiceInstance();
	}
	
	/**
	@Test 获得已执行订单 测试成功
	public void testGetExecutedOrders(){
		String hotel_id = "h001";
		ArrayList<OrderVO> list = new ArrayList<>();
		list= orderController.getExecutedOrders(hotel_id);
		
		for(OrderVO vo : list){
			System.out.println(vo.getOrder_id());
			System.out.println(vo.getUser_id());
			System.out.println(vo.getHotel_id());
			System.out.println(vo.getOrderPrice());
			System.out.println(vo.getStartTime());
			System.out.println(vo.getEndTime());
			System.out.println(vo.getDeadline());
			System.out.println(vo.getExecuteTime());
			System.out.println(vo.getPredictCheckInTime());
			System.out.println(vo.getPredictCheckOutTime());
			System.out.println(vo.getRoomType());
			System.out.println(vo.getNumber());
			System.out.println(vo.getPeople());
			System.out.println(vo.isHasChild());
			System.out.println(vo.getListType());
		}
	}
	*/
	
	/**
	@Test 获得撤销订单 测试成功
	public void testGetUndoOrders(){
		String hotel_id = "h002";
		ArrayList<OrderVO> list = new ArrayList<>();
		list= orderController.getUndoOrders(hotel_id);
		
		for(OrderVO vo : list){
			System.out.println(vo.getOrder_id());
			System.out.println(vo.getUser_id());
			System.out.println(vo.getHotel_id());
			System.out.println(vo.getOrderPrice());
			System.out.println(vo.getStartTime());
			System.out.println(vo.getEndTime());
			System.out.println(vo.getDeadline());
			System.out.println(vo.getExecuteTime());
			System.out.println(vo.getPredictCheckInTime());
			System.out.println(vo.getPredictCheckOutTime());
			System.out.println(vo.getRoomType());
			System.out.println(vo.getNumber());
			System.out.println(vo.getPeople());
			System.out.println(vo.isHasChild());
			System.out.println(vo.getListType());
		}
	}
	*/
	
	/**
	@Test  获得订单信息 测试成功
	public void testGetOrder(){
		String order_id = "201611250001";
		
		OrderVO vo = new OrderVO();
		
		vo = orderController.getOrder(order_id);
		
		System.out.println(vo.getOrder_id());
		System.out.println(vo.getUser_id());
		System.out.println(vo.getHotel_id());
		System.out.println(vo.getOrderPrice());
		System.out.println(vo.getStartTime());
		System.out.println(vo.getEndTime());
		System.out.println(vo.getDeadline());
		System.out.println(vo.getExecuteTime());
		System.out.println(vo.getPredictCheckInTime());
		System.out.println(vo.getPredictCheckOutTime());
		System.out.println(vo.getRoomType());
		System.out.println(vo.getNumber());
		System.out.println(vo.getPeople());
		System.out.println(vo.isHasChild());
		System.out.println(vo.getListType());
	}
	*/
	
	/**
	@Test //执行订单 测试成功
	public void testEvecuteOrder(){
		String order_id = "5835696";
		
		String executeTime = "2016-12-16-23-02-59";
		
		orderController.evecuteOrder(order_id, executeTime);
	}
	*/
	
	/**  生成订单成功
	@Test 
		public void testAddOrder(){
		OrderVO vo = new OrderVO("151250090","h001","2016-12-16-20-18-00","2016-12-16","2016-12-17","大床房",1,2,false,ListType.CURRENTLIST);
	
		try {
			orderController.addOrder(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	//撤销订单成功
	@Test 
	public void testUndoOrder(){
		String client_id = "151250090";
		String order_id = "5835696";
		String undoTime = "2016-12-16-22-20-03";
		
		orderController.undoOrder(client_id, order_id, undoTime);
	}
	*/
}
