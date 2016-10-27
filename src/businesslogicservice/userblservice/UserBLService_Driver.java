package businesslogicservice.userblservice;

import util.ResultMessage;
import vo.ClientVO;
import vo.NetsaleVO;
import vo.NetworkerVO;
import vo.WorkerVO;

public class UserBLService_Driver {
	public void drive(UserBLService userBLService){
		ClientVO ctype=userBLService.clientType("151250001");
		if(ctype==new ClientVO()){
			System.out.println("Choose client type.");
		}
		
		WorkerVO wtype=userBLService.workerType("151250002");
		if(wtype==new WorkerVO()){
			System.out.println("Choose worker type.");
		}
		
		NetsaleVO nstype=userBLService.netsaleType("151250003");
		if(nstype==new NetsaleVO()){
			System.out.println("Choose netsale type.");
		}
		
		NetworkerVO nwtype=userBLService.networkerType("151250004");
		if(nwtype==new NetworkerVO()){
			System.out.println("Choose networker type");
		}
		
		boolean bool=userBLService.login("151250004","151250004");
		if(bool==true){
			System.out.println("Login Success.");
		}
		else{
			System.out.println("Erro!");
		}
		
		 ClientVO gcinfo=userBLService.getClientInfo("151250004");
		 if(gcinfo==new ClientVO()){
			 System.out.println("Get Information Successfully.");
		 }
		 
	     WorkerVO gwinfo=userBLService.getWokerInfo("151250002");
	     if(gwinfo==new WorkerVO()){
	    	 System.out.println("Get Information Successfully."); 
	     }
	     
		 NetsaleVO gnsinfo=userBLService.getNetsaleInfo("151250003");
		 if(gnsinfo==new NetsaleVO()){
			 System.out.println("Get Information Successfully.");
		 }
		 
		 NetworkerVO hnwinfo=userBLService.getNetworkerInfo("151250004");
		 if(hnwinfo==new NetworkerVO()){
			 System.out.println("Get Information Successfully.");
		 }
		 
		 ResultMessage res1=userBLService.modify(new ClientVO());
		 if(res1==ResultMessage.SUCCESS){
			 System.out.println("Modify Successfully!");
		 }
		 
		 ResultMessage res2=userBLService.modify(new WorkerVO());
		 if(res2==ResultMessage.SUCCESS){
			 System.out.println("Modify Successfully!");
		 }
		 
		 ResultMessage res3=userBLService.modify(new NetsaleVO());
		 if(res3==ResultMessage.SUCCESS){
			 System.out.println("Modify Successfully!");
		 }
		 
		 ResultMessage res4=userBLService.modify(new NetworkerVO());
		 if(res4==ResultMessage.SUCCESS){
			 System.out.println("Modify Successfully!");
		 }
		 
		 ResultMessage save1=userBLService.saveModify(new ClientVO());
		 if(save1==ResultMessage.SUCCESS){
			 System.out.println("Save Modify Successfully!");
		 }
		 
		 ResultMessage save2=userBLService.saveModify(new WorkerVO());
		 if(save2==ResultMessage.SUCCESS){
			 System.out.println("Save Modify Successfully!");
		 }
		 
		 ResultMessage save3=userBLService.saveModify(new NetsaleVO());
		 if(save3==ResultMessage.SUCCESS){
			 System.out.println("Save Modify Successfully!");
		 }
		 
		 ResultMessage save4=userBLService.saveModify(new NetworkerVO());
		 if(save4==ResultMessage.SUCCESS){
			 System.out.println("Save Modify Successfully!");
		 }
	}

}
/*关于main函数部分

UserBLService userController=new UserController();
UserBLService_Driver driver=new UserBLService_Driver(userController);
driver.drive(userController);
*/