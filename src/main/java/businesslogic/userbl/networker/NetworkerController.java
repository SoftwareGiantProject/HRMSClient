package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.NetworkerBLService;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.WorkerVO;

public class NetworkerController implements NetworkerBLService{

	private Networker networker;
	
	public NetworkerController() {
		networker = new Networker();
	}

	@Override
	public ClientVO getClientInfo(String user_id)throws RemoteException{
		// TODO Auto-generated method stub
		return networker.getClientInfo(user_id);
	}

	@Override
	public ArrayList<ClientVO> getAllClientInfo() throws RemoteException{
		// TODO Auto-generated method stub
		return networker.getAllClientInfo();
	}

	@Override
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException {
		// TODO Auto-generated method stub
		return networker.getWorkerInfo(worker_id);
	}

	@Override
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException {
		// TODO Auto-generated method stub
		return networker.getAllWorkerInfo();
	}

	@Override
	public ResultMessage addWorker(WorkerVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.addWorker(vo);
	}

	@Override
	public ResultMessage modifyWorker(WorkerVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.modifyWorker(vo);
	}

	@Override
	public NetsaleVO getNetsaleInfo(String netsale_id) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.getNetsaleInfo(netsale_id);
	}

	@Override
	public ResultMessage addNetsaleInfo(NetsaleVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.addNetsaleInfo(vo);
	}

	@Override
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.modifyNetsaleInfo(vo);
	}

	@Override
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException {
		// TODO Auto-generated method stub
		return networker.getAllNetsaleInfo();
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return networker.addHotel(vo);
	}
	
}
