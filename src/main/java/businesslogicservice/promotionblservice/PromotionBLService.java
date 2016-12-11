package businesslogicservice.promotionblservice;

import vo.*;
import java.util.ArrayList;
import util.*;

public interface PromotionBLService {


	public PromotionVO getPromotion(String name);
	
	public ArrayList<PromotionVO> getAllPromotion();
	/*
	public ResultMessage addMemberPromotion(PromotionVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getPromotionData().addMemberPromotion(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	*/
	public ResultMessage addPromotion(PromotionVO vo);
	
	public ResultMessage modifyPromotion(PromotionVO vo);
	
	public ResultMessage delPromotion(PromotionVO vo);
}
