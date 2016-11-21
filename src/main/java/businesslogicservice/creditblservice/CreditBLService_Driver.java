package businesslogicservice.creditblservice;

import util.ResultMessage;
import vo.CreditVO;

public class CreditBLService_Driver {
	public void drive(CreditBLService creditBLService){
		ResultMessage result=creditBLService.deduct("151250004", 5);
		if(result==ResultMessage.SUCCESS){
			System.out.println("Successfully DEDUCT!");
		}
		
		CreditVO credit1=creditBLService.getCredit("151250004");
		if(credit1==new CreditVO()){
			System.out.println("Get credit successfully !");
		}
		
		ResultMessage rm =creditBLService.deposit(5);
		if(rm == ResultMessage.SUCCESS){
			System.out.println("Deposit successfully!");
		}
	}

}

/*����main��������
 
CreditBLService creditController=new CreditController();
CreditBLService_Driver driver=new CreditBLService_Driver(creditController);
driver.drive(creditController);
*/