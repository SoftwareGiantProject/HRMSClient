package vo;

public class OrderVO {
	String user_id;
	String order_id;
	String startTime;
	String endTime;
	String deadline;
	String executeTime;
	int people;
	boolean hasChild;
	
	
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
