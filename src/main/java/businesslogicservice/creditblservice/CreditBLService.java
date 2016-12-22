package businesslogicservice.creditblservice;

import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.*;

public interface CreditBLService {

	public ArrayList<CreditVO> getAllCredit(String user_id);
	public CreditVO getCredit(String user_id);

	public ResultMessage deduct(String user_id,int change) throws RemoteException;
	public ResultMessage deposit(String user_id,int change) throws RemoteException;
	public ResultMessage addCredit(String user_id,int change) throws RemoteException;
}
