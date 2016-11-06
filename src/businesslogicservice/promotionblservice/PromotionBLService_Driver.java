package businesslogicservice.promotionblservice;

import util.*;
import vo.PromotionVO;

public class PromotionBLService_Driver {

	public void drive(PromotionBLService promotionBLService){
		PromotionVO vo1 = new PromotionVO("双十一促销策略","所有用户",8,"2016-11-7 to 2016-11-15");
		
		ResultMessage result1 = promotionBLService.addPromotion(vo1);
		if(result1 == ResultMessage.EXIST)
    		System.out.println("Promotion exist");
    	else
    		System.out.println("Add success");
		
		ResultMessage result2 = promotionBLService.modifyPromotion(vo1);
		if(result2 == ResultMessage.SUCCESS)
    		System.out.println("Modify success");
    	else if(result2 == ResultMessage.FAIL)
    		System.out.println("Modify fail");
		
		ResultMessage result3 = promotionBLService.delPromotion(vo1);
		if(result3 == ResultMessage.SUCCESS)
			System.out.println("Delete success");
		else if(result3 == ResultMessage.FAIL)
			System.out.println("Delete fail");
		
		String name = "";
		PromotionVO vo2 = promotionBLService.getPromotion(name);
		if(vo2.getPromotionName() == name){
			System.out.println("Promotion name: " + vo2.getPromotionName() + "Promotion object: "
					+ vo2.getPromoitonObject() + "Promotion count: " + vo2.getCount()
					+ "Promotion time: " + vo2.getTime());
		}
		
	}
}
