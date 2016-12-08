package businesslogic.userbl.worker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.networker.WorkerInfo;
import businesslogicservice.userblservice.Login;
import businesslogicservice.userblservice.WorkerBLService;
import util.ResultMessage;
import vo.WorkerVO;

public class WorkerController implements WorkerBLService,WorkerInfo,Login{

	private Worker worker;
	
	public WorkerController() {
		worker = new Worker();
	}

	@Override
	public WorkerVO getInfo(String worker_id)throws RemoteException {
		// TODO Auto-generated method stub
		return worker.getInfo(worker_id);
	}

	@Override
	public ResultMessage modifyInfo(WorkerVO vo)throws RemoteException {
		// TODO Auto-generated method stub
		return worker.modifyInfo(vo);
	}

	@Override
	public WorkerVO getWorkerInfo(String worker_id) throws RemoteException {
		// TODO Auto-generated method stub
		return worker.getInfo(worker_id);
	}

	@Override
	public ArrayList<WorkerVO> getAllWorkerInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return worker.getAllWorker();
	}

	@Override
	public ResultMessage addWorker(WorkerVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return worker.addWorker(vo);
	}

	@Override
	public ResultMessage modifyWorker(WorkerVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return worker.modifyInfo(vo);
	}

	@Override
	public ResultMessage login(String user_id, String password)throws RemoteException {
		// TODO Auto-generated method stub
		return worker.login(user_id, password);
	}
	
	
}
