package businesslogic.orderbl;
import util.ListType;
import util.ResultMessage;
import vo.CreditVO;
import vo.ListVO;
import vo.OrderVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import businesslogic.creditbl.Credit;
import businesslogic.roombl.Room;
import businesslogicservice.orderblservice.*;
import dataservice.datafactory.DatafactoryImpl;
import po.ClientPO;
import po.HotelPO;
import po.OrderPO;
import po.PromotionPO;
import po.RoomPO;
public class Order {
	

	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有已执行订单
	 */
	public ArrayList<OrderVO> getExecutedOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "已执行订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有未执行订单
	 */
	public ArrayList<OrderVO> getUndoOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "未执行订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有已撤销订单
	 */
	public ArrayList<OrderVO> getReversedOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "已撤销订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	
	
	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有异常订单
	 */
	public ArrayList<OrderVO> getAbnormalOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "异常订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有订单
	 */
	public ArrayList<OrderVO> getAllOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "全部订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param order_id
	 * @return 返回该order信息
	 */
	public OrderVO getOrder(String order_id){
		OrderPO temp = new OrderPO();
		OrderVO result = new OrderVO();
		
		try {
			temp = DatafactoryImpl.getInstance().getOrderData().findOrder(order_id);
			result = POTOVO(temp);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return 所有异常订单
	 */
	public ArrayList<OrderVO> getAbnormalOrder(){
		
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getAllOrder();
			for(OrderPO lis : list){
				if(lis.getListType() == ListType.ABNORAMLIST){
					result.add(POTOVO(lis));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param order_id 订单编号
	 * @param executeTime 订单执行时间
	 * @return 订单执行结果
	 */
	public ResultMessage evecuteOrder(String order_id, String executeTime){
		ResultMessage result = ResultMessage.FAIL;
		String execute_time = executeTime;
		OrderPO po = new OrderPO();
		try {
			po = DatafactoryImpl.getInstance().getOrderData().findOrder(order_id);
			po.setExecuteTime(execute_time);
			po.setListType(ListType.HISTORYLIST);
			result = DatafactoryImpl.getInstance().getOrderData().modifyOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param client_id 客户编号
	 * @param order_id 订单编号
	 * @param undoTime 撤销订单时间
	 * @return 撤销订单结果
	 */
	public ResultMessage undoOrder(String client_id, String order_id, String undoTime){
		ResultMessage resultMessage = ResultMessage.FAIL;
		OrderPO po = new OrderPO();
		
		try {
			po = DatafactoryImpl.getInstance().getOrderData().findOrder(order_id);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		String pridictInTime = po.getPredictCheckInTime();
		String deadLine = getDeadline(pridictInTime);
		String time = getTime(pridictInTime);
		String undo_time = undoTime;
		Credit cr = new Credit();
		ResultMessage resultMessage2 = ResultMessage.FAIL;
		ResultMessage resultMessage3 = ResultMessage.FAIL;
		try {
			if(compareTime(undo_time, time)){
				po.setExecuteTime(undo_time);
				resultMessage2 = DatafactoryImpl.getInstance().getOrderData().modifyOrder(po);
				OrderPO temp = DatafactoryImpl.getInstance().getOrderData().findOrder(po.getOrder_id());
				resultMessage = DatafactoryImpl.getInstance().getOrderData().undoOrder(temp);
				if(resultMessage2 == ResultMessage.SUCCESS && resultMessage == ResultMessage.SUCCESS){
					return ResultMessage.SUCCESS;
				}
				//撤销订单,不扣除信用值
			}else if (compareTime(undo_time, deadLine)) {
				po.setExecuteTime(undo_time);
				resultMessage2 = DatafactoryImpl.getInstance().getOrderData().modifyOrder(po);
				OrderPO temp = DatafactoryImpl.getInstance().getOrderData().findOrder(po.getOrder_id());
				resultMessage = DatafactoryImpl.getInstance().getOrderData().undoOrder(temp);
				resultMessage3 = cr.deduct(client_id, po.getOrderPrice());
				if(resultMessage2 == ResultMessage.SUCCESS && resultMessage == ResultMessage.SUCCESS && resultMessage3 == ResultMessage.SUCCESS){
					return ResultMessage.SUCCESS;
				}
				//扣除信用值
			}else{
				return ResultMessage.FAIL;
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ResultMessage.FAIL;
		
		
		
	}
	
	//调用了roomdata、promotiondata、hoteldata、room
	/**
	 * 
	 * @param vo 订单信息
	 * @return 生成订单结果
	 */
	public ResultMessage addOrder(OrderVO vo){
		ResultMessage result = ResultMessage.FAIL;
		String predictCheckInTime = vo.getPredictCheckInTime();
		String order_id = getOrder_id();
		String deadLine = getDeadline(predictCheckInTime);
		String endTime = "";
		String executeTime = "";
		String hotel_id = vo.getHotel_id();
		String room_type = vo.getRoomType();
		int order_price = 0;
		int room_price = 0;
		ArrayList<RoomPO> list = new ArrayList<>();
		double count = 0;
		String hotel_name = "";
		ArrayList<HotelPO> list1 = new ArrayList<>();
		ResultMessage result2 = ResultMessage.FAIL;
		Room room = new Room();
		
		try {
			list1 = DatafactoryImpl.getInstance().getHotelData().getAllHotels();
			hotel_name = getHotel_name(list1, hotel_id);
			list = DatafactoryImpl.getInstance().getRoomData().findRoom(hotel_id, room_type);
			count = DatafactoryImpl.getInstance().getPromotionData().findPromotion(hotel_name).getCount();
			room_price = list.get(0).getRoom_price();
			result2 = room.reserve(room_type, vo.getNumber(), hotel_id, predictCheckInTime, vo.getPredictCheckOutTime());
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		order_price = (int)(vo.getNumber() * room_price * count);
		OrderPO po = new OrderPO(vo.getUser_id(), order_id, vo.getHotel_id(), vo.getStartTime(), endTime, deadLine, executeTime, vo.getPredictCheckInTime(), vo.getPredictCheckOutTime(), vo.getRoomType(), vo.getNumber(), vo.getPeople(), vo.isHasChild(), vo.getListType(), order_price);
		
		try {
			result = DatafactoryImpl.getInstance().getOrderData().addOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		if(result == ResultMessage.SUCCESS && result2 == ResultMessage.SUCCESS){
			return result;
		}
		
		return ResultMessage.FAIL;
		
	}
	
	/**
	 * 
	 * @param client_id
	 * @return 返回该客户的所有订单
	 */
	public ArrayList<OrderVO> viewAllOrderByClient(String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "全部订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param client_id
	 * @return 该客户的所有已执行订单
	 */
	public ArrayList<OrderVO> viewExecutedOrderByClient(String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "已执行订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param client_id
	 * @return 返回该客户所有未执行的订单
	 */
	public ArrayList<OrderVO> viewUndoOrderByClient(String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "未执行订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param client_id
	 * @return 该客户的所有已撤销订单
	 */
	public ArrayList<OrderVO> viewReversedOrderByClient(String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "已撤销订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param client_id
	 * @return 该客户的所有异常订单
	 */
	public ArrayList<OrderVO> viewAbnormalOrderByClient(String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "异常订单");
			for(OrderPO lis : list){
				result.add(POTOVO(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param a
	 * @param hotel_id 酒店id
	 * @return 得到对应的酒店名称
	 */
	public String getHotel_name(ArrayList<HotelPO> a, String hotel_id){
		String result = "";
		for(HotelPO list : a){
			if(list.getHotelId().equals(hotel_id)){
				result = list.getHotelName();
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param predictCheckInTime 预计入住时间
	 * @return 最晚执行时间
	 */
	public String getDeadline(String predictCheckInTime){
		String result = "";
		result = predictCheckInTime + "-23-59-59";
		return result;
	}
	
	/**
	 * 
	 * @param predictCheckInTime
	 * @return 距离订单最晚执行时间六个小时
	 */
	public String getTime(String predictCheckInTime){
		String result = "";
		result = predictCheckInTime + "-18-00-00";
		return result;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return time1 <= time2返回true,否则返回false
	 */
	public boolean compareTime(String time1, String time2){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1 = sim.parse(time1);
			date2 = sim.parse(time2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar aCalendar = Calendar.getInstance();
		Calendar bCalendar = Calendar.getInstance();
		aCalendar.setTime(date1);
		bCalendar.setTime(date2);
		int temp = aCalendar.compareTo(bCalendar);
		if(temp <= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return 订单编号
	 */
	public String getOrder_id(){
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getAllOrder();
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		ArrayList<String> temp = new ArrayList<>();
		for(OrderPO lis : list){
			temp.add(lis.getOrder_id());
		}
		String result = "";
		int a = 0;
		a = (int)(Math.random() * 10000000);
		if(list.isEmpty()){
			return result + a;
		}
		while(contain(temp, a)){
			a = (int)(Math.random() * 10000000);
		}
		
		return result + a;
	}
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return a包含b返回true，否则返回false
	 */
	public boolean contain(ArrayList<String> a, int b){
		for(int i = 0; i < a.size(); i++){
			if(Integer.parseInt(a.get(i)) == b){
				return true;
			}
		}
		
		return false;
	}
	
	public OrderVO POTOVO(OrderPO po){
		OrderVO result = new OrderVO(po.getUser_id(), po.getOrder_id(),po.getHotel_id(), po.getStartTime(), po.getEndTime(), po.getDeadline(), po.getExecuteTime(), po.getPredictCheckInTime(), po.getPredictCheckOutTime(), po.getRoomType(), po.getNumber(), po.getPeople(), po.isHasChild(), po.getListType(), po.getOrderPrice());
		return result;
	}
	
	
}