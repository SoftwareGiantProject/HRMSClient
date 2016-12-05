package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ClientVO;

public interface ClientInfo {
	
	/**
	 * 获取用户信息
	 * @param user_id
	 * @return
	 */
	public ClientVO getClientInfo(String user_id)throws RemoteException;

	/**
	 * 获取所有用户信息
	 * @return
	 */
	public ArrayList<ClientVO> getAllClientInfo()throws RemoteException;
 }
