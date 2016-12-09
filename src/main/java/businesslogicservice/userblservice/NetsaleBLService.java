package businesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage;
import vo.NetsaleVO;

public interface NetsaleBLService {

	/**
	 * 获取网络营销人员信息
	 * @param netsale_id
	 * @return
	 * @throws RemoteException 
	 */
	public NetsaleVO getInfo(String netsale_id) throws RemoteException;
	
	/**
	 * 修改网络营销人员信息
	 * @param netsale_id
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage modifyInfo(NetsaleVO vo) throws RemoteException;
	
	
}
