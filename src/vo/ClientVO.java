package vo;

import java.io.Serializable;

public class ClientVO implements Serializable {

	//�û����
		private String userId;
		
		//�û���
		private String userName;
		//����
		private String password;
		//����ֵ
		private int credit;
		//��ϵ��ʽ
		private String contact;
		
		//����
		private String birthday;
		
		public ClientVO(){
			
		}
		
		public ClientVO(String userId,String userName,
				String password,int credit,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			this.credit=credit;
			this.contact=contact;
			
		}
		
		public ClientVO getClientVO(){
			return this;
		}
}
