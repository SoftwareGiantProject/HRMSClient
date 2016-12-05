package businesslogicservice.userblservice;

import util.ResultMessage;
import vo.NetsaleVO;

public interface NetsaleBLService {

	/**
	 * 获取网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public NetsaleVO getInfo(String netsale_id);
	
	/**
	 * 修改网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public ResultMessage modifyInfo(NetsaleVO vo);
}
