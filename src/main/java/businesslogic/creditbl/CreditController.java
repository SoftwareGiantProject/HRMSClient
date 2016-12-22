package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage;
import vo.CreditVO;

public class CreditController implements CreditBLService{
	Credit credit;
	
	public CreditController() throws RemoteException {
		credit = new Credit();		
	}


	@Override
	public CreditVO getCredit(String user_id) {
		return credit.getCredit(user_id);
	}

	@Override
	public ResultMessage deduct(String user_id, int change) throws RemoteException {
		return credit.deduct(user_id, change);
	}

	@Override
	public ResultMessage deposit(String user_id,int change) throws RemoteException {
		return credit.deposit(user_id,change);
	}


	@Override
	public ResultMessage addCredit(String user_id, int change) throws RemoteException {
		// TODO Auto-generated method stub
		return credit.addCredit(user_id,change);
	}


	@Override
	public ArrayList<CreditVO> getAllCredit(String user_id) {
		// TODO Auto-generated method stub
		return credit.getAllCredit(user_id);
	}

}
