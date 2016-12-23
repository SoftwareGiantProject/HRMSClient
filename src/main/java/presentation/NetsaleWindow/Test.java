package presentation.NetsaleWindow;

import java.rmi.RemoteException;

import businesslogic.creditbl.Credit;
import businesslogic.creditbl.CreditController;
import dataservice.datafactory.DataFactory;
import vo.CreditVO;

public class Test {
	public static void main(String args[]){
		/*CreditController creditController;
		
		try {
			creditController = new CreditController();
			CreditVO creditVO=creditController.getCredit("151250058");
			System.out.println(creditVO.getCredit());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Credit credit;
		try {
			credit = new Credit();
			CreditVO vo=credit.getCredit("151250058");
			System.out.println(vo.getCredit());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
        
	}
	
	
}
