package businesslogic.userbl;

import util.ResultMessage;
import vo.WorkerVO;

public class MockWorker {

	private String userId;			
	private String userName;
	private String password;		
	private String contact;
			
	public MockWorker(){
				
	}
			
    public MockWorker(String userId,String userName,
			String password,String contact){
		super();
		this.userId=userId;
		this.userName=userName;
		this.password=password;
	    this.contact=contact;
				
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getContact() {
		return contact;
	}
	
	public WorkerVO workerType(String userid){
		return null;
	}
	
	public boolean login(String userid,String password){
		return true;
	}
	
	public WorkerVO getWokerInfo(String userid){
		return null;
	}
	
	public ResultMessage modify(WorkerVO information){
		return null;
	}
	
	public ResultMessage saveModify(WorkerVO information){
		return null;
	}
}
