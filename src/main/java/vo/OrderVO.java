package vo;

import util.ListType;

public class OrderVO {
	String user_id;
	String order_id;
	String startTime;
	String endTime;
	String deadline;
	String executeTime;
	int people;
	boolean hasChild;
	ListType listType;
	
	
	public String getUser_id() {
		return user_id;
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
	public OrderVO(String user_id,String order_id,String startTime,String endTime,String deadline,String executeTime,int people,boolean hasChild){
		this.user_id=user_id;
		this.order_id=order_id;
		this.deadline=deadline;
		this.endTime=endTime;
		this.executeTime=executeTime;
		this.hasChild=hasChild;
		this.people=people;
		this.startTime=startTime;
	}
	public OrderVO(OrderVO order,String type){
		
	}
	public OrderVO(String order_id){
		
	}

}
