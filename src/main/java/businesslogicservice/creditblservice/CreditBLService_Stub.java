package businesslogicservice.creditblservice;
import java.util.ArrayList;

import util.ResultMessage;

import vo.CreditVO;

public class CreditBLService_Stub implements CreditBLService{
	String userId;
	int credit;
	
	public CreditBLService_Stub(String userid,int credit){
		this.userId=userid;
		this.credit=credit;
	}
	
	@Override
	public CreditVO getCredit(String user_id){
		return new CreditVO(userId,credit);
	}

	@Override
	public ResultMessage deduct(String user_id, int change) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deposit(int change) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CreditVO> getHistoryCredit(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
