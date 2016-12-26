package vo;


import java.io.Serializable;

import javax.lang.model.util.SimpleElementVisitor6;

import javafx.beans.property.SimpleStringProperty;

public class WorkerVO implements Serializable{

	//id
		private SimpleStringProperty userId;
		
		//酒店id
		private SimpleStringProperty hotel_id;
		//姓名
		private SimpleStringProperty userName;
		//密码
		private SimpleStringProperty password;
		
		//联系方式
		private SimpleStringProperty contact;
		
		public WorkerVO(){
			
		}
		
		public WorkerVO(String userId,String userName,String hotelid,
				String password,String contact){
			super();
			this.userId=new SimpleStringProperty(userId);
			this.hotel_id=new SimpleStringProperty(hotelid);
			this.userName=new SimpleStringProperty(userName);
			this.password=new SimpleStringProperty(password);
			
			this.contact=new SimpleStringProperty(contact);
			
		}

		
		public SimpleStringProperty getHotel_id() {
			return hotel_id;
		}

		public void setHotel_id(String hotel_id) {
			this.hotel_id = new SimpleStringProperty(hotel_id);
		}

		public SimpleStringProperty getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = new SimpleStringProperty(userId);
		}

		public SimpleStringProperty getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName =new SimpleStringProperty(userName) ;
		}

		public SimpleStringProperty getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = new SimpleStringProperty(password);
		}

		public SimpleStringProperty getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = new SimpleStringProperty(contact);
		}
}
