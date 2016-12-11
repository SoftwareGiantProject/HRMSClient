package vo;

import util.ListType;

public class OrderVO {
	//客户编号
	private String user_id;//

	//订单编号
	private String order_id;

	//酒店编号
	private String hotel_id;//

	//下订单的时间
	private String startTime;//

	//退房时间
	private String endTime;

	//最晚执行时间
	private String deadline;

	//订单执行时间(当撤销订单时，成为撤销订单时间)
	private String executeTime;

	//预计入住时间
	private String predictCheckInTime;//

	//预计离开时间
	private String predictCheckOutTime;//

	//房间类型
	private String roomType;//

	//房间数量
	private int number;//

	//人员数量
	private int people;//

	//是否有儿童
	private boolean hasChild;//

	//订单类型
	private ListType listType;//

    //订单金额
	private int orderPrice;//

	//各种可能用到的构造函数

	public OrderVO(){
		
	}
	
	public OrderVO(String user_id, String hotel_id, String startTime, String predictCheckInTime, String predictCheckOutTime, String roomType, int number, int people, boolean hasChild, ListType listType){
		this.user_id=user_id;
		this.hotel_id=hotel_id;
		this.startTime=startTime;
		this.predictCheckInTime = predictCheckInTime;
		this.predictCheckOutTime = predictCheckOutTime;
		this.roomType = roomType;
		this.number = number;
		this.hasChild=hasChild;
		this.people=people;
		this.listType = listType;
	
		
	}

	public OrderVO(String user_id,String order_id,String hotel_id,String startTime,String endTime,String deadline,String executeTime,String predictCheckInTime,String predictCheckOutTime,String roomType, int number, int people,boolean hasChild,ListType listType, int orderPrice){

		this.user_id=user_id;
		this.order_id=order_id;
		this.hotel_id=hotel_id;
		this.startTime=startTime;
		this.endTime=endTime;
		this.deadline=deadline;
		this.executeTime=executeTime;
		this.predictCheckInTime = predictCheckInTime;
		this.predictCheckOutTime = predictCheckOutTime;
		this.roomType = roomType;
		this.number = number;
		this.hasChild=hasChild;
		this.people=people;
		this.listType = listType;
		this.orderPrice = orderPrice;

	}

	public int getOrderPrice(){
		return orderPrice;
	}
	
	public String getRoomType() {

		return roomType;

	}

	public int getNumber() {

		return number;

	}

	public String getPredictCheckInTime() {

		return predictCheckInTime;

	}

	public String getPredictCheckOutTime() {

		return predictCheckOutTime;

	}

	public String getUser_id() {

		return user_id;

	}

	public String getHotel_id() {

		return hotel_id;

	}

	public String getOrder_id() {

		return order_id;

	}
	
	public String getStartTime() {

		return startTime;

	}

	public String getEndTime() {

		return endTime;

	}

	public String getDeadline() {

		return deadline;

	}

	public String getExecuteTime() {

		return executeTime;

	}

	public int getPeople() {

		return people;

	}

	public boolean isHasChild() {

		return hasChild;

	}

	public ListType getListType() {

		return listType;

	}

}
