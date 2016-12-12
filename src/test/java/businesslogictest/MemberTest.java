package businesslogictest;

import java.rmi.RemoteException;

import javax.activation.DataContentHandler;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.memberbl.MemberController;

public class MemberTest {

	MemberController controller;
	
	@Before
	public void init() throws RemoteException{
		controller =  (MemberController) ControllerFactory.getMemberBLServiceInstance();
	}
	
	
	@Test
	public void testRegisterComMember(){
		String birthday = "1997-05-29";
		String id = "151250061";
		
		try {
			controller.registerComMember(birthday, id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	@Test
	public void testRegisterCorMember(){
		String birthday = "1997-10-03";
		String id = "151250060";
		String cor = "Tencent";
		
		try {
			controller.registerCorMember(birthday, id, cor);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}


