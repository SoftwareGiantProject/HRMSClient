package businesslogictest;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.memberbl.MockMember;
import businesslogic.userbl.MockClient;
import util.MemberType;

public class MemberTest {
	
	private MockMember com;
	private MockMember cor;
	private MockClient cli;
	
	@Before
	public void setup(){
		com = new MockMember(0, "1998/11/11", "151250001", MemberType.COMMONMEMBER);
		cor = new MockMember(1, "1997/11/11", "151250002", "hanting", MemberType.CORPORATEMEMBER);
		cli = new MockClient("151250001", "lyp", "15850786333", "1997/11/11", "123456");
	}
	
	@Test
	public void tsetGetCommonMemberLevel(){
		assertEquals(0, com.getCommonMember_level());
	}
	
	@Test
	public void testgetCommonMember_Birthday(){
		assertEquals("1998/11/11", com.getCommonMember_Birthday());
	}
	
	@Test
	public void tsetGetCorporateMemberLevel(){
		assertEquals(1, cor.getCorporateMember_level());
	}
	
	@Test
	public void testgetCorporateMember_Birthday(){
		assertEquals("1997/11/11", cor.getCorporateMember_Birthday());
	}
	
	@Test
	public void testgetCommonMember_number(){
		assertEquals("151250001", com.getCommonMember_number());
	}
	
	@Test
	public void testgetCorporateMember_number(){
		assertEquals("151250002", cor.getCorporateMember_number());
	}
	
	@Test
	public void testgetMember_type(){
		assertEquals(MemberType.COMMONMEMBER, com.getMember_type());
	}
	
	@Test
	public void testGetMember_type(){
		assertEquals(MemberType.CORPORATEMEMBER, cor.getMember_type());
	}
	

}
