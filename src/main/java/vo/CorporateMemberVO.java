package vo;

import util.MemberType;

public class CorporateMemberVO {

	//企业会员等级
	int CorporateMember_level;
	
	//企业会员生日
	String CorporateMember_Birthday;
	
	//企业会员编号
	String CorporateMember_number;
	
	//企业名称
	String Corporate;
	
	public void setCorporateMember_level(int corporateMember_level) {
		CorporateMember_level = corporateMember_level;
	}

	public void setCorporateMember_Birthday(String corporateMember_Birthday) {
		CorporateMember_Birthday = corporateMember_Birthday;
	}

	public void setCorporateMember_number(String corporateMember_number) {
		CorporateMember_number = corporateMember_number;
	}

	public void setCorporate(String corporate) {
		Corporate = corporate;
	}

	public void setMember_type(MemberType member_type) {
		Member_type = member_type;
	}

	//会员类型
	MemberType Member_type;
	
	
	public CorporateMemberVO(int corl, String corbir, String corn, String cor, MemberType mt){
		CorporateMember_level = corl;
		CorporateMember_Birthday = corbir;
		CorporateMember_number = corn;
		Corporate = cor;
		Member_type = mt;
	}
	
	public CorporateMemberVO(){
		
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
	
	public MemberType getMember_Type(){
		return Member_type;
	}
	
}

