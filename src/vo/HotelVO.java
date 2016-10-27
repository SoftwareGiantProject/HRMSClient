package vo;

public class HotelVO {

	//�Ƶ�����
	String hotel_name;
	
	//�Ƶ��ַ
	String hotel_address;
	
	//�Ƶ�������Ȧ
	String hotel_area;
	
	//�Ƶ���
	String hotel_intro;
	
	//�Ƶ���ʩ����
	String hotel_serve;
	
	//�Ƶ�ͷ�����
	String hotel_room;
	
	
	public HotelVO(String hotel_name,String hotel_address,String hotel_area,String hotel_intro,
			String hotel_serve,String hotel_room){
		this.hotel_address = hotel_address;
		this.hotel_area = hotel_area;
		this.hotel_intro = hotel_intro;
		this.hotel_name = hotel_name;
		this.hotel_room = hotel_room;
		this.hotel_serve = hotel_serve;
	}
	
	public String getHotelName(){
		return hotel_name;
	}
	
	public String getHotelAddress(){
		return hotel_address;
	}
	
	public String getHotelArea(){
		return hotel_area;
	}
	
	public String getHotelIntro(){
		return hotel_intro;
	}
	
	public String getHotelRoom(){
		return hotel_room;
	}
	
	public String getHotelServe(){
		return hotel_serve;
	}

	public HotelVO(){
		
	}
}
