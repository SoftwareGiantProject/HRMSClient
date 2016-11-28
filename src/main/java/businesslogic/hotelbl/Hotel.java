package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import dataservice.datafactoryservice.DatafactoryImpl;
import po.HotelEvaluationPO;
import po.HotelPO;
import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class Hotel {
	
	
	public HotelVO viewHotel(String name){
		
		HotelVO result = seekHotel(name);
		return result;
	}
	
	public ArrayList<HotelVO> viewHistoryHotel(){
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		
		try {
			ArrayList<HotelPO> list2 = DatafactoryImpl.getInstance().getHotelData().viewHistoryHotel();
			for(HotelPO lis : list2){
				list.add(PoToVo(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}
	
	public HotelVO seekHotel(String name){
		HotelPO po = new HotelPO();
		String hotel_name = name;
		
		try{
			po = DatafactoryImpl.getInstance().getHotelData().seekHotel(hotel_name);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		HotelVO vo = new HotelVO(po.getHotelId(), po.getHotelName(), po.getHotelAddress(), po.getHotelArea(), po.getHotelIntro(), po.getHotelServe(), po.getHotelRoom());
		
		
		return vo;
	}
	
	public ResultMessage addHotel(HotelVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		HotelVO hotelvo = vo;
		HotelPO po = new HotelPO();
		po.setHotelId(hotelvo.getHotelId());
		po.setHotelName(hotelvo.getHotelName());
		po.setHotelAddress(hotelvo.getHotelAddress());
		po.setHotelArea(hotelvo.getHotelArea());
		po.setHotelIntro(hotelvo.getHotelIntro());
		po.setHotelServe(hotelvo.getHotelServe());
		po.setHotelRoom(hotelvo.getHotelRoom());
		
		try{
			result = DatafactoryImpl.getInstance().getHotelData().addHotel(po);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultMessage modifyHotel(HotelVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getHotelData().modifyHotel(VoToPo(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	
	public ResultMessage evaluateHotel(HotelEvaluationVO vo){
		ResultMessage result = ResultMessage.FAIL;
		HotelEvaluationVO evaluate = vo;
		
		try {
			result = DatafactoryImpl.getInstance().getHotelData().evaluateHotel(VoToPo1(evaluate));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public HotelVO PoToVo(HotelPO po) {
		HotelVO result = new HotelVO(po.getHotelId(), po.getHotelName(), po.getHotelAddress(), po.getHotelArea(), po.getHotelIntro(), po.getHotelServe(), po.getHotelRoom());
		return result;
	}
	
	public HotelPO VoToPo(HotelVO vo){
		HotelPO result = new HotelPO(vo.getHotelId(), vo.getHotelName(), vo.getHotelAddress(), vo.getHotelArea(), vo.getHotelIntro(), vo.getHotelServe(), vo.getHotelRoom());
		return result;
	}
	
	public HotelEvaluationPO VoToPo1(HotelEvaluationVO vo){
		HotelEvaluationPO result = new HotelEvaluationPO(vo.getOrder_id(), vo.getUser_id(), vo.getDate(), vo.getData(), vo.getLevel());
		return result;
	}
	
	
}
