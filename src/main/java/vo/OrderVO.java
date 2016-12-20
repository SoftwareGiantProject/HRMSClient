package vo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import util.ListType;

public class OrderVO {
	//客户编号
	private SimpleStringProperty user_id;//

	//订单编号
	private SimpleStringProperty order_id;

	//酒店编号
	private SimpleStringProperty hotel_id;//

	//下订单的时间
	private SimpleStringProperty startTime;//

	//退房时间
	private SimpleStringProperty endTime;

	//最晚执行时间
	private SimpleStringProperty deadline;

	//订单执行时间(当撤销订单时，成为撤销订单时间)
	private SimpleStringProperty executeTime;

	//预计入住时间
	private SimpleStringProperty predictCheckInTime;//

	//预计离开时间
	private SimpleStringProperty predictCheckOutTime;//

	//房间类型
	private SimpleStringProperty roomType;//

	//房间数量
	private SimpleIntegerProperty number;//

	//人员数量
	private SimpleIntegerProperty people;//

	//是否有儿童
	private SimpleBooleanProperty hasChild;//

	//订单类型
	private ListType listType;//

    //订单金额
	private SimpleIntegerProperty orderPrice;//

	//各种可能用到的构造函数

	public OrderVO(){
		
	}
	
	public void setEndTime(SimpleStringProperty endTime) {
		this.endTime = endTime;
	}

	public OrderVO(String user_id, String hotel_id, String startTime, String predictCheckInTime, String predictCheckOutTime, String roomType, int number, int people, boolean hasChild, ListType listType){
		this.user_id=new SimpleStringProperty(user_id);
		this.hotel_id=new SimpleStringProperty(hotel_id);
		this.startTime=new SimpleStringProperty(startTime);
		this.predictCheckInTime = new SimpleStringProperty(predictCheckInTime);
		this.predictCheckOutTime = new SimpleStringProperty(predictCheckOutTime);
		this.roomType = new SimpleStringProperty(roomType);
		this.number = new SimpleIntegerProperty(number);
		this.hasChild=new SimpleBooleanProperty(hasChild);
		this.people=new SimpleIntegerProperty(people);
		this.listType = listType;
	
		
	}

	public OrderVO(String user_id,String order_id,String hotel_id,String startTime,String endTime,String deadline,String executeTime,String predictCheckInTime,String predictCheckOutTime,String roomType, int number, int people,boolean hasChild,ListType listType, int orderPrice){

		this.user_id=new SimpleStringProperty(user_id);
		this.hotel_id=new SimpleStringProperty(hotel_id);
		this.startTime=new SimpleStringProperty(startTime);
		this.predictCheckInTime = new SimpleStringProperty(predictCheckInTime);
		this.predictCheckOutTime = new SimpleStringProperty(predictCheckOutTime);
		this.roomType = new SimpleStringProperty(roomType);
		this.number = new SimpleIntegerProperty(number);
		this.hasChild=new SimpleBooleanProperty(hasChild);
		this.people=new SimpleIntegerProperty(people);
		this.listType = listType;
		
		
		
		
		this.order_id=new SimpleStringProperty(order_id);
		
		
		this.endTime=new SimpleStringProperty(endTime);
		this.deadline=new SimpleStringProperty(deadline);
		this.executeTime=new SimpleStringProperty(executeTime);
		
		
		
		
		
		
		
		this.orderPrice = new SimpleIntegerProperty(orderPrice);

	}

	public SimpleIntegerProperty getOrderPrice(){
		return orderPrice;
	}
	
	public SimpleStringProperty getRoomType() {

		return roomType;

	}

	public SimpleIntegerProperty getNumber() {

		return number;

	}

	public SimpleStringProperty getPredictCheckInTime() {

		return predictCheckInTime;

	}

	public SimpleStringProperty getPredictCheckOutTime() {

		return predictCheckOutTime;

	}

	public SimpleStringProperty getUser_id() {

		return user_id;

	}

	public SimpleStringProperty getHotel_id() {

		return hotel_id;

	}

	public SimpleStringProperty getOrder_id() {

		return order_id;

	}
	
	public SimpleStringProperty getStartTime() {

		return startTime;

	}

	public SimpleStringProperty getEndTime() {

		return endTime;

	}

	public SimpleStringProperty getDeadline() {

		return deadline;

	}

	public SimpleStringProperty getExecuteTime() {

		return executeTime;

	}

	public SimpleIntegerProperty getPeople() {

		return people;

	}

	public SimpleBooleanProperty isHasChild() {

		return hasChild;

	}

	public ListType getListType() {

		return listType;

	}

}
