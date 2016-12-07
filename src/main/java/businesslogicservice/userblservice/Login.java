package businesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage;

public interface Login {

	/**
	 * 登录
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage login(String user_id,String password) throws RemoteException;
}
