package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.NetsalePO;
import util.ResultMessage;

public class NetsaleDataServiceImpl implements NetsaleDataService{
	private static final long serialVersionUID = 1L;
	
	public NetsaleDataServiceImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public ResultMessage add(NetsalePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetsalePO findNetsale(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetsalePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<NetsalePO> getAllNetsale() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
