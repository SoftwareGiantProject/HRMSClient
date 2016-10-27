package po;

public class CorporateMemberPO {

	int CorporateMember_level;
	String CorporateMember_Birthday;
	String CorporateMember_number;
	String Corporate;
	
	
	public CorporateMemberPO(int corl, String corbir, String corn, String cor){
		CorporateMember_level = corl;
		CorporateMember_Birthday = corbir;
		CorporateMember_number = corn;
		Corporate = cor;
	}
	
	public void setCorporateMember_level(int corl){
		this.CorporateMember_level = corl;
	}
	public void setCorporateMember_Birthday(String corbir){
		this.CorporateMember_Birthday = corbir;
	}
	public void setCorporateMember_number(String corn){
		this.CorporateMember_number = corn;
	}
	public void setCorporate(String cor){
		this.Corporate = cor;
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


}
