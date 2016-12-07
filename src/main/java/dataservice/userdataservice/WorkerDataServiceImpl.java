package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.WorkerPO;
import util.ResultMessage;

public class WorkerDataServiceImpl implements WorkerDataService{
	private static final long serialVersionUID = 1L;
	
	public WorkerDataServiceImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResultMessage add(WorkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerPO findWorker(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(WorkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<WorkerPO> getAllWorker() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
