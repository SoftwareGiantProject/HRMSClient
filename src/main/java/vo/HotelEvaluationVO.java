package vo;

import java.util.Date;

public class HotelEvaluationVO {

	//订单编号
		String order_id;
		
		//客户编号
		String user_id;
		
		//评价时间
		Date date;
		
		//评价内容
		String data;
		
		//评价星级
		int level;
		
		public HotelEvaluationVO(){
			
		}
		
		
		public HotelEvaluationVO(String order_id, String user_id, Date date, String data, int level){
			this.order_id = order_id;
			this.user_id = user_id;
			this.date = date;
			this.data = data;
			this.level = level;
		}
		
}
