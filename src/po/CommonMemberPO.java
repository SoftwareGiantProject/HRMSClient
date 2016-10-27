package po;

public class CommonMemberPO {

	int CommonMember_level;
	String CommonMember_Birthday;
	String CommonMember_number;
	
	
	public CommonMemberPO(int coml, String combir, String comn){
		CommonMember_level = coml;
		CommonMember_Birthday = combir;
		CommonMember_number = comn;
	}
	
	public void setCommonMember_level(int coml){
		this.CommonMember_level = coml;
	}
	public void setCommonMember_Birthday(String combir){
		this.CommonMember_Birthday = combir;
	}
	public void setCommonMember_number(String comn){
		this.CommonMember_number = comn;
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

}
