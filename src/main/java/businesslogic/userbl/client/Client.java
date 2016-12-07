package businesslogic.userbl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.datafactory.DataFactory;
import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.ClientDataService;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class Client {

	
	private ClientDataService clientDataService;
	
	
	public Client() {
		try{
			clientDataService = DatafactoryImpl.getInstance().getClientData();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	public ResultMessage regist(ClientVO vo,String password){
		return null;
	}
	
	public ClientVO getClientInfo(String user_id){
		return null;
	}
	
	public ResultMessage modifyInfo(ClientVO vo){
		return null;
	}
	
	public ResultMessage registComMember(CommonMemberVO vo){
		return null;
	}
	
	public ResultMessage registCorMember(CorporateMemberVO vo){
		return null;
	}

	public ArrayList<ClientVO> getAllClientInfo() {
		return null;
	}
	
	public ResultMessage login(String user_id, String password){
		return null;
	}
}
