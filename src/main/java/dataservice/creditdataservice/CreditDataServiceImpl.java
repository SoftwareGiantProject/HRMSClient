package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceImpl implements  CreditDataService {

	private static final long serialVersionUID = 1L;
	
	public CreditDataServiceImpl() throws RemoteException{
		super();
	}

	@Override
	public int getCredit(String user_id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CreditPO find(String user_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(CreditPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditPO> getHistoryCredit(String user_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
