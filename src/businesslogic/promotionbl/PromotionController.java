package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.*;
import util.ResultMessage;
import vo.PromotionVO;


public class PromotionController implements PromotionBLService{

	MockPromotion promotion = new MockPromotion();
	
	@Override
	public PromotionVO getPromotion(String name) {
		return promotion.getPromotion(name);
	}

	@Override
	public PromotionVO[] getAllPromotion() {
		return promotion.getAllPromotion();
	}

	@Override
	public ResultMessage addPromotion(PromotionVO vo) {
		return promotion.addPromotion(vo);
	}

	@Override
	public ResultMessage modifyPromotion(PromotionVO vo) {
		return promotion.modifyPromotion(vo);
	}

	@Override
	public ResultMessage delPromotion(PromotionVO vo) {
		return promotion.delPromotion(vo);
	}

	
}
