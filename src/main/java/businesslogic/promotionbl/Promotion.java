package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.transform.Templates;

import dataservice.datafactory.DatafactoryImpl;
import po.PromotionPO;
import util.ResultMessage;
import vo.PromotionVO;

public class Promotion {
	
	public PromotionVO getPromotion(String name){
		PromotionPO po = new PromotionPO();
		String id = name;
		
		try {
			po = DatafactoryImpl.getInstance().getPromotionData().findPromotion(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
		PromotionVO result = POTOVO(po);		
		return result;
	}
	
	public ArrayList<PromotionVO> getAllPromotion(){
		ArrayList<PromotionVO> lis1 = new ArrayList<PromotionVO>();
		
		try {
			ArrayList<PromotionPO> lis2 = DatafactoryImpl.getInstance().getPromotionData().getAllPromotion();
			for(PromotionPO temp : lis2){
				lis1.add(POTOVO(temp));
			}
					
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return lis1;
	}
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
	public ResultMessage addPromotion(PromotionVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getPromotionData().addPromotion(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}	
		
		return result;
	}
	
	public ResultMessage modifyPromotion(PromotionVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getPromotionData().modifyPromotion(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	public ResultMessage delPromotion(PromotionVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getPromotionData().delPromotion(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	public PromotionVO POTOVO(PromotionPO PO) {
		PromotionVO result = new PromotionVO(PO.getPromotionName(), PO.getPromotionObject(), PO.getCount(), PO.getTime());
		return result;	
	}
	
	public PromotionPO VOTOPO(PromotionVO VO){
		PromotionPO result = new PromotionPO(VO.getPromotionName(), VO.getPromoitonObject(), VO.getCount(), VO.getTime());
		return result;
	}

	
}
