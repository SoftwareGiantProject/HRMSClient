package vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class PromotionVO {
	SimpleStringProperty promotionName=new SimpleStringProperty();
	SimpleStringProperty promotionObject=new SimpleStringProperty();
	SimpleDoubleProperty count=new SimpleDoubleProperty();
	SimpleStringProperty time=new SimpleStringProperty();
	SimpleStringProperty seller=new SimpleStringProperty();
	
	public PromotionVO(){
		
	}
	
	public PromotionVO(String promotionName,String promotionObject,double count,String time,String seller){
		this.promotionName=new SimpleStringProperty(promotionName);
		this.promotionObject=new SimpleStringProperty(promotionObject);
		this.count=new SimpleDoubleProperty(count);
		this.time=new SimpleStringProperty(time);
		this.seller = new SimpleStringProperty(seller);
	}
	
	public SimpleStringProperty getSeller(){
		return seller;
	}
	
	public SimpleStringProperty getPromotionName(){
		return promotionName;
	}
	
	public SimpleStringProperty getPromoitonObject(){
		return promotionObject;
	}
	
	public SimpleDoubleProperty getCount(){
		return count;
	}
	
	public SimpleStringProperty getTime(){
		return time;
	}
	
	public PromotionVO getPromotionVO(){
		return this;
	}
	public PromotionVO[] getPromotionVOList(){
		return new PromotionVO().getPromotionVOList();
	}

}
