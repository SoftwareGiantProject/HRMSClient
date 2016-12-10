package businesslogic.userbl.networker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.client.ClientController;
import dataservice.datafactory.DataFactory;
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
			client = (ClientInfo) ControllerFactory.getClientBLSerivceInstance();
			netsale = (NetsaleInfo) ControllerFactory.getNetsaleBLServiceInstance();
			worker = (WorkerInfo) ControllerFactory.getWorkerBLServiceInstance();
			hotel = (Hoteladd) ControllerFactory.getHotelBLServiceInstance();
			networkerDataService = DatafactoryImpl.getInstance().getNetworkerData();
			login = DatafactoryImpl.getInstance().getLoginData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得网站管理人员信息
	 * @param networker_id
	 * @return
	 * @throws RemoteException
	 */
	public NetworkerVO getNetworkerInfo(String networker_id)throws RemoteException{
		NetworkerPO po = new NetworkerPO();
		
		po = networkerDataService.findNetworker(networker_id);
		
		NetworkerVO vo = po2vo(po);
		return vo;
	}

	/**
	 * 添加网站管理人员
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addNetworkerInfo(NetworkerVO vo)throws RemoteException{
		NetworkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		result = networkerDataService.add(po);
		
		return result;
	}
	
	/**
	 * 修改网站管理人员信息
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyNetworkerInfo(NetworkerVO vo)throws RemoteException{
		NetworkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		result = networkerDataService.modify(po);
		
		return result;
	}
	
	/**
	 * 登录
	 * @param user_id
	 * @param password
	 * @return
	 */
	public ResultMessage login(String user_id, String password){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = login.login(user_id, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获得客户信息
	 * @param user_id
	 * @return
	 * @throws RemoteException
	 */
	public ClientVO getClientInfo(String user_id)throws RemoteException{
		return client.getClientInfo(user_id);
	}
	
	/**
	 * 获得所有客户信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> getAllClientInfo()throws RemoteException{
		return client.getAllClientInfo();
	}
	
	
	/**
	 * 获得酒店工作人员信息
	 * @param worker_id
	 * @return
	 * @throws RemoteException
	 */
	public WorkerVO getWorkerInfo(String worker_id)throws RemoteException{
		return worker.getWorkerInfo(worker_id);
	}
	
	/**
	 * 获得所有酒店工作人员信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<WorkerVO> getAllWorkerInfo()throws RemoteException{
		return worker.getAllWorkerInfo();
	}
	
	/**
	 * 添加酒店工作人员
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addWorker(WorkerVO vo)throws RemoteException{
		return worker.addWorker(vo);
	}
	
	/**
	 * 修改酒店工作人员信息
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyWorker(WorkerVO vo)throws RemoteException{
		return worker.modifyWorker(vo);
	}
	
	
	/**
	 * 获得网站营销人员信息
	 * @param netsale_id
	 * @return
	 * @throws RemoteException
	 */
	public NetsaleVO getNetsaleInfo(String netsale_id)throws RemoteException{
		return netsale.getNetsaleInfo(netsale_id);
	}
	
	/**
	 * 添加网站营销人员
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.addNetsaleInfo(vo);
	}
	
	/**
	 * 修改网站营销人员信息
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo)throws RemoteException{
		return netsale.modifyNetsaleInfo(vo);
	}
	
	/**
	 * 获得所有网站营销人员信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<NetsaleVO> getAllNetsaleInfo()throws RemoteException{
		return netsale.getAllNetsaleInfo();
	}
	
	
	/**
	 * 添加酒店
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
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
