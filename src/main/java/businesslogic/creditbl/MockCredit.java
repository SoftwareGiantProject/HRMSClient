package businesslogic.creditbl;

import java.rmi.RemoteException;

import businesslogicservice.creditblservice.CreditBLService;
import dataservice.datafactoryservice.DatafactoryImpl;
import dataservice.datafactoryservice.DatafactoryService;
import po.CreditPO;
import util.ResultMessage;
import vo.CreditVO;

public class MockCredit {

	String userId;
	int credit;
	
	public MockCredit(){
		
	}
	
	public MockCredit(String userId,int credit){
		this.userId = userId;
		this.credit = credit;
	}

	public String getUserId() {
		return userId;
	}

	public int getCredit() {
		return credit;
	}
	
	public CreditVO getCredit(String user_id){
		CreditPO po = new CreditPO();
		String id = user_id;
		int credit;
		try{
			po = DatafactoryImpl.getInstance().getCreditData().find(id);
		}catch(RemoteException e){
			
		}
		
		CreditVO vo = new CreditVO();
		vo.setUserId(po.getId());
		vo.setCredit(po.getCredit());
		return vo;
	}

	public ResultMessage deduct(String user_id,int change){
		return null;
	}
	public CreditVO deposit(int change){
		return null;
	}
}
