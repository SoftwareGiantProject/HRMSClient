
package businesslogic.memberbl;

import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class MockMember extends Member{
	
	 int CommonMember_level;
     int CorporateMember_level;

     String CommonMember_Birthday;
     String CorporateMember_Birthday;

     String CommonMember_number;
     String CorporateMember_number;

     String Corporate;
     MemberType Membertype;
     
     
     public MockMember(){
    	 
     }


     public MockMember(int coml, int corl, String combir, String corbir, String comn, String corn, MemberType mt){
	        CommonMember_level = coml;
            CorporateMember_level = corl;
            
            CommonMember_Birthday = combir;
            CorporateMember_Birthday = corbir;
            
            CommonMember_number = comn;
            CorporateMember_number = corn;
            Membertype = mt;
     }

     public MockMember(int coml, int corl, String combir, String corbir, String comn, String corn, String cor, MemberType mt){
	        CommonMember_level = coml;
            CorporateMember_level = corl;
            
            CommonMember_Birthday = combir;
            CorporateMember_Birthday = corbir;
            
            CommonMember_number = comn;
            CorporateMember_number = corn;

            Corporate = cor;
            Membertype = mt;
     }
     
     
 	public int getCommonMember_level(){
		return CommonMember_level;
	}
	
	public String getCommonMember_Birthday(){
		return CommonMember_Birthday;
	}
	
	public String getCommonMember_number(){
		return CommonMember_number;
	}
	
	
	
	public int getCorporateMember_level(){
		return CorporateMember_level;
	}
	
	public String getCorporateMember_Birthday(){
		return CorporateMember_Birthday;
	}
	
	public String getCorporateMember_number(){
		return CorporateMember_number;
	}
	
	public String getCorporate(){
		return Corporate;
	}
	
	
	
	public MemberType getMember_type(){
		return Membertype;
	}


     public String commonMemberCreateNumber(CommonMemberVO member) {
    	 
	     return CommonMember_number;
     }

     public String corporateMemberCreateNumber(CorporateMemberVO member) {
	
	     return CorporateMember_number;
     }


     public ResultMessage commonMemberRegister(String user_id, String birthday) {
	
	     return ResultMessage.SUCCESS;
     }


     public ResultMessage corporateMemberRegister(String user_id, String corporate, String birthday) {
	
	     return ResultMessage.SUCCESS;
     }


     public int getCommonMemberLevel(ClientVO client) {
	
	     return CommonMember_level;
     }


     public int getCorporateMemberLevel(ClientVO client) {
	
	     return CorporateMember_level;
     }


     public MemberType getMemberType(ClientVO client) {
	
	     return MemberType.COMMONMEMBER;
     }



	
}
