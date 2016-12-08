package businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.NetworkerVO;
import vo.WorkerVO;

public interface NetworkerBLService {

	public ClientVO getClientInfo(String user_id) throws RemoteException;
	
	public ArrayList<ClientVO> getAllClientInfo()throws RemoteException;
	
	
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException;
	
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException;
	
	public ResultMessage addWorker(WorkerVO vo)throws RemoteException;
	
	public ResultMessage modifyWorker(WorkerVO vo)throws RemoteException;
	
	
	public NetsaleVO getNetsaleInfo(String netsale_id)throws RemoteException;
	
	public ResultMessage addNetsaleInfo(NetsaleVO vo)throws RemoteException;
	
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo)throws RemoteException;
	
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException;
	
	
	public NetworkerVO getNetworkerInfo(String networker_id)throws RemoteException;
	
	public ResultMessage addNetworkerInfo(NetworkerVO vo)throws RemoteException;
	
	public ResultMessage modifyNetworkerInfo(NetworkerVO vo)throws RemoteException;
	
	public ResultMessage addHotel(HotelVO vo)throws RemoteException;

}
