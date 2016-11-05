package businesslogic.creditbl;

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
		return null;
	}

	public ResultMessage deduct(String user_id,int change){
		return null;
	}
	public CreditVO deposit(int change){
		return null;
	}
}
