package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.ClientPO;
import util.ResultMessage;

public class ClientDataServiceImpl implements ClientDataService{

	private static final long serialVersionUID = 1L;
	
	public ClientDataServiceImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClient(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean clientExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clientLogin(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
