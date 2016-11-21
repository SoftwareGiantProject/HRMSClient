package businesslogic.creditbl;

import businesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage;
import vo.CreditVO;

public class CreditController implements CreditBLService{
	
	MockCredit credit = new MockCredit();

	@Override
	public CreditVO getCredit(String user_id) {
		return credit.getCredit(user_id);
	}

	@Override
	public ResultMessage deduct(String user_id, int change) {
		return credit.deduct(user_id, change);
	}

	@Override
	public ResultMessage deposit(int change) {
		return credit.deposit(change);
	}

}
