package vo;

import java.io.Serializable;

import util.MemberType;

public class ClientVO implements Serializable {

		private String userId;
		private String memberId;
		private String userName;
		private String password;
		private int credit;
		private String contact;
		private String birthday;
		private MemberType type;
		
		public ClientVO(){
			
		}
		
		public ClientVO(String userId,String memberId,String userName,
				String password,int credit,String birthday,String contact,MemberType type){
			super();
			this.userId=userId;
			this.memberId = memberId;
			this.userName=userName;
			this.password=password;
			this.credit=credit;
			this.contact=contact;
			this.birthday = birthday;
			this.type = type;
		}
		
		public String getUserId() {
			return userId;
		}

		public String getMemberId() {
			return memberId;
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}

		public int getCredit() {
			return credit;
		}

		public String getContact() {
			return contact;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setCredit(int credit) {
			this.credit = credit;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
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
