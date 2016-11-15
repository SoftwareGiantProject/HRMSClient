package businesslogictest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.MockHotel;
import businesslogic.orderbl.MockOrder;
import businesslogic.roombl.MockRoom;
import util.RoomConditon;

public class RoomTest {
	
	MockRoom ro;
	MockHotel mh;
	MockOrder mo;
	
	@Before
	public void setup(){
		double pr = 198;
		ro = new MockRoom("澶у簥鎴�", 1, pr, "101", RoomConditon.UNRESERVED, "hotel001");
		mh = new MockHotel("h001", "濡傚杩為攣閰掑簵", "鍗椾含甯傜Е娣尯鏂拌鍙�231鍙�", "绉︽樊鍖�", "XXXX", "XXXX", "澶у簥鎴匡紝鍗曚汉闂达紝鍙屼汉闂�");
		mo = new MockOrder();
	}

	@Test
	public void testgetRoom_type(){
		assertEquals("澶у簥鎴�", ro.getRoom_type());
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