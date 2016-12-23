package businesslogic.orderbl;
import util.ListType;
import util.MemberType;
import util.ResultMessage;
import util.RoomCondition;
import vo.CreditVO;
import vo.ListVO;
import vo.MemberPromotionVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomConditionDateVO;
import vo.RoomVO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.creditbl.Credit;
import businesslogic.creditbl.CreditController;
import businesslogic.hotelbl.HotelController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.roombl.Room;
import businesslogic.roombl.RoomController;
import businesslogic.userbl.client.ClientController;
import businesslogicservice.orderblservice.*;
import dataservice.datafactory.DatafactoryImpl;
import javafx.beans.property.SimpleStringProperty;
import po.ClientPO;
import po.HotelPO;
import po.OrderPO;
import po.PromotionPO;
import po.RoomPO;
public class Order {
	
	
	private HotelController hotelController;
	private CreditController creditController;
	private PromotionController promotionController;
	private ClientController clientController;
	private RoomController roomController;
	
	public Order() throws RemoteException{
		hotelController = (HotelController) ControllerFactory.getHotelBLServiceInstance();
		creditController = (CreditController) ControllerFactory.getCreditBLServiceInstance();
		promotionController = (PromotionController) ControllerFactory.getPromotionBLServiceInstance();
	    clientController = (ClientController) ControllerFactory.getClientBLSerivceInstance();
	    roomController = (RoomController) ControllerFactory.getRoomBLServiceInstance();
	}
	
	

	/**
	 * 撤销异常订单
	 * @param order_id
	 * @param All  若恢复全部信用值则为True，一半信用值则为false
	 * @param time
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage cancelAbnormalOrder(String order_id, Boolean All, String time) throws RemoteException{
		OrderVO vo = getOrder(order_id);
		ResultMessage resultMessage = ResultMessage.FAIL;
		vo.setExecuteTime(new SimpleStringProperty(time));
		vo.setListType(ListType.UNDOLIST);
		resultMessage = modifyOrder(vo);

		if(All){
			creditController.addCredit(vo.getUser_id().get(), vo.getOrderPrice().get());
		}else {
			creditController.addCredit(vo.getUser_id().get(), vo.getOrderPrice().get()/2);
		}
		return resultMessage;
	}

	/**
	 * 修改订单信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyOrder(OrderVO vo){

		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getOrderData().modifyOrder(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;

	}

	
	/**
	 * 返回该客户在该酒店的所有已执行订单
	 * @param hotel_id
	 * @param client_id
	 * @return
	 */
	public ArrayList<OrderVO> getExecutedOrderByHotelClient(String hotel_id, String client_id){
		ArrayList<OrderVO> result = new ArrayList<>();
		ArrayList<OrderVO> list1 = getExecutedOrders(hotel_id);
		ArrayList<OrderVO> list2 = viewExecutedOrderByClient(client_id);
		result = getSameOrder(list1, list2);
		
		return result;
		
		
	}
	
	/**
	 * 得到两个OrderVOlist里面相同的OrderVO
	 * @param a
	 * @param b
	 * @return
	 */
	private ArrayList<OrderVO> getSameOrder(ArrayList<OrderVO> a, ArrayList<OrderVO> b){
		ArrayList<OrderVO> result = new ArrayList<>();
		
 		for(int i = 0; i < a.size(); i++){
 			for(int j = 0; j < b.size(); j++){
// 				System.out.println(a.size());
// 				System.out.println(b.size());
 				if(a.get(i).getOrder_id().get().equals(b.get(j).getOrder_id().get())){
 					result.add(a.get(i));
 				}
 			}
 		}
 		return result;
	}

	/**
	 * 
	 * @param hotel_id
	 * @return 返回该酒店的所有已执行订单
	 */
	public ArrayList<OrderVO> getExecutedOrders(String hotel_id){
		ArrayList<OrderPO> list = new ArrayList<>();
		ArrayList<OrderVO> result = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "HISTORYLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "CURRENTLIST");
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
	 * 记录退房时间
	 * @param order_id
	 * @param endtime
	 * @return
	 */
	public ResultMessage recordCheckoutTime(String order_id, String endtime){
		OrderVO vo = getOrder(order_id);
		vo.setEndTime(new SimpleStringProperty(endtime));
		ResultMessage resultMessage = modifyOrder(vo);
		
		return resultMessage;
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
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "UNDOLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().getOrderByHotel(hotel_id, "ABNORAMLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().getALLOrderByHotel(hotel_id);
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
				if(lis.getListType().equals(ListType.ABNORMALLIST)){
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
			creditController.addCredit(po.getUser_id(), po.getOrderPrice());   //增加客户等同于订单金额的信用值
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
		ResultMessage resultMessage2 = ResultMessage.FAIL;
		ResultMessage resultMessage3 = ResultMessage.FAIL;
		ArrayList<RoomConditionDateVO> roomCon = roomController.getRoomConditionByOrder(order_id);
		try {
			if(compareTime(undo_time, time)){
				po.setExecuteTime(undo_time);
				resultMessage2 = DatafactoryImpl.getInstance().getOrderData().modifyOrder(po);
				OrderPO temp = DatafactoryImpl.getInstance().getOrderData().findOrder(po.getOrder_id());
				resultMessage = DatafactoryImpl.getInstance().getOrderData().undoOrder(temp);
				//修改房间状态
				for(RoomConditionDateVO lis : roomCon){
					lis.setRoomcondition(RoomCondition.UNRESERVED);
					lis.setOrder_id(" ");
					roomController.modifyCondition(lis);
				}
				if(resultMessage2 == ResultMessage.SUCCESS && resultMessage == ResultMessage.SUCCESS){
					return ResultMessage.SUCCESS;
				}
				//撤销订单,不扣除信用值
			}else if (compareTime(undo_time, deadLine)) {
				po.setExecuteTime(undo_time);
				resultMessage2 = DatafactoryImpl.getInstance().getOrderData().modifyOrder(po);
				OrderPO temp = DatafactoryImpl.getInstance().getOrderData().findOrder(po.getOrder_id());
				resultMessage = DatafactoryImpl.getInstance().getOrderData().undoOrder(temp);
				resultMessage3 = creditController.deduct(client_id, po.getOrderPrice());
				//修改房间状态
				for(RoomConditionDateVO lis : roomCon){
					lis.setRoomcondition(RoomCondition.UNRESERVED);
					lis.setOrder_id(" ");
					roomController.modifyCondition(lis);
				}
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
	 * @throws RemoteException 
	 */
	public ResultMessage addOrder(OrderVO vo) throws RemoteException{
		ResultMessage result = ResultMessage.FAIL;
		String predictCheckInTime = vo.getPredictCheckInTime().get();
		String order_id = getOrder_id();  //系统生成订单编号
		String deadLine = getDeadline(predictCheckInTime); //最晚订单执行时间
		String endTime = "";
		String executeTime = "";
		String hotel_id = vo.getHotel_id().get();
		String room_type = vo.getRoomType().get();
		String user_id = vo.getUser_id().get();
		
		//根据信用值判断能否下订单
		ClientPO client = DatafactoryImpl.getInstance().getClientData().findClient(user_id);
		int credit = client.getCredit();
		if(credit < 0){
			return ResultMessage.LOWCREDIT;
		}
		
		int order_price = 0;
		int room_price = 0;
		double count = calculateCheapestCount(vo);  //折扣
		
		ResultMessage result2 = ResultMessage.FAIL;
		
		room_price = roomController.findRooms(hotel_id, room_type).get(0).getRoomPrice().get();
		result2 = roomController.reserve(room_type, vo.getNumber().get(), hotel_id, predictCheckInTime, vo.getPredictCheckOutTime().get(), order_id);
		order_price = (int)(vo.getNumber().get() * room_price * count)/10;
		OrderPO po = new OrderPO(vo.getUser_id().get(), order_id, vo.getHotel_id().get(), vo.getStartTime().get(), endTime, deadLine, executeTime, vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(), vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), vo.getListType(), order_price);
		
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
	
	//调用client、hotel
	/**
	 * 计算最小折扣
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	private double calculateCheapestCount(OrderVO vo) throws RemoteException{
		String client_id = vo.getUser_id().get();
		String hotel_id = vo.getHotel_id().get();
		String predictCheckInTime = vo.getPredictCheckInTime().get();
		String predictCheckOutTime = vo.getPredictCheckOutTime().get();
		String hotel_name = hotelController.getNmaeById(hotel_id);
		String area = hotelController.viewHotel(hotel_name).getHotelArea().get();
		
		ArrayList<PromotionVO> result = new ArrayList<>();
		ArrayList<PromotionVO> list = promotionController.getAllPromotion();
		MemberPromotionVO memberPromotionVO = promotionController.getMemberPromotion("会员特定商圈专属折扣");
		
		double count = 10;
		for(PromotionVO lis : list){
			if(JudgeIsRight(lis, hotel_id, predictCheckInTime, predictCheckOutTime, client_id)){
				result.add(lis);
			}
		}
		count = getCheapestCountByPromontion(result);
		
		double memberCount = 10;
		if(JudgeIsMemberRight(memberPromotionVO, area, predictCheckInTime, predictCheckOutTime, client_id)){
			memberCount = memberPromotionVO.getCount();
		}
		
		if(count < memberCount){
			return count;
		}else{
			return memberCount;
		}
		
	}
	
	/**
	 * 判断是否符合MemberPromotion的条件，符合返回true，否则返回false
	 * @param vo
	 * @param area
	 * @param time1
	 * @param time2
	 * @param client_id
	 * @return
	 * @throws RemoteException
	 */
	private boolean JudgeIsMemberRight(MemberPromotionVO vo, String area, String time1, String time2, String client_id) throws RemoteException{
		String areaList[] = vo.getArea().split("，");
		String startTime = vo.getTime().split(" ")[0];
		String endTime = vo.getTime().split(" ")[2];
		
		
		if(!(clientController.getClientInfo(client_id).getType().equals(MemberType.NONE))){
			if(compareTime(startTime, time1) && compareTime(time2, endTime)){
				for(int i = 0; i < areaList.length; i++){
					if(areaList[i].equals(area)){
						return true;
					}
				}
			}
		}
		
		return false;
		
	}
	
	/**
	 * 判断是否符合Promotion的条件，符合返回true，否则返回false
	 * @param vo
	 * @param hotel_id
	 * @param time1
	 * @param time2
	 * @param client_id
	 * @return
	 * @throws RemoteException
	 */
	private boolean JudgeIsRight(PromotionVO vo, String hotel_id, String time1, String time2, String client_id) throws RemoteException{
		String object = vo.getPromoitonObject().get();
		String startTime = vo.getTime().get().split(" ")[0];
		String endTime = vo.getTime().get().split(" ")[2];
		String seller = vo.getSeller().get();
		String client = "";
		//判断该客户是否是会员
		if(!(clientController.getClientInfo(client_id).getType().equals(MemberType.NONE))){
			client = "MEMBER";
		}
		
		if(seller.equals("web") || seller.equals(hotel_id)){
			if(compareTime(startTime, time1) && compareTime(time2, endTime)){
				if(object.equals("ALL") || object.equals(client)){
					return true;
				}
			}
		}
		return false;
		
	}
	
	/**
	 * 从PromotionList中得到最小的折扣
	 * @param list
	 * @return
	 */
	private double getCheapestCountByPromontion(ArrayList<PromotionVO> list){
		if(list.isEmpty()){
			return 10;
		}
		double temp = list.get(0).getCount().get();
		
		for(int i = 1; i < list.size(); i++){
			if(temp > list.get(i).getCount().get()){
				temp = list.get(i).getCount().get();
			}
		}
		
		return temp;
		
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
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "ALLLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "HISTORYLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "CURRENTLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "UNDOLIST");
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
			list = DatafactoryImpl.getInstance().getOrderData().findList(client_id, "ABNORMALLIST");
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
	 * @param predictCheckInTime 预计入住时间
	 * @return 最晚执行时间
	 */
	private String getDeadline(String predictCheckInTime){
		String result = "";
		result = predictCheckInTime + "-23-59-59";
		return result;
	}
	
	/**
	 * 
	 * @param predictCheckInTime
	 * @return 距离订单最晚执行时间六个小时
	 */
	private String getTime(String predictCheckInTime){
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
	private boolean compareTime(String time1, String time2){
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
	private String getOrder_id(){
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
			return String.valueOf(a);
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
	private boolean contain(ArrayList<String> a, int b){
		for(int i = 0; i < a.size(); i++){
			if(a.get(i).equals(String.valueOf(b))){
				return true;
			}
		}
		
		return false;
	}
	
	private OrderVO POTOVO(OrderPO po){
		OrderVO result = new OrderVO(po.getUser_id(), po.getOrder_id(),po.getHotel_id(), po.getStartTime(), po.getEndTime(), po.getDeadline(), po.getExecuteTime(), po.getPredictCheckInTime(), po.getPredictCheckOutTime(), po.getRoomType(), po.getNumber(), po.getPeople(), po.isHasChild(), po.getListType(), po.getOrderPrice());
		return result;
	}
	
	
	private OrderPO VOTOPO(OrderVO vo){
		OrderPO result = new OrderPO(vo.getUser_id().get(), vo.getOrder_id().get(),vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(), vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), vo.getListType(), vo.getOrderPrice().get());
	    return result;
	}
	
	/**
	 * 判断订单是否已过deadline，并更新订单信息
	 */
	public void update() {
		Date dt=new Date();
	    SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	    String now = matter1.format(dt);
	    ArrayList<OrderPO> result = new ArrayList<>();
		try {
			ArrayList<OrderPO> list = DatafactoryImpl.getInstance().getOrderData().getAllOrder();
			for(OrderPO lis : list){
				if(lis.getListType().equals(ListType.CURRENTLIST)){
					result.add(lis);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String deadline = "";
		try {
			for(OrderPO order : result){
				deadline = getDeadline(order.getPredictCheckInTime());
				if(compareTime(deadline, now)){
					order.setListType(ListType.ABNORMALLIST);
					DatafactoryImpl.getInstance().getOrderData().modifyOrder(order);
					creditController.deduct(order.getUser_id(), order.getOrderPrice()*2);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	
	
}