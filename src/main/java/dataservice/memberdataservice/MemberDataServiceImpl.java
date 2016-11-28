package dataservice.memberdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class MemberDataServiceImpl implements MemberDataService{

	private static final long serialVersionUID = 1L;
	
	public MemberDataServiceImpl() throws RemoteException{
		super();
	}

	@Override
	public ArrayList<CommonMemberPO> getComMember() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CorporateMemberPO> getCorMember() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addComMember(CommonMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCorMember(CorporateMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
