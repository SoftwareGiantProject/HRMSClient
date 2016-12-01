package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dataservice.datafactory.DatafactoryImpl;

import po.CreditPO;
import util.ResultMessage;
import vo.CreditVO;

public class Credit {
	
	
	public CreditVO getCredit(String user_id){
		CreditPO po = new CreditPO();
		String id = user_id;
		
		try{
			po = DatafactoryImpl.getInstance().getCreditData().find(user_id);
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
		int lastcredit = lastcreditpo.getCredit() - money/2;           
		int lastchange = -money/2;
		Date now = new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String current = matter1.format(now);
		
		lastcreditpo.setCredit(lastcredit);
		lastcreditpo.setChange(lastchange);
		lastcreditpo.setTime(current);
		
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
		int lastcredit = lastcreditpo.getCredit() + recharge*100;           //澧炲姞鍏呭�奸搴�*100鐨勪俊鐢ㄥ��
		int lastchange = recharge*100;
		Date now = new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String current = matter1.format(now);
		
		lastcreditpo.setCredit(lastcredit);
		lastcreditpo.setChange(lastchange);
		lastcreditpo.setTime(current);
		
		try{
			result = DatafactoryImpl.getInstance().getCreditData().modify(lastcreditpo);
		}catch(RemoteException E){
			E.printStackTrace();
		}
		
		return result;
	}
	
}
