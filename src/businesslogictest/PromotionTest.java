package businesslogictest;

import businesslogic.promotionbl.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PromotionTest {

	private MockPromotion promotion;
	
	
	@Before
	public void setUp(){
		promotion = new MockPromotion("双十一促销","全体用户",8,"2016-11-11");
	}
	
	
	@Test
	public void testGetPromotion(){
		assertEquals("双十一促销",promotion.getName());
	}
}
