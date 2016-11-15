package businesslogictest;

import businesslogic.memberbl.MockMember;
import businesslogic.promotionbl.*;
import util.MemberType;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PromotionTest {

	private MockPromotion promotion1;
	private MockMember member1;
	private MockMember member2;
	private MockPromotion promotion2;
	
	@Before
	public void setUp(){
		promotion1 = new MockPromotion("双十一促销","全体用户",8,"2016-11-11");
	    member1 = new MockMember(3,"1997-5-29","151250061",MemberType.COMMONMEMBER);
	    member2 = new MockMember(3,"1997-5-30","151240061","Tencent",MemberType.CORPORATEMEMBER);
	    
	}
	
	
	@Test
	public void testGetPromotion(){
		assertEquals("双十一促销",promotion1.getName());
	}
	
	@Test
	public void testGetCommonMemberBirthday(){
        assertEquals("1997-5-29",member1.getCommonMember_Birthday());
	}
	
	@Test
	public void testGetCorporateMemberBirthday(){
		assertEquals("1997-5-30",member2.getCorporateMember_Birthday());
	}
}
