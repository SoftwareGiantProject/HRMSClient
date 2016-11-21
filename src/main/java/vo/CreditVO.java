package vo;

import java.io.Serializable;

public class CreditVO implements Serializable{

	String userId;
	int credit;
	
public CreditVO() {
	// TODO Auto-generated constructor stub
}

public CreditVO(String userId,int credit){
	super();
	this.userId=userId;
	
	this.credit=credit;
	
}

public void setUserId(String userId) {
	this.userId = userId;
}

public void setCredit(int credit) {
	this.credit = credit;
}

}
