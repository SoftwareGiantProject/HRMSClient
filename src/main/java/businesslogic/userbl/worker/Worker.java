package businesslogic.userbl.worker;

import java.rmi.RemoteException;

import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.WorkerDataService;
import util.ResultMessage;
import vo.WorkerVO;

public class Worker {

	private WorkerDataService workerDataService;
	
	public Worker() {
		try{
			workerDataService = DatafactoryImpl.getInstance().getWorkerData();
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
		return null;
	}
	
	/**
	 * 修改酒店管理人员信息
	 * @param worker_id
	 * @return
	 */
	public ResultMessage modifyInfo(WorkerVO vo){
		return null;
	}
}
