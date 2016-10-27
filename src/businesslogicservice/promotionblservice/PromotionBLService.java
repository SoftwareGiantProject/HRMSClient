package businesslogicservice.promotionblservice;

import vo.*;
import util.*;

public interface PromotionBLService {

	public PromotionVO getPromotion(String name);
	public PromotionVO[] getAllPromotion();
	
	public ResultMessage addPromotion(PromotionVO vo);
	public ResultMessage modifyPromotion(PromotionVO vo);
	public ResultMessage delPromotion(PromotionVO vo);
}
