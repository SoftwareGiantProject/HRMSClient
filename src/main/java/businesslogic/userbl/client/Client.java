package businesslogic.userbl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.Login;
import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.LoginIn;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class Client {

	
	private ClientDataService clientDataService;
	private LoginIn login;
	
	
	public Client() {
		try{
			clientDataService = DatafactoryImpl.getInstance().getClientData();
			login = DatafactoryImpl.getInstance().getLoginData();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	public ResultMessage regist(ClientVO vo)throws RemoteException{
		ClientPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = clientDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ClientVO getClientInfo(String user_id)throws RemoteException{
		ClientVO vo = new ClientVO();
		
		ClientPO po = new ClientPO();
		
		try {
			po = clientDataService.findClient(user_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		vo = po2vo(po);
		return vo;
	}
	
	public ResultMessage modifyInfo(ClientVO vo)throws RemoteException{
		ClientPO po = new ClientPO();
		
		po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = clientDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

	public ArrayList<ClientVO> getAllClientInfo() throws RemoteException{
		ArrayList<ClientPO> list = new ArrayList<>();
		
		try {
			list = clientDataService.getAllClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<ClientVO> resultList = new ArrayList<>();
		for(ClientPO po : list){
			resultList.add(po2vo(po));
		}
		return resultList;
	}
	
	public ResultMessage check(String id){
		ResultMessage result = ResultMessage.FAIL;
		ClientPO po = new ClientPO();
		try {
			po = clientDataService.findClient(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
		
		if(po != null){
			result = ResultMessage.SUCCESS;
		}
		return result;
	}
	
	public ResultMessage login(String user_id, String password)throws RemoteException{
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = login.login(user_id, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	public ResultMessage modifyPassword(String user_id,String oldPassword, String newPassword) {
		ResultMessage result = ResultMessage.FAIL;
		ClientPO client = new ClientPO();
		
		try {
			client = clientDataService.findClient(user_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(!oldPassword.equals(client.getPassword())){
			return ResultMessage.FAIL;
		}
		else{
			client.setPassword(newPassword);
			try {
				result = clientDataService.modify(client);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private ClientPO vo2po(ClientVO vo){
		ClientPO po = new ClientPO();
		
		po.setUserId(vo.getUserId().get());
		po.setUserName(vo.getUserName().get());
		po.setBirthday(vo.getBirthday().get());
		po.setContact(vo.getContact().get());
		po.setCredit(vo.getCredit().get());
		po.setMemberId(vo.getMemberId().get());
		po.setPassword(vo.getPassword().get());
		po.setType(vo.getType());
		return po;
	}
	
	private ClientVO po2vo(ClientPO po){
		ClientVO vo = new ClientVO();
		
		vo.setUserId(po.getUserId());
		vo.setBirthday(po.getBirthday());
		vo.setContact(po.getContact());
		vo.setCredit(po.getCredit());
		vo.setMemberId(po.getMemberId());
		vo.setPassword(po.getPassword());
		vo.setType(po.getType());
		vo.setUserName(po.getUserName());
		
		return vo;
	}

}
