package vo;

public class PromotionVO {
	String promotionName;
	String promotionObject;
	double count;
	String time;
	
	public PromotionVO(){
		
	}
	
	public PromotionVO(String promotionName,String promotionObject,double count,String time){
		this.promotionName=promotionName;
		this.promotionObject=promotionObject;
		this.count=count;
		this.time=time;
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
