package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.LoginIn;
import dataservice.userdataservice.NetworkerDataService;
import po.NetworkerPO;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.NetworkerVO;
import vo.WorkerVO;

public class Networker {

	
	private ClientInfo client;
	private NetsaleInfo netsale;
	private WorkerInfo worker;
	private Hoteladd hotel;
	
	private LoginIn login;
	private NetworkerDataService networkerDataService;

	public Networker() {
		try {
			networkerDataService = DatafactoryImpl.getInstance().getNetworkerData();
			login = DatafactoryImpl.getInstance().getLoginData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NetworkerVO getNetworkerInfo(String networker_id)throws RemoteException{
		NetworkerPO po = new NetworkerPO();
		
		po = networkerDataService.findNetworker(networker_id);
		
		NetworkerVO vo = po2vo(po);
		return vo;
	}

	public ResultMessage addNetworkerInfo(NetworkerVO vo)throws RemoteException{
		NetworkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		result = networkerDataService.add(po);
		
		return result;
	}
	
	public ResultMessage modifyNetworkerInfo(NetworkerVO vo)throws RemoteException{
		NetworkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		result = networkerDataService.modify(po);
		
		return result;
	}
	
	public ResultMessage login(String user_id, String password){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = login.login(user_id, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ClientVO getClientInfo(String user_id)throws RemoteException{
		return client.getClientInfo(user_id);
	}
	
	public ArrayList<ClientVO> getAllClientInfo()throws RemoteException{
		return client.getAllClientInfo();
	}
	
	
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException{
		return worker.getWorkerInfo(worker_id);
	}
	
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException{
		return worker.getAllWorkerInfo();
	}
	
	public ResultMessage addWorker(WorkerVO vo)throws RemoteException{
		return worker.addWorker(vo);
	}
	
	public ResultMessage modifyWorker(WorkerVO vo)throws RemoteException{
		return worker.modifyWorker(vo);
	}
	
	
	public NetsaleVO getNetsaleInfo(String netsale_id)throws RemoteException{
		return netsale.getNetsaleInfo(netsale_id);
	}
	
	public ResultMessage addNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.addNetsaleInfo(vo);
	}
	
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.modifyNetsaleInfo(vo);
	}
	
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException{
		return netsale.getAllNetsaleInfo();
	}
	
	
	public ResultMessage addHotel(HotelVO vo)throws RemoteException{
		return hotel.addHotel(vo);
	}
	
	private NetworkerPO vo2po(NetworkerVO vo){
		NetworkerPO po = new NetworkerPO();
		
		po.setContact(vo.getContact());
		po.setPassword(vo.getPassword());
		po.setUserId(vo.getUserId());
		po.setUserName(vo.getUserName());
		
		return po;
	}
	
	private NetworkerVO po2vo(NetworkerPO po){
		NetworkerVO vo = new NetworkerVO();
		
		vo.setContact(po.getContact());
		vo.setPassword(po.getPassword());
		vo.setUserId(po.getUserId());
		vo.setUserName(po.getUserName());
		
		return vo;
	}
}
