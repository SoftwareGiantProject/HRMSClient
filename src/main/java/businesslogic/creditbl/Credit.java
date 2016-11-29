package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.datafactory.DatafactoryImpl;
import po.CreditPO;
import util.ResultMessage;
import vo.CreditVO;

public class Credit {
	
	
	public CreditVO getCredit(String user_id){
		CreditPO po = new CreditPO();
		String id = user_id;
		
		try{
			po = DatafactoryImpl.getInstance().getCreditData().find(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditVO vo = new CreditVO();
		vo.setUserId(po.getId());
		vo.setCredit(po.getCredit());
		return vo;
	}

	public ResultMessage deduct(String user_id,int change){
		ArrayList<CreditPO> historyPo = new ArrayList<CreditPO>();
		ResultMessage result = ResultMessage.FAIL;
		String id = user_id;
		int money = change;
		
		try{
			historyPo = DatafactoryImpl.getInstance().getCreditData().getHistoryCredit(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditPO lastcreditpo = historyPo.get(historyPo.size() - 1);
		int lastcredit = lastcreditpo.getCredit() - money/2;           //扣除额度1/2的信用值
		lastcreditpo.setCredit(lastcredit);
		
		try{
			result = DatafactoryImpl.getInstance().getCreditData().modify(lastcreditpo);
		}catch(RemoteException E){
			E.printStackTrace();
		}
		return result;
	}
	
	public ResultMessage deposit(String user_id, int change){
		ArrayList<CreditPO> historyPo = new ArrayList<CreditPO>();
		ResultMessage result = ResultMessage.FAIL;
		String id = user_id;
		int recharge = change;
		
		try{
			historyPo = DatafactoryImpl.getInstance().getCreditData().getHistoryCredit(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditPO lastcreditpo = historyPo.get(historyPo.size() - 1);
		int lastcredit = lastcreditpo.getCredit() + recharge*100;           //扣除额度1/2的信用值
		lastcreditpo.setCredit(lastcredit);
		
		try{
			result = DatafactoryImpl.getInstance().getCreditData().modify(lastcreditpo);
		}catch(RemoteException E){
			E.printStackTrace();
		}
		
		return result;
	}
	
}
