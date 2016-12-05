package vo;


import java.io.Serializable;

public class WorkerVO implements Serializable{

	//id
		private String userId;
		
		//姓名
		private String userName;
		//密码
		private String password;
		
		//联系方式
		private String contact;
		
		public WorkerVO(){
			
		}
		
		public WorkerVO(String userId,String userName,
				String password,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			
			this.contact=contact;
			
		}
}
