package businesslogic.promotionbl;

import po.PromotionPO;
import util.ResultMessage;
import vo.PromotionVO;

public class MockPromotion extends Promotion{

	String promotionName;
	String promotionObject;
	double count;
	String time;
	

	public MockPromotion(){
		
	}
	
	public MockPromotion(String name, String object, double count, String time){
		this.promotionName = name;
		this.promotionObject = object;
		this.count = count;
		this.time = time;
	}
	
	public String getName(){
		return promotionName;
	}
	
	public String getObject(){
		return promotionObject;
	}
	
	public double getCount(){
		return count;
	}
	
	public String getTime(){
		return time;
	}
	
	public PromotionVO getPromotion(String name){
		System.out.println("getPromotion success");
		return null;
	}
	public PromotionVO[] getAllPromotion(){
		System.out.println("getAllPromotion success");
		return null;
	}
	
	public ResultMessage addPromotion(PromotionVO vo){
		System.out.println("addPromotion success");
		return null;
	}
	
	public ResultMessage modifyPromotion(PromotionVO vo){
		System.out.println("modifyPromotion success");
		return null;
	}
	public ResultMessage delPromotion(PromotionVO vo){
		System.out.println("delPromotion success");
		return null;
	}

}
