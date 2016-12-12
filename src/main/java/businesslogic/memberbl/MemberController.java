
package businesslogic.memberbl;

import java.rmi.RemoteException;

import businesslogicservice.memberblservice.MemberBLService;
import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class MemberController implements MemberBLService{
	
	Member member;
	
	public MemberController() throws RemoteException {
		member = new Member();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage registerComMember(String birthday, String user_id) throws RemoteException {
		// TODO Auto-generated method stub
		return member.registerComMember(birthday, user_id);
	}

	@Override
	public ResultMessage registerCorMember(String birthday, String user_id, String corporate) throws RemoteException {
		// TODO Auto-generated method stub
		return member.registerCorMember(birthday, user_id, corporate);
	}


	

}
