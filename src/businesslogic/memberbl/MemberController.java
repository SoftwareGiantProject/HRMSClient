
package businesslogic.memberbl;

import businesslogicservice.memberblservice.MemberBLService;
import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class MemberController implements MemberBLService{
	
	MockMember Member = new MockMember();

	@Override
	public String commonMemberCreateNumber(CommonMemberVO member) {
		return Member.commonMemberCreateNumber(member);
	}

	@Override
	public String corporateMemberCreateNumber(CorporateMemberVO member) {
		return Member.corporateMemberCreateNumber(member);
	}

	@Override
	public ResultMessage commonMemberRegister(String user_id, String birthday) {
		return Member.commonMemberRegister(user_id, birthday);
	}

	@Override
	public ResultMessage corporateMemberRegister(String user_id, String corporate, String birthday) {
		return Member.corporateMemberRegister(user_id, corporate, birthday);
	}

	@Override
	public int getCommonMemberLevel(ClientVO client) {
		return Member.getCommonMemberLevel(client);
	}

	@Override
	public int getCorporateMemberLevel(ClientVO client) {
		return Member.getCorporateMemberLevel(client);
	}

	@Override
	public MemberType getMemberType(ClientVO client) {
		return Member.getMemberType(client);
	}

}
