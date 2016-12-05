package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.WorkerVO;

public class Networker {

	
	private ClientInfo client;
	private NetsaleInfo netsale;
	private WorkerInfo worker;
	private Hoteladd hotel;
	
	public ClientVO getClientInfo(String user_id)throws RemoteException{
		return client.getClientInfo(user_id);
	}
	
	public ArrayList<ClientVO> getAllClientInfo()throws RemoteException{
		return client.getAllClientInfo();
	}
	
	
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException{
		return worker.getWorkerInfo(worker_id);
	}
	
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException{
		return worker.getAllWorkerInfo();
	}
	
	public ResultMessage addWorker(WorkerVO vo)throws RemoteException{
		return worker.addWorker(vo);
	}
	
	public ResultMessage modifyWorker(WorkerVO vo)throws RemoteException{
		return worker.modifyWorker(vo);
	}
	
	
	public NetsaleVO getNetsaleInfo(String netsale_id)throws RemoteException{
		return netsale.getNetsaleInfo(netsale_id);
	}
	
	public ResultMessage addNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.addNetsaleInfo(vo);
	}
	
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.modifyNetsaleInfo(vo);
	}
	
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException{
		return netsale.getAllNetsaleInfo();
	}
	
	
	public ResultMessage addHotel(HotelVO vo)throws RemoteException{
		return hotel.addHotel(vo);
	}
}
