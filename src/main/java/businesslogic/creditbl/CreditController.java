package businesslogic.creditbl;

import java.util.ArrayList;

import businesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage;
import vo.CreditVO;

public class CreditController implements CreditBLService{
	Credit credit;
	
	public CreditController() {
		credit = new Credit();		
	}


	@Override
	public CreditVO getCredit(String user_id) {
		return credit.getCredit(user_id);
	}

	@Override
	public ResultMessage deduct(String user_id, int change) {
		return credit.deduct(user_id, change);
	}

	@Override
	public ResultMessage deposit(String user_id,int change) {
		return credit.deposit(user_id,change);
	}

}
