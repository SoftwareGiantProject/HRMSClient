package vo;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CreditVO implements Serializable{

	SimpleStringProperty userId;
	SimpleIntegerProperty credit;
	SimpleStringProperty time;
	SimpleIntegerProperty change;
	
public CreditVO() {
	// TODO Auto-generated constructor stub
}

public CreditVO(String userId,int credit,String time,int change){
	super();
	this.userId=new SimpleStringProperty(userId);
	this.time =new SimpleStringProperty(time) ;
	this.change =new SimpleIntegerProperty(change);
	this.credit=new SimpleIntegerProperty(credit);
	
}

public SimpleStringProperty getUserId() {
	return userId;
}

public SimpleIntegerProperty getCredit() {
	return credit;
}

public void setUserId(String userId) {
	this.userId = new SimpleStringProperty(userId);
}

public void setCredit(int credit) {
	this.credit =new SimpleIntegerProperty(credit);
}

public SimpleStringProperty getTime() {
	return time;
}

public void setTime(String time) {
	this.time =new SimpleStringProperty(time);
}

public SimpleIntegerProperty getChange() {
	return change;
}

public void setChange(int change) {
	this.change = new SimpleIntegerProperty(change);
}



}
