package dataservice.memberdataservice;

import java.rmi.RemoteException;

import po.ClientPO;
import po.CommonMemberPO;
import util.ResultMessage;

public class MemberDataServiceImpl implements MemberDataService{

	private static final long serialVersionUID = 1L;
	
	public MemberDataServiceImpl() throws RemoteException{
		super();
	}
	@Override
	public ResultMessage addCommonMember(String user_id, String birthday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find(ClientPO client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String commonMemberCreateNumber(CommonMemberPO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCorporateMember(String user_id, String corporate, String birthday) {
		// TODO Auto-generated method stub
		return null;
	}

}
