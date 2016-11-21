package businesslogicservice.userblservice;

import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.WorkerVO;
import vo.NetsaleVO;
import vo.NetworkerVO;

public class UserBLService_Stub implements UserBLService{
	String userid;
	String username;
	String password;
	String contact;
	int credit;
	
	public UserBLService_Stub(String id,String name,String word,int cred,String cont){
		userid=id;
		username=name;
		password=word;
		contact=cont;
		credit=cred;
	}
	
	@Override
	public ClientVO clientType(String userid){
		return new ClientVO().getClientVO();
	}
	
	@Override
	public WorkerVO workerType(String userid){
		return new WorkerVO(userid,username,password,contact);
	}
	
	@Override
	public NetsaleVO netsaleType(String userid){
		return new NetsaleVO(userid,username,password,contact);
	}
	
	@Override
	public NetworkerVO networkerType(String userid){
		return new NetworkerVO(userid,username,password,contact);
	}
	
	@Override
	public boolean login(String userid,String password){
		boolean res=false;
		if(userid.equals(this.userid)){
			if(password.equals(this.password)){
				res=true;
			}
		}
		else{
			res=false;
		}
		return res;
	}
	
	@Override
	public ClientVO getClientInfo(String userid){
		return new ClientVO(userid,username,password,credit,contact);
	}
	
	@Override
	public WorkerVO getWokerInfo(String userid){
		return new WorkerVO(userid,username,password,contact);
	}
	
	@Override
	public NetsaleVO getNetsaleInfo(String userid){
		return new NetsaleVO(userid,username,password,contact);
	}
	
	
	@Override
	public NetworkerVO getNetworkerInfo(String userid){
		return new NetworkerVO(userid,username,password,contact);
	}
	
	@Override
	public ResultMessage modify(ClientVO information){
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage modify(WorkerVO information){
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage modify(NetsaleVO information){
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage modify(NetworkerVO information){
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage saveModify(ClientVO information){
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveModify(WorkerVO information){
		return ResultMessage.SUCCESS;
	}

	
	@Override
	public ResultMessage saveModify(NetsaleVO information){
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage saveModify(NetworkerVO information){
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getuserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientBirthday(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}