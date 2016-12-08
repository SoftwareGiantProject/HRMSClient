package businesslogictest;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.client.ClientController;

public class ClientTest {

	private ClientController controller;
	
	@Before
	public void init(){
		controller = new ClientController();
	}

	@Test
	public void testRegist(){
		
	}
}
