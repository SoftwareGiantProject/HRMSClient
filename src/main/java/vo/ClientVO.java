package vo;

import java.io.Serializable;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import util.MemberType;

public class ClientVO implements Serializable {

		private SimpleStringProperty userId=new SimpleStringProperty();
		private SimpleStringProperty memberId=new SimpleStringProperty();
		private SimpleStringProperty userName=new SimpleStringProperty();
		private SimpleStringProperty password=new SimpleStringProperty();
		private SimpleIntegerProperty credit=new SimpleIntegerProperty();
		private SimpleStringProperty contact=new SimpleStringProperty();
		private SimpleStringProperty birthday=new SimpleStringProperty();
		private MemberType type;
		
		public ClientVO(){
			
		}
		
		public ClientVO(String userId,String memberId,String userName,
				String password,int credit,String birthday,String contact,MemberType type){
			super();
			this.userId=new SimpleStringProperty(userId);
			this.memberId = new SimpleStringProperty(memberId);
			this.userName=new SimpleStringProperty(userName);
			this.password=new SimpleStringProperty(password);
			this.credit=new SimpleIntegerProperty(credit);
			this.contact=new SimpleStringProperty(contact);
			this.birthday =new SimpleStringProperty( birthday);
			this.type = type;
		}
		
		public SimpleStringProperty getUserId() {
			return userId;
		}

		public SimpleStringProperty getMemberId() {
			return memberId;
		}

		public SimpleStringProperty getUserName() {
			return userName;
		}

		public SimpleStringProperty getPassword() {
			return password;
		}

		public SimpleIntegerProperty getCredit() {
			return credit;
		}

		public SimpleStringProperty getContact() {
			return contact;
		}

		public SimpleStringProperty getBirthday() {
			return birthday;
		}

		public void setUserId(String userId) {
			this.userId =new SimpleStringProperty(userId);
		}

		public void setMemberId(String memberId) {
			this.memberId = new SimpleStringProperty(memberId);
		}

		public void setUserName(String userName) {
			this.userName =new SimpleStringProperty( userName);
		}

		public void setPassword(String password) {
			this.password = new SimpleStringProperty(password);
		}

		public void setCredit(int credit) {
			this.credit =new SimpleIntegerProperty( credit);
		}

		public void setContact(String contact) {
			this.contact = new SimpleStringProperty(contact);
		}

		public void setBirthday(String birthday) {
			this.birthday =new SimpleStringProperty( birthday);
		}

		public void setType(MemberType type) {
			this.type = type;
		}

		public MemberType getType() {
			return type;
		}

		public ClientVO getClientVO(){
			return this;
		}
}
