package businesslogicservice.memberblservice;

import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class MemberBLService_Stub implements MemberBLService {

	 int CommonMember_level;
     int CorporateMember_level;

     String CommonMember_Birthday;
     String CorporateMember_Birthday;

     String CommonMember_number;
     String CorporateMember_number;

     String Corporate;


public MemberBLService_Stub(int coml, int corl, String combir, String corbir, String comn, String corn){
	        CommonMember_level = coml;
            CorporateMember_level = corl;
            
            CommonMember_Birthday = combir;
            CorporateMember_Birthday = corbir;
            
            CommonMember_number = comn;
            CorporateMember_number = corn;
}

public MemberBLService_Stub(int coml, int corl, String combir, String corbir, String comn, String corn, String cor){
	        CommonMember_level = coml;
            CorporateMember_level = corl;
            
            CommonMember_Birthday = combir;
            CorporateMember_Birthday = corbir;
            
            CommonMember_number = comn;
            CorporateMember_number = corn;

            Corporate = cor;
}

	@Override
	public String commonMemberCreateNumber(CommonMemberVO member) {
		// TODO Auto-generated method stub
		return CommonMember_number;
	}

	@Override
	public String corporateMemberCreateNumber(CorporateMemberVO member) {
		// TODO Auto-generated method stub
		return CorporateMember_number;
	}

	@Override
	public ResultMessage commonMemberRegister(String user_id, String birthday) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage corporateMemberRegister(String user_id, String corporate, String birthday) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getCommonMemberLevel(ClientVO client) {
		// TODO Auto-generated method stub
		return CommonMember_level;
	}

	@Override
	public int getCorporateMemberLevel(ClientVO client) {
		// TODO Auto-generated method stub
		return CorporateMember_level;
	}

	@Override
	public MemberType getMemberType(ClientVO client) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
