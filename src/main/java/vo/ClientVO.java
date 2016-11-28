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

		public MemberType getType() {
			return type;
		}

		public ClientVO getClientVO(){
			return this;
		}
}
