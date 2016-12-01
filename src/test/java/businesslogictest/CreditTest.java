package businesslogictest;

	import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.creditbl.Credit;
import businesslogic.creditbl.CreditController;

	public class CreditTest {
		
		public CreditController controller;
		public String user_id;
		
		@Before
		public void init(){
		
			controller = new CreditController();
			user_id = "151250061";
		}
		
		/*
		@Test
		public void testgetCredit(){
			assertEquals(600, controller.getCredit(user_id).getCredit());
		}
		*/
		
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


