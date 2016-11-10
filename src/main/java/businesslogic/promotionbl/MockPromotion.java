package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PromotionPO;
import util.ResultMessage;
import vo.PromotionVO;

public class MockPromotion extends Promotion{

	private ArrayList<PromotionVO> promotionlist;
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
		return null;
	}
	public ArrayList<PromotionVO> getAllPromotion(){
		return null;
	}

	public ResultMessage addMemberPromotion(PromotionVO vo){
		return ResultMessage.SUCCESS;
	}
	public ResultMessage addPromotion(PromotionVO vo){
		return null;
	}
	
	public ResultMessage modifyPromotion(PromotionVO vo){
		return null;
	}
	public ResultMessage delPromotion(PromotionVO vo){
		return null;
	}

}
