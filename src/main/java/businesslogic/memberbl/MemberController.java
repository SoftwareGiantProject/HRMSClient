
package businesslogic.memberbl;

import businesslogicservice.memberblservice.MemberBLService;
import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class MemberController implements MemberBLService{
	
	Member member;
	
	public MemberController() {
		member = new Member();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage regieterComMember(String birthday, String user_id) {
		// TODO Auto-generated method stub
		return member.regieterComMember(birthday, user_id);
	}

	@Override
	public ResultMessage registerCorMember(String birthday, String user_id, String corporate) {
		// TODO Auto-generated method stub
		return member.registerCorMember(birthday, user_id, corporate);
	}


	

}
