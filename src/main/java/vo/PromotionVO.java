package vo;

public class PromotionVO {
	String promotionName;
	String promotionObject;
	double count;
	String time;
	String seller;
	
	public PromotionVO(){
		
	}
	
	public PromotionVO(String promotionName,String promotionObject,double count,String time,String seller){
		this.promotionName=promotionName;
		this.promotionObject=promotionObject;
		this.count=count;
		this.time=time;
		this.seller = seller;
	}
	
	public String getSeller(){
		return seller;
	}
	
	public String getPromotionName(){
		return promotionName;
	}
	
	public String getPromoitonObject(){
		return promotionObject;
	}
	
	public double getCount(){
		return count;
	}
	
	public String getTime(){
		return time;
	}
	
	public PromotionVO getPromotionVO(){
		return this;
	}
	public PromotionVO[] getPromotionVOList(){
		return new PromotionVO().getPromotionVOList();
	}

}
