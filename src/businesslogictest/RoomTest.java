package businesslogictest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.RoomConditon;

public class RoomTest {
	
	MockRoom ro;
	MockHotel mh;
	MockOrder mo;
	
	@Before
	public void setup(){
		double pr = 198;
		ro = new MockRoom("大床房", 1, pr, "101", RoomConditon.UNRESERVED, "hotel001");
		mh = new MockHotel("h001", "如家连锁酒店", "南京市秦淮区新街口231号", "秦淮区", "XXXX", "XXXX", "大床房，单人间，双人间");
		mo = new MockOrder();
	}

	@Test
	public void testgetRoom_type(){
		assertEquals("大床房", ro.getRoom_type());
	}
	
	@Test
	public void testgetRoom_num(){
		assertEquals(1, ro.getRoom_num());
	}
	
    @Test
    public void testgetRoom_Condition(){
    	assertEquals(RoomConditon.UNRESERVED, ro.getRoom_condition());
    }
    
    @Test
    public void testgetHotel_id(){
    	assertEquals("hotel001", ro.getHotel_id());
    }
	
	
	

}