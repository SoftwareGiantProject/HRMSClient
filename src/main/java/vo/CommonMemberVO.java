package vo;

import util.MemberType;

public class CommonMemberVO {

	//普通会员等级
	int CommonMember_level; 
	
	//普通会员生日
	String CommonMember_Birthday;
	
	//普通会员编号
	String CommonMember_number;
	
	public void setCommonMember_level(int commonMember_level) {
		CommonMember_level = commonMember_level;
	}

	public void setCommonMember_Birthday(String commonMember_Birthday) {
		CommonMember_Birthday = commonMember_Birthday;
	}

	public void setCommonMember_number(String commonMember_number) {
		CommonMember_number = commonMember_number;
	}

	public void setMember_type(MemberType member_type) {
		Member_type = member_type;
	}

	//会员类型
	MemberType Member_type;
	
	
	public CommonMemberVO(int coml, String combir, String comn, MemberType mt){
		CommonMember_level = coml;
		CommonMember_Birthday = combir;
		CommonMember_number = comn;
		Member_type = mt;
	}
	
	public CommonMemberVO(){	
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
	
	public MemberType getMember_type(){
		return Member_type;
	}
}
