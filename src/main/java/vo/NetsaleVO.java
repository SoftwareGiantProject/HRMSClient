package vo;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class NetsaleVO implements Serializable {

		//id
		private SimpleStringProperty userId;
		
		//用户名
		private SimpleStringProperty userName;
		//密码
		private SimpleStringProperty password;
		
		//联系方式
		private SimpleStringProperty contact;
		
		public NetsaleVO(){
			
		}

		public NetsaleVO(String userId,String userName,
				String password,String contact){
			super();
			this.userId=new SimpleStringProperty(userId);
			
			this.userName=new SimpleStringProperty(userName);
			this.password=new SimpleStringProperty(password);
			
			this.contact=new SimpleStringProperty(contact);
			
		}

		public SimpleStringProperty getUserId() {
			return userId;
		}

		public SimpleStringProperty getUserName() {
			return userName;
		}

		public SimpleStringProperty getPassword() {
			return password;
		}

		public SimpleStringProperty getContact() {
			return contact;
		}
		

		public void setUserId(String userId) {
			this.userId = new SimpleStringProperty(userId);
		}

		public void setUserName(String userName) {
			this.userName = new SimpleStringProperty(userName);
		}

		public void setPassword(String password) {
			this.password = new SimpleStringProperty(password);
		}

		public void setContact(String contact) {
			this.contact =new SimpleStringProperty(contact) ;
		}

}

