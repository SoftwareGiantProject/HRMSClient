package vo;

import java.io.Serializable;

public class MemberPromotionVO implements Serializable{
	
	//促销策略名称
	private String promotionName;
	//促销对象
	private static String promotionObject = "Member";
	//促销时间
	private String time;
	//折扣力度
	private double count;
	//商圈
	private String area;
	
	public MemberPromotionVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberPromotionVO(String name,String object,String time, double count,String area){
		this.area = area;
		this.count = count;
		this.promotionName = name;
		this.promotionObject = object;
		this.time = time;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public static String getPromotionObject() {
		return promotionObject;
	}

	public String getTime() {
		return time;
	}

	public double getCount() {
		return count;
	}

	public String getArea() {
		return area;
	}

	
}
