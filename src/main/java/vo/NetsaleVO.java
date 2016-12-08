package vo;

import java.io.Serializable;

public class NetsaleVO implements Serializable {

		//id
		private String userId;
		
		//用户名
		private String userName;
		//密码
		private String password;
		
		//联系方式
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

		public String getUserId() {
			return userId;
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}

		public String getContact() {
			return contact;
		}
		

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

}

