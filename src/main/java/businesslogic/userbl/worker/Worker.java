package businesslogic.userbl.worker;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.LoginIn;
import dataservice.userdataservice.WorkerDataService;
import po.WorkerPO;
import util.ResultMessage;
import vo.WorkerVO;

public class Worker {

	private WorkerDataService workerDataService;
	private LoginIn login;
	
	public Worker() {
		try{
			workerDataService = DatafactoryImpl.getInstance().getWorkerData();
			login = DatafactoryImpl.getInstance().getLoginData();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取酒店管理人员
	 * @param worker_id
	 * @return
	 */
	public WorkerVO getInfo(String worker_id){
		WorkerPO po = new WorkerPO();
		
		try {
			po = workerDataService.findWorker(worker_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		WorkerVO vo = po2vo(po);
		return vo;
	}
	
	/**
	 * 修改酒店管理人员信息
	 * @param worker_id
	 * @return
	 */
	public ResultMessage modifyInfo(WorkerVO vo){
		WorkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = workerDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 获得所有酒店管理人员信息
	 * @return
	 */
	public ArrayList<WorkerVO> getAllWorker(){
		ArrayList<WorkerPO> list = new ArrayList<>();
		
		try {
			list = workerDataService.getAllWorker();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<WorkerVO> resultList = new ArrayList<>();
		
		for(WorkerPO po : list){
			resultList.add(po2vo(po));
		}
		return resultList;
	}
	
	/**
	 * 添加酒店管理人员
	 * @param vo
	 * @return
	 */
	public ResultMessage addWorker(WorkerVO vo){
		WorkerPO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = workerDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
	
	
	private WorkerPO vo2po(WorkerVO vo){
		WorkerPO po = new WorkerPO();
		
		po.setContact(vo.getContact());
		po.setPassword(vo.getPassword());
		po.setUserId(vo.getUserId());
		po.setUserName(vo.getUserName());
		
		return po;
	}
	
	private WorkerVO po2vo(WorkerPO po){
		WorkerVO vo = new WorkerVO();
	
		vo.setContact(po.getContact());
		vo.setPassword(po.getPassword());
		vo.setUserId(po.getUserId());
		vo.setUserName(po.getUserName());
		
		return vo;
	}
}
