package vo;


import java.io.Serializable;

public class NetworkerVO implements Serializable{

	//用户编号
		private String userId;
		
		//用户名
		private String userName;
		//密码
		private String password;
		
		//联系方式
		private String contact;
		
		public NetworkerVO(){
			
		}
		
		public NetworkerVO(String userId,String userName,
				String password,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			
			this.contact=contact;
			
		}
}
