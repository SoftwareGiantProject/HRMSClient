package businesslogicservice.memberblservice;

import vo.*;
import util.*;

public interface MemberBLService {

	public String commonMemberCreateNumber(CommonMemberVO member);
	public String corporateMemberCreateNumber(CorporateMemberVO member);
	
	public ResultMessage commonMemberRegister(String user_id,String birthday);
	public ResultMessage corporateMemberRegister(String user_id,String corporate,String birthday);
	
	public int getCommonMemberLevel(ClientVO client);
	public int getCorporateMemberLevel(ClientVO client);
}
