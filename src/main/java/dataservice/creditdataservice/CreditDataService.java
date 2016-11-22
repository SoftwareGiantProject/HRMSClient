package dataservice.creditdataservice;

import java.util.ArrayList;

import po.*;
import util.*;

public interface CreditDataService {

	public CreditPO find(String user_id);
	public ResultMessage modify(CreditPO po);

	public ArrayList<CreditPO> getHistoryCredit(String user_id);
}
