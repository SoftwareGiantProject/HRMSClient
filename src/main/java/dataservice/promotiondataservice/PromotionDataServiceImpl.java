package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;
import util.ResultMessage;

public class PromotionDataServiceImpl implements PromotionDataService {

	private static final long serialVersionUID = 1L;
	
	public PromotionDataServiceImpl() throws RemoteException{
		super();
	}
	@Override
	public PromotionPO findPromotion(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PromotionPO> getAllPromotion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addMemberPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
