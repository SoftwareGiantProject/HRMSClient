package dataservice.userdataservice;

import java.rmi.RemoteException;

import util.ResultMessage;

public class LoginInImpl implements LoginIn {

	private static final long serialVersionUID = 1L;

	public LoginInImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage login(String user_name, String password) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
