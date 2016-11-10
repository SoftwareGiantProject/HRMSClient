package businesslogicservice.creditblservice;

import vo.*;
import util.*;

public interface CreditBLService {

	public CreditVO getCredit(String user_id);

	public ResultMessage deduct(String user_id,int change);
	public CreditVO deposit(int change);
	
}
