package po;

import java.io.Serializable;
// sadfafadas

public class ClientPO implements Serializable{

	//�û����
		private String  userId;
		
		//�û���
		private String userName;
		//����
		private String password;
		//����ֵ
		private int credit;
		//��ϵ��ʽ
		private String contact;
		
		public ClientPO(){
			
		}
		
		public ClientPO(String userId,String userName,
				String password,int credit,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			this.credit=credit;
			this.contact=contact;
			
		}
		
		public String getPassword(){
			return password;
		}
		
		public void setPassword(String password){
			this.password=password;
		}
		
		
		
		public String getUserId(){
			return userId;
		}
		
		public void setUserId(String userId){
			this.userId=userId;
		}
		
		
		
		public String getUserName(){
			return userName;
		}
		
		public void setUserName(String userName){
			this.userName=userName;
		}
		
		public String getContact(){
			return contact;
		}
		
		public void setContact(String contact){
			this.userName=contact;
		}
		
		public int getCredit(){
			return credit;
		}
		
		public void setCredit(int credit){
			this.credit=credit;
		}
}
