package businesslogictest;
import businesslogic.orderbl.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.ListVO;

public class OrderTest {
	private MockOrder order;
	
	@Before
	public void setUp(){
		order=new MockOrder("151250034");
	}
	
	@Test
	public void testGetAllList(){
		assertEquals(null,order.getAllList());
	}

}
