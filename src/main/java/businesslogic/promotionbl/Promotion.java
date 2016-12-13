package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.transform.Templates;

import dataservice.datafactory.DatafactoryImpl;
import po.MemberPromotionPO;
import po.PromotionPO;
import util.ResultMessage;
import vo.MemberPromotionVO;
import vo.PromotionVO;

public class Promotion {
	
	
	/**
	 * 返回会员促销策略
	 * @param name
	 * @return
	 */
	public MemberPromotionVO getMemberPromotion(String name){
		MemberPromotionVO result = new MemberPromotionVO();
		MemberPromotionPO temp = new MemberPromotionPO();
		
		try {
			temp = DatafactoryImpl.getInstance().getPromotionData().findMemberPromotion(name);
			result = potovo(temp);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 根据名称得到该促销策略
	 * @param name 促销策略名称
	 * @return
	 */
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
	
	/**
	 * 得到所有促销策略
	 * @return
	 */
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
	
	
	/**
	 * 添加会员促销策略
	 * @param vo
	 * @return
	 */
	public ResultMessage addMemberPromotion(MemberPromotionVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getPromotionData().addMemberPromotion(votopo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	
	/**
	 * 增加促销策略
	 * @param vo
	 * @return
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
	
	/**
	 * 修改促销策略
	 * @param vo
	 * @return
	 */
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
	
	
	/**
	 * 删除促销策略
	 * @param vo
	 * @return
	 */
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
	
	public MemberPromotionVO potovo(MemberPromotionPO po){
		MemberPromotionVO result = new MemberPromotionVO(po.getPromotionName(), po.getPromotionObject(), po.getTime(), po.getCount(), po.getArea());
		return result;
	}
	
	public PromotionPO VOTOPO(PromotionVO VO){
		PromotionPO result = new PromotionPO(VO.getPromotionName(), VO.getPromoitonObject(), VO.getCount(), VO.getTime());
		return result;
	}
	
	public MemberPromotionPO votopo(MemberPromotionVO vo){
		MemberPromotionPO result = new MemberPromotionPO(vo.getPromotionName(), vo.getTime(), vo.getCount(), vo.getArea());
		return result;
	}

	
}
