package businesslogicservice.userblservice;

import vo.*;
import util.*;

public interface UserBLService {

	public ClientVO clientType(String userid);
	public WorkerVO workerType(String userid);
	public NetsaleVO netsaleType(String userid);
	public NetworkerVO networkerType(String userid);
	
	public boolean login(String userid,String password);
	
	public ClientVO getClientInfo(String userid);
	public WorkerVO getWokerInfo(String userid);
	public NetsaleVO getNetsaleInfo(String userid);
	public NetworkerVO getNetworkerInfo(String userid);
	
	public ResultMessage modify(ClientVO information);
	public ResultMessage modify(WorkerVO information);
	public ResultMessage modify(NetsaleVO information);
	public ResultMessage modify(NetworkerVO information);
	
	public ResultMessage saveModify(ClientVO information);
	public ResultMessage saveModify(WorkerVO information);
	public ResultMessage saveModify(NetsaleVO information);
	public ResultMessage saveModify(NetworkerVO information);
	
	public String getuserId();
	public String getClientBirthday(String user_id);
	ResultMessage addHotel(HotelVO vo);
	
}
