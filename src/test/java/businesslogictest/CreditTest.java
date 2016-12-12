package businesslogictest;

	import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.creditbl.Credit;
import businesslogic.creditbl.CreditController;

	public class CreditTest {
		
		public CreditController controller;
		public String user_id;
		
		@Before
		public void init() throws RemoteException{
		
			controller = (CreditController) ControllerFactory.getCreditBLServiceInstance();
			user_id = "151250061";
		}
		
		
		@Test
		public void testgetCredit(){
			assertEquals(1450, controller.getCredit(user_id).getCredit());
		}
		
		/*
		@Test
		public void testdeposit(){
			controller.deposit(user_id,10);
			assertEquals(1550, controller.getCredit(user_id).getCredit());
		}
		*/
		
		/*
		@Test
		public void testdeduct(){
			controller.deduct(user_id, 100);
			assertEquals(1450, controller.getCredit(user_id).getCredit());
		}
		*/

	}


