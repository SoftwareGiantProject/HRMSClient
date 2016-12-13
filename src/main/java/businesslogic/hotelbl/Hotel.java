package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import dataservice.datafactory.DatafactoryImpl;
import po.HotelEvaluationPO;
import po.HotelPO;
import po.RoomPO;
import util.ResultMessage;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class Hotel {

	/**
	 * 通过酒店id返回酒店名称
	 * @param hotel_id
	 * @return
	 */
	public String getHotelNameById(String hotel_id){
		String hotel_name = "";
		ArrayList<HotelVO> list = viewAllHotel();
		for(HotelVO lis : list){
			if(lis.getHotelId().equals(hotel_id)){
				return lis.getHotelName();
			}
		}
		
		return hotel_name;
		
	}

	/**
	 * 
	 * @param area 商圈
	 * @return 该商圈的所有酒店
	 */
	public ArrayList<HotelVO> getHotelByArea(String area){
		ArrayList<HotelPO> list = new ArrayList<>();
		ArrayList<HotelVO> result = new ArrayList<>();
		try {
			list = DatafactoryImpl.getInstance().getHotelData().getHotelByArea(area);
			for(HotelPO lis : list){
				result.add(PoToVo(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/*
	 * 调用了roomdata的内容
	 * */
	/**
	 * 
	 * @param area 商圈
	 * @return 对商圈酒店价格从低到高排序的结果
	 */
	public ArrayList<HotelVO> getHotelByPrice(String area){
		ArrayList<HotelVO> list = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		ArrayList<RoomPO> temp = new ArrayList<>();
		ArrayList<RoomPO> contain = new ArrayList<>(); 
		
		
		
			try {
				for(HotelVO lis : list){
					temp = DatafactoryImpl.getInstance().getRoomData().getAllRoom(lis.getHotelId());     //获得一个酒店的所有房间
					contain.add(getCheapestPrice(temp));  //获得一个酒店房间价格最便宜的房间po
					}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		int price[] = new int [contain.size()];
			for(int i = 0; i < contain.size(); i++){
				price[i] = contain.get(i).getRoom_price();
			}
			
			int rank[] = getRank_int(price);
			
			for(int i = 0; i < contain.size(); i++){
				for(int j = 0; j < contain.size(); j++){
					if(rank[j] == i){
						result.add(list.get(j));
					}
				}
			}
			
			return result;
		
	}
	
	/**
	 * 
	 * @param area 商圈
	 * @return 对该商圈酒店评分从高到低排序的结果
	 */
	public ArrayList<HotelVO> getHotelBylevel(String area){
		ArrayList<HotelVO> list = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		double level[] = new double[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			level[i] = list.get(i).getHotel_score();
		}
		
		int rank[] = getRank_double(level);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(rank[j] == list.size()-1-i){
					result.add(list.get(j));
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param area 商圈
	 * @return 对该商圈酒店按照星级从高到低排序的结果
	 */
	public ArrayList<HotelVO> getHotelByStar(String area){
		ArrayList<HotelVO> list = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		int star[] = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			star[i] = list.get(i).getHotel_level();
		}
		int rank[] = getRank_int(star);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(rank[j] == list.size()-1-i){
					result.add(list.get(j));
				}
			}
		}
		return result;
		
	}
	
	public int[] getRank_double(double []a){
		int n = a.length;
		int result[] = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = 0;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j){
					continue;
				}
				if(a[i] > a[j]){
					++result[i];
				}
			}
		}
		return result;		
	}
	
	public int[] getRank_int(int []a){
		int n = a.length;
		int result[] = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = 0;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j){
					continue;
				}
				if(a[i] > a[j]){
					++result[i];
				}
			}
		}
		return result;		
	}
	
	/**
	 * 
	 * @param room ArrayList<RoomPO>
	 * @return ArrayList<RoomPO>里面价格最低的RoomPO
	 */
	public RoomPO getCheapestPrice(ArrayList<RoomPO> room){
		if(room.isEmpty()){
			return null;
		}
		int location = 0;
		int judge = room.get(0).getRoom_price();
		for(int i = 1; i < room.size(); i++){
			if(room.get(i).getRoom_price() < judge){
				location = i;
				judge = room.get(i).getRoom_price();
			}
		}
		return room.get(location);

	}
	
	/**
	 * 
	 * @param name 酒店名称
	 * @return 该酒店信息
	 */
	public HotelVO viewHotel(String name){
		
		HotelVO result = seekHotel(name);
		return result;
	}
	
	/**
	 * 
	 * @return 所有的城市
	 */
	public ArrayList<String> getAllCity(){
		ArrayList<String> result = new ArrayList<>();
		
		try {
			result = DatafactoryImpl.getInstance().getHotelData().getAllCity();
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param city
	 * @return 返回该城市的所有商圈
	 */
	public ArrayList<String> getAllAreaByCity(String city){
		ArrayList<String> result = new ArrayList<>();
		
		try {
			result = DatafactoryImpl.getInstance().getHotelData().getAllAreaByCity(city);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return 所有的酒店
	 */
	public ArrayList<HotelVO> viewAllHotel(){
		ArrayList<HotelVO> list = new ArrayList<HotelVO>();
		
		try {
			ArrayList<HotelPO> list2 = DatafactoryImpl.getInstance().getHotelData().getAllHotels();
			for(HotelPO lis : list2){
				list.add(PoToVo(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param area 商圈
	 * @param room 房间类型
	 * @param star 星级
	 * @param lowscore 最低分
	 * @param highscore 最高分
	 * @param lowprice 最低价格
	 * @param highprice 最高价格
	 * @return 符合所有条件的该商圈的所有酒店
	 */
	public ArrayList<HotelVO> search(String area, String room, int star, int lowscore, int highscore, int lowprice, int highprice){
		ArrayList<HotelVO> result = new ArrayList<>();
		ArrayList<HotelVO> 	temp1 = new ArrayList<>();
		ArrayList<HotelVO> 	temp2 = new ArrayList<>();
		ArrayList<HotelVO> 	temp3 = new ArrayList<>();
		ArrayList<HotelVO> 	temp4 = new ArrayList<>();
		int judge[] = new int[4];
		for(int i = 0; i < 4; i++){
			judge[i] = 0;
		}
		if(room != null){
			temp1 = searchByRoom(area, room);
			if(temp1.isEmpty()){
				return null;
			}else {
				judge[0] = 1;
			}
		}
		if(star != -1){
			temp2 = searchByStar(area, star);
			if(temp2.isEmpty()){
				return null;
			}else {
				judge[1] = 1;
			}
		}
		if(lowscore != -1){
			temp3 = searchByScore(area, lowscore, highscore);
			if(temp3.isEmpty()){
				return null;
			}else {
				judge[2] = 1;
			}
		}
		if(lowprice != -1){
			temp4 = searchByPrice(area, lowprice, highprice);
			if(temp4.isEmpty()){
				return null;
			}else {
				judge[3] = 1;
			}
		}
		
		for(int i = 0; i < 4; i++){
			if(judge[i] == 1){
				if(result.isEmpty()){
					switch (i) {
					case 0: result = temp1;
					case 1: result = temp2;
					case 2: result = temp3;
					case 3: result = temp4;
						break;
					}
				}else {
					switch (i) {
					case 0: result = combine(result, temp1);
					case 1: result = combine(result, temp2);
					case 2: result = combine(result, temp3);
					case 3: result = combine(result, temp4);
						break;
				}
			}
		}
	  }
		
		return result;
		
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return a、b中相同的hotel
	 */
	public ArrayList<HotelVO> combine(ArrayList<HotelVO> a, ArrayList<HotelVO> b){
		ArrayList<HotelVO> result = new ArrayList<>();
		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < b.size(); j++){
				if(a.get(i).equals(b.get(j))){
					result.add(a.get(i));
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param area 商圈
	 * @param room 房间类型
	 * @return 该商圈有该房间类型的所有酒店
	 */
	public ArrayList<HotelVO> searchByRoom(String area, String room){
		ArrayList<HotelVO> total = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		
		for(int i = 0; i < total.size(); i++){
			String temp[] = total.get(i).getHotelRoom().split("，");
			for(int j = 0; j < temp.length; j++){
				if(room.equals(temp[j])){
					result.add(total.get(i));
					continue;
				}
			}
		}
		
		return result;
	}
	/**
	 * 
	 * @param area 商圈
	 * @param star 星级
	 * @return 该商圈所有该星级的酒店
	 */
	public ArrayList<HotelVO> searchByStar(String area, int star){
		ArrayList<HotelVO> total = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		
		for(int i = 0; i < total.size(); i++){
			if(star == total.get(i).getHotel_level()){
				result.add(total.get(i));
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param area 商圈
	 * @param lowscore 最低评分
	 * @param highscore 最高评分
	 * @return 该商圈，在该评分区间的所有酒店
	 */
	public ArrayList<HotelVO> searchByScore(String area, int lowscore, int highscore){
		ArrayList<HotelVO> total = getHotelByArea(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		double score = 0;
		for(int i = 0; i < total.size(); i++){
			score = total.get(i).getHotel_score();
			if(score >= lowscore && score <= highscore){
				result.add(total.get(i));
			}
		}
		return result;
	}
	
	//调用了roomdata的内容
	/**
	 *  
	 * @param area 商圈
	 * @param lowprice 最低价格
	 * @param highprice 最高价格
	 * @return 该商圈在该价格区间的所有酒店
	 */
	public ArrayList<HotelVO> searchByPrice(String area, int lowprice, int highprice){
		ArrayList<HotelVO> total = getHotelByPrice(area);
		ArrayList<HotelVO> result = new ArrayList<>();
		int price[] = new int [total.size()];
		for(int i = 0; i < total.size(); i++){
			price[i] = 0;
		}
		ArrayList<RoomPO> temp = new ArrayList<>();
		try {
			for(int i = 0; i < total.size(); i++){
				temp = DatafactoryImpl.getInstance().getRoomData().getAllRoom(total.get(i).getHotelId());
				price[i] = getCheapestPrice(temp).getRoom_price();
				if(price[i] >= lowprice && price[i] <= highprice){
					result.add(total.get(i));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
		
		
	}
		

	
	/**
	 * 
	 * @param name 酒店名称
	 * @return 该酒店的信息
	 */
	public HotelVO seekHotel(String name){
		HotelPO po = new HotelPO();
		String hotel_name = name;
		
		try{
			po = DatafactoryImpl.getInstance().getHotelData().seekHotel(hotel_name);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		HotelVO vo = new HotelVO(po.getHotelId(), po.getHotelName(), po.getHotelAddress(), po.getHotelArea(), po.getHotelLevel(), po.getHotelScore(),po.getHotelIntro(), po.getHotelServe(), po.getHotelRoom(), po.getCity());
		return vo;
	}
	
	/**
	 * 
	 * @param vo 酒店信息
	 * @return 添加酒店的结果
	 */
	public ResultMessage addHotel(HotelVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		HotelVO hotelvo = vo;
		
		ArrayList<HotelPO> list = new ArrayList<>();
		//酒店id已存在
		try{
			list = DatafactoryImpl.getInstance().getHotelData().getAllHotels();
			for(HotelPO lis : list){
				if(hotelvo.getHotelId().equals(lis.getHotelId())){
					return ResultMessage.EXIST;
				}
			}
			result = DatafactoryImpl.getInstance().getHotelData().addHotel(VoToPo(hotelvo));
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param user_id 客户编号
	 * @return 该客户预定过的酒店
	 */
	public ArrayList<HotelVO> viewReservedHotel(String user_id){
		ArrayList<HotelVO> result = new ArrayList<>();
		ArrayList<HotelPO> list = new ArrayList<>();
		
		try {
			list = DatafactoryImpl.getInstance().getHotelData().getReservedHotel(user_id);
			for(HotelPO lis : list){
				result.add(PoToVo(lis));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	/**
	 * 
	 * @param vo 酒店信息
	 * @return 修改酒店信息结果
	 */
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
	
	/**
	 * 
	 * @param vo HotelEvaluation
	 * @param hotel_name 酒店名称
	 * @return 评价结果
	 */
	public ResultMessage evaluateHotel(HotelEvaluationVO vo, String hotel_name){
		ResultMessage result = ResultMessage.FAIL;
		String name = hotel_name;
		ArrayList<HotelEvaluationPO> list = new ArrayList<>();
		int lastLevel = 0;
		int temp = 0;
		
		try {
			list = DatafactoryImpl.getInstance().getHotelData().getAllHotelEvaluation(name);
			for(int i = 0; i < list.size(); i++){
				temp += list.get(i).getLevel();
			}
			lastLevel = (temp + vo.getLevel()) / (list.size()+1);  //求平均值
			HotelPO po = DatafactoryImpl.getInstance().getHotelData().seekHotel(name);
			po.setHotelScore(lastLevel);
			result = DatafactoryImpl.getInstance().getHotelData().modifyHotel(po);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public HotelVO PoToVo(HotelPO po) {
		HotelVO result = new HotelVO(po.getHotelId(), po.getHotelName(), po.getHotelAddress(), po.getHotelArea(), po.getHotelLevel(), po.getHotelScore(), po.getHotelIntro(), po.getHotelServe(), po.getHotelRoom(), po.getCity());
		return result;
	}
	
	public HotelPO VoToPo(HotelVO vo){
		HotelPO result = new HotelPO(vo.getHotelId(), vo.getHotelName(), vo.getHotelAddress(), vo.getHotelArea(), vo.getHotel_level(), vo.getHotel_score(), vo.getHotelIntro(), vo.getHotelServe(), vo.getHotelRoom(), vo.getCity());
		return result;
	}
	
	public HotelEvaluationPO VoToPo1(HotelEvaluationVO vo){
		HotelEvaluationPO result = new HotelEvaluationPO(vo.getOrder_id(), vo.getUser_id(), vo.getDate(), vo.getData(), vo.getLevel());
		return result;
	}
	
	
}
