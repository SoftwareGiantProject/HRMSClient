package businesslogicservice.promotionblservice;

import vo.*;

import java.util.ArrayList;

import util.*;

public interface PromotionBLService {

	public PromotionVO getPromotion(String name);
	public ArrayList<PromotionVO> getAllPromotion();
	
	public ResultMessage addMemberPromotion(PromotionVO vo);
	public ResultMessage addPromotion(PromotionVO vo);
	public ResultMessage modifyPromotion(PromotionVO vo);
	public ResultMessage delPromotion(PromotionVO vo);
}
