package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import vo.NetsaleVO;

public interface NetsaleInfo {

	public NetsaleVO getNetsaleInfo(String netsale_id)throws RemoteException;
	
	public ResultMessage addNetsaleInfo(NetsaleVO vo)throws RemoteException;
	
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo)throws RemoteException;
	
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException;
}
