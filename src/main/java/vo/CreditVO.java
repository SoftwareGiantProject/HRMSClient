package vo;

import java.io.Serializable;

public class CreditVO implements Serializable{

	String userId;
	int credit;
	String time;
	int change;
	
public CreditVO() {
	// TODO Auto-generated constructor stub
}

public CreditVO(String userId,int credit,String time,int change){
	super();
	this.userId=userId;
	this.time = time;
	this.change = change;
	this.credit=credit;
	
}

public String getUserId() {
	return userId;
}

public int getCredit() {
	return credit;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public void setCredit(int credit) {
	this.credit = credit;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public int getChange() {
	return change;
}

public void setChange(int change) {
	this.change = change;
}



}
