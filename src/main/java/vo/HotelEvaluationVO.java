package vo;

import java.util.Date;

public class HotelEvaluationVO {

	//�������
		String order_id;
		
		//�ͻ����
		String user_id;
		
		//����ʱ��
		Date date;
		
		//��������
		String data;
		
		//�����Ǽ�
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
