package businesslogic.userbl.netsale;

import java.rmi.RemoteException;

import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.NetsaleDataService;
import util.ResultMessage;
import vo.NetsaleVO;

public class Netsale {

	private NetsaleDataService netsaleDataService;
	
	public Netsale() {
		try{
			netsaleDataService = DatafactoryImpl.getInstance().getNetsaleData();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	/**
	 * 获取网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public NetsaleVO getInfo(String netsale_id){
		return null;
	}
	
	/**
	 * 修改网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public ResultMessage modifyInfo(NetsaleVO vo){
		return null;
	}
}
