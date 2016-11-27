package businesslogicservice.hotelblservice;

import java.util.ArrayList;
import java.util.List;

import util.ResultMessage;
import vo.HotelVO;
import vo.HotelEvaluationVO;

public class HotelBLService_Stub implements HotelBLService{

	
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
	public ResultMessage evaluateHotel(HotelEvaluationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> viewHistoryHotel() {
		// TODO Auto-generated method stub
		return null;
	}

}
