package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.*;
import util.ResultMessage;
import vo.MemberPromotionVO;
import vo.PromotionVO;


public class PromotionController implements PromotionBLService{

	Promotion promotion;
	
	public PromotionController() {
		promotion = new Promotion();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PromotionVO getPromotion(String name) {
		return promotion.getPromotion(name);
	}

	@Override
	public ArrayList<PromotionVO> getAllPromotion() {
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

	@Override
	public MemberPromotionVO getMemberPromotion(String name) {
		// TODO Auto-generated method stub
		return promotion.getMemberPromotion(name);
	}

	@Override
	public ResultMessage addMemberPromotion(MemberPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotion.addMemberPromotion(vo);
	}

	

	
}
