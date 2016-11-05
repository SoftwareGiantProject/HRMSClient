package businesslogic.userbl;

import businesslogicservice.userblservice.UserBLService;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.NetworkerVO;
import vo.WorkerVO;

public class Netsale implements UserBLService{

	@Override
	public boolean login(String userid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClientVO getClientInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerVO getWokerInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetsaleVO getNetsaleInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetworkerVO getNetworkerInfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ClientVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(WorkerVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetsaleVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetworkerVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveModify(ClientVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveModify(WorkerVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveModify(NetsaleVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveModify(NetworkerVO information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientBirthday(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getuserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientVO clientType(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerVO workerType(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetsaleVO netsaleType(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetworkerVO networkerType(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}