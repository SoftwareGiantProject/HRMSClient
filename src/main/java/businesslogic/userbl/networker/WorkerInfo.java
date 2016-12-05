package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import vo.WorkerVO;

public interface WorkerInfo {
	
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException;
	
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException;
	
	public ResultMessage addWorker(WorkerVO vo)throws RemoteException;
	
	public ResultMessage modifyWorker(WorkerVO vo)throws RemoteException;
}
