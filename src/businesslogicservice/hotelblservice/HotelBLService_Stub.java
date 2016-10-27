package businesslogicservice.hotelblservice;

import util.ResultMessage;
import vo.HotelVO;

public class HotelBLService_Stub implements HotelBLService{

	
	    //酒店名称
		String hotel_name;
		
		//酒店地址
		String hotel_address;
		
		//酒店所属商圈
		String hotel_area;
		
		//酒店简介
		String hotel_intro;
		
		//酒店设施服务
		String hotel_serve;
		
		//酒店客房类型
		String hotel_room;
		
		public HotelBLService_Stub(String hotel_name,String hotel_address,String hotel_area,String hotel_intro,
				String hotel_serve,String hotel_room){
			this.hotel_name = hotel_name;
			this.hotel_address = hotel_address;
			this.hotel_area = hotel_area;
			this.hotel_serve = hotel_serve;
			this.hotel_intro = hotel_intro;
			this.hotel_room = hotel_room;
		}
		
	@Override
	public HotelVO viewHotel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO seekHotel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evaluateHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
