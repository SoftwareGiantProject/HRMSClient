package vo;

import java.util.Date;

public class HotelEvaluationVO {

	   //订单id
		String order_id;
		
		//用户id
		String user_id;
		
		//评价日期
		String date;
		
		//评价内容
		String data;
		
		//评级
		int level;
		
		public HotelEvaluationVO(){
			
		}
		
		
		public HotelEvaluationVO(String order_id, String user_id, String date, String data, int level){
			this.order_id = order_id;
			this.user_id = user_id;
			this.date = date;
			this.data = data;
			this.level = level;
		}


		public String getOrder_id() {
			return order_id;
		}


		public String getUser_id() {
			return user_id;
		}


		public String getDate() {
			return date;
		}


		public String getData() {
			return data;
		}


		public int getLevel() {
			return level;
		}
		
}
