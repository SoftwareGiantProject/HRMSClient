package businesslogicservice.memberblservice;

import vo.*;

import java.rmi.RemoteException;

import util.*;

public interface MemberBLService {

	public ResultMessage registerComMember(String birthday, String user_id) throws RemoteException;
	public ResultMessage registerCorMember(String birthday, String user_id, String corporate) throws RemoteException;
	
}
