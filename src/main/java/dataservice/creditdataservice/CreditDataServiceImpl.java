package dataservice.creditdataservice;

import java.rmi.RemoteException;

import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceImpl implements CreditDataService {

	private static final long serialVersionUID = 1L;
	
	public CreditDataServiceImpl() throws RemoteException{
		super();
	}
	@Override
	public CreditPO find(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(CreditPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
