package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.ResultMessage;

public class ClientDataServiceImpl implements ClientDataService{

	private static final long serialVersionUID = 1L;
	
	public ClientDataServiceImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClient(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClientPO> getAllClient() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage registComMember(String user_id,CommonMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage registCorMember(String user_id,CorporateMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
