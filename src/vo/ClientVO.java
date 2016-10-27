package vo;

import java.io.Serializable;

public class ClientVO implements Serializable {

	//用户编号
		private String userId;
		
		//用户名
		private String userName;
		//密码
		private String password;
		//信用值
		private int credit;
		//联系方式
		private String contact;
		
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
