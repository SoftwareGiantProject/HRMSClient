package vo;

import java.io.Serializable;

public class NetsaleVO implements Serializable {

	//�û����
		private String userId;
		
		//�û���
		private String userName;
		//����
		private String password;
		
		//��ϵ��ʽ
		private String contact;
		
		public NetsaleVO(){
			
		}
		
		public NetsaleVO(String userId,String userName,
				String password,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			
			this.contact=contact;
			
		}
}
