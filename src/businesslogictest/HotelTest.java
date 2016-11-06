package businesslogictest;

import businesslogic.hotelbl.*;
import businesslogic.userbl.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HotelTest {

	private MockHotel hotel;
	private MockClient client;
	
	@Before
	public void setUp(){
		client = new MockClient("c001","Tony","158xxxx0061","thisIsPassword","1997-5-29");
		hotel = new MockHotel("h001","��������Ƶ�","�Ͼ����ػ����½ֿ�231��","�ػ���","XXXX","XXXX","�󴲷������˼䣬˫�˼�");
	}
	
	@Test
	public void testGetClientBirthday(){
		assertEquals("1997-5-29",client.getClientBirthday("c001"));
	}
}
