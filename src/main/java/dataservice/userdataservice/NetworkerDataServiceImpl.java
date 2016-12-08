package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.NetworkerPO;
import util.ResultMessage;

public class NetworkerDataServiceImpl implements NetworkerDataService{
	private static final long serialVersionUID = 1L;
	
	public NetworkerDataServiceImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public NetworkerPO findNetworker(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetworkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(NetworkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
