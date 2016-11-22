package businesslogicservice.creditblservice;

import vo.*;

import java.util.ArrayList;

import util.*;

public interface CreditBLService {

	public CreditVO getCredit(String user_id);
	public ArrayList<CreditVO> getHistoryCredit(String user_id);

	public ResultMessage deduct(String user_id,int change);
	public ResultMessage deposit(int change);
	
}
