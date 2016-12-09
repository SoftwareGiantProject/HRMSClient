package businesslogic.userbl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.networker.ClientInfo;
import businesslogicservice.userblservice.ClientBLService;
import businesslogicservice.userblservice.Login;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class ClientController implements ClientBLService,ClientInfo,Login{

	Client client;
	
	public ClientController() {
		client = new Client();
	}

	@Override
	public ResultMessage regist(ClientVO vo)throws RemoteException {
		// TODO Auto-generated method stub
		return client.regist(vo);
	}

	@Override
	public ClientVO getClientInfo(String user_id)throws RemoteException {
		// TODO Auto-generated method stub
		return client.getClientInfo(user_id);
	}

	@Override
	public ResultMessage modifyInfo(ClientVO vo)throws RemoteException {
		// TODO Auto-generated method stub
		return client.modifyInfo(vo);
	}

	@Override
	public ResultMessage registComMember(String id,CommonMemberVO vo)throws RemoteException {
		// TODO Auto-generated method stub
		return client.registComMember(id,vo);
	}

	@Override
	public ResultMessage registCorMember(String id,CorporateMemberVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return client.registCorMember(id,vo);
	}

	@Override
	public ArrayList<ClientVO> getAllClientInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return client.getAllClientInfo();
	}

	@Override
	public ResultMessage login(String user_id, String password) throws RemoteException{
		// TODO Auto-generated method stub
		return client.login(user_id, password);
	}
}
