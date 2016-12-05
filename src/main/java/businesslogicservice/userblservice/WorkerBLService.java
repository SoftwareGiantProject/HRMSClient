package businesslogicservice.userblservice;

import util.ResultMessage;
import vo.WorkerVO;

public interface WorkerBLService {

	/**
	 * 获取酒店管理人员
	 * @param worker_id
	 * @return
	 */
	public WorkerVO getInfo(String worker_id);
	
	/**
	 * 修改酒店管理人员信息
	 * @param worker_id
	 * @return
	 */
	public ResultMessage modifyInfo(WorkerVO vo);
}
