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
		return ResultMessage.SUCCESS;
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
	
	public ResultMessage registComMember(String id,CommonMemberVO vo)throws RemoteException{
		CommonMemberPO po =  new CommonMemberPO();
		
		po.setCommonMember_number(vo.getCommonMember_number());
		po.setCommonMember_Birthday(vo.getCommonMember_Birthday());
		po.setCommonMember_level(vo.getCommonMember_level());
		po.setMember_type(vo.getMember_type());
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = clientDataService.registComMember(id,po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultMessage registCorMember(String id,CorporateMemberVO vo)throws RemoteException{
		CorporateMemberPO po = new CorporateMemberPO();
		
		po.setCorporate(vo.getCorporate());
		po.setCorporateMember_Birthday(vo.getCorporateMember_Birthday());
		po.setCorporateMember_level(vo.getCorporateMember_level());
		po.setCorporateMember_number(vo.getCorporateMember_number());
		po.setMemberType(vo.getMember_Type());
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = clientDataService.registCorMember(id,po);
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
	
	public ResultMessage login(String user_id, String password)throws RemoteException{
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = login.login(user_id, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private ClientPO vo2po(ClientVO vo){
		ClientPO po = new ClientPO();
		
		po.setUserId(vo.getUserId());
		po.setUserName(vo.getUserName());
		po.setBirthday(vo.getBirthday());
		po.setContact(vo.getContact());
		po.setCredit(vo.getCredit());
		po.setMemberId(vo.getMemberId());
		po.setPassword(vo.getPassword());
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
