package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.roombl.RoomController;
import dataservice.datafactory.DatafactoryImpl;
import po.HotelEvaluationPO;
import po.HotelPO;
import po.RoomPO;
import util.ResultMessage;
import util.RoomCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RoomVO;

public class Hotel {
	
	
	private RoomController roomController;
	
	public Hotel() throws RemoteException{
		roomController = (RoomController) ControllerFactory.getRoomBLServiceInstance();
	}

	/**
	 * 通过酒店id返回酒店名称
	 * @param hotel_id
	 * @return
	 */
	public String getHotelNameById(String hotel_id){
		String hotel_name = " ";
		ArrayList<HotelVO> list = viewAllHotel();
		for(HotelVO lis : list){
			if(lis.getHotelId().get().equals(hotel_id)){
				hotel_name = lis.getHotelName().get();
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
		ArrayList<RoomVO> temp = new ArrayList<>();
		ArrayList<RoomVO> contain = new ArrayList<>(); 
		
		for(HotelVO lis : list){
			temp = roomController.getAllRoomByHotel(lis.getHotelId().get());
			contain.add(getCheapestPrice(temp));  //获得一个酒店房间价格最便宜的房间po
			}
		
		int price[] = new int [contain.size()];
			for(int i = 0; i < contain.size(); i++){
				price[i] = contain.get(i).getRoomPrice().get();
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
			level[i] = list.get(i).getHotel_score().get();
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
			star[i] = list.get(i).getHotel_level().get();
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
	
	private int[] getRank_double(double []a){
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
	
	private int[] getRank_int(int []a){
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
	 * @param room ArrayList<RoomVO>
	 * @return ArrayList<RoomVO>里面价格最低的RoomVO
	 */
	private RoomVO getCheapestPrice(ArrayList<RoomVO> room){
		if(room.isEmpty()){
			return null;
		}
		int location = 0;
		int judge = room.get(0).getRoomPrice().get();
		for(int i = 1; i < room.size(); i++){
			if(room.get(i).getRoomPrice().get() < judge){
				location = i;
				judge = room.get(i).getRoomPrice().get();
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
	public ArrayList<HotelVO> search(String area, String room, int star, int lowscore, int highscore, int lowprice, int highprice, Boolean reserved, String client_id){
		ArrayList<HotelVO> result = getHotelByArea(area);
		ArrayList<HotelVO> 	temp1 = new ArrayList<>();
		ArrayList<HotelVO> 	temp2 = new ArrayList<>();
		ArrayList<HotelVO> 	temp3 = new ArrayList<>();
		ArrayList<HotelVO> 	temp4 = new ArrayList<>();
		if(reserved){
			result = viewReservedHotel(client_id);
		}

		int judge[] = new int[4];
		for(int i = 0; i < 4; i++){
			judge[i] = 0;
		}
		if(room != null){
			temp1 = searchByRoom(area, room);
			if(temp1.isEmpty()){
				return temp1;
			}else {
				judge[0] = 1;
			}
		}
		if(star != -1){
			temp2 = searchByStar(area, star);
			if(temp2.isEmpty()){
				return temp2;
			}else {
				judge[1] = 1;
			}
		}
		if(lowscore != -1){
			temp3 = searchByScore(area, lowscore, highscore);
			if(temp3.isEmpty()){
				return temp3;
			}else {
				judge[2] = 1;
			}
		}
		if(lowprice != -1){
			temp4 = searchByPrice(area, lowprice, highprice, room);
			if(temp4.isEmpty()){
				return temp4;
			}else {
				judge[3] = 1;
			}
		}
		
		for(int i = 0; i < 4; i++){
			if(judge[i] == 1){
					switch (i) {
					case 0: result = combine(result, temp1);break;
					case 1: result = combine(result, temp2);break;
					case 2: result = combine(result, temp3);break;
					case 3: result = combine(result, temp4);break;
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
	private ArrayList<HotelVO> combine(ArrayList<HotelVO> a, ArrayList<HotelVO> b){
		ArrayList<HotelVO> result = new ArrayList<>();
		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < b.size(); j++){
				if(a.get(i).getHotelId().get().equals(b.get(j).getHotelId().get())){
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
			String temp[] = total.get(i).getHotelRoom().get().split("，");
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
			if(star == total.get(i).getHotel_level().get()){
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
			score = total.get(i).getHotel_score().get();
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
	public ArrayList<HotelVO> searchByPrice(String area, int lowprice, int highprice, String room){
		ArrayList<HotelVO> total = new ArrayList<>();
		if(room.equals(null)){
			total = getHotelByPrice(area);
		}else {
			total = searchByRoom(area, room);
		}
		ArrayList<HotelVO> result = new ArrayList<>();
		int price[] = new int [total.size()];
		for(int i = 0; i < total.size(); i++){
			price[i] = 0;
		}

		ArrayList<RoomVO> temp = new ArrayList<>();

		for(int i = 0; i < total.size(); i++){
			if(room.equals(null)){
				temp = roomController.getAllRoomByHotel(total.get(i).getHotelId().get());
			}else{
				temp = roomController.findRooms(total.get(i).getHotelId().get(), room);
			}
			for(int j = 0; j < temp.size(); j++){
				if(temp.get(j).getRoomPrice().get() >= lowprice && temp.get(j).getRoomPrice().get() <= highprice){
					result.add(total.get(i));
					continue;
				}
			}
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
		
		//检查订单是否已被评价
		ArrayList<HotelEvaluationPO> evalist = new ArrayList<>();
		try {
			evalist = DatafactoryImpl.getInstance().getHotelData().getAllHotelEvaluation(hotel_name);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(HotelEvaluationPO po : evalist){
			if(po.getOrder_id().equals(vo.getOrder_id())){
				return ResultMessage.HASEVALUATED;
			}
		}
		
		try {
			DatafactoryImpl.getInstance().getHotelData().evaluateHotel(VoToPo1(vo));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
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
	
	
	/**
	 * 判断一个酒店是否曾经预定过
	 * @param vo
	 * @param client_id
	 * @return
	 */
	public ResultMessage judgeReserved(String hotel_id, String client_id) {
		ArrayList<HotelVO> list = new ArrayList<>();
		list = viewReservedHotel(client_id);
		for(HotelVO temp : list){
			if(temp.getHotelId().get() .equals(hotel_id)){
				return ResultMessage.RESERVED;
			}
		}
		return ResultMessage.UNRESERVED;
	}
	
	/**
	 * 判断一个酒店是否有空房
	 * @param vo
	 * @return
	 */
	public ResultMessage judgeHasRoom(String hotel_id) {
		ArrayList<RoomVO> list = new ArrayList<>();
		
		try {
			list = ControllerFactory.getRoomBLServiceInstance().getAllRoomByHotel(hotel_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(RoomVO vo : list){
			if(vo.getRoomCondition().equals(RoomCondition.UNRESERVED)){
				return ResultMessage.HASROOM;
			}
		}
		return ResultMessage.NOROOM;
	}
	
	public HotelVO PoToVo(HotelPO po) {
		HotelVO result = new HotelVO(po.getHotelId(), po.getHotelName(), po.getHotelAddress(), po.getHotelArea(), po.getHotelLevel(), po.getHotelScore(), po.getHotelIntro(), po.getHotelServe(), po.getHotelRoom(), po.getCity());
		return result;
	}
	
	public HotelPO VoToPo(HotelVO vo){
		HotelPO result = new HotelPO(vo.getHotelId().get(), vo.getHotelName().get(), vo.getHotelAddress().get(), vo.getHotelArea().get(), vo.getHotel_level().get(), vo.getHotel_score().get(), vo.getHotelIntro().get(), vo.getHotelServe().get(), vo.getHotelRoom().get(), vo.getCity().get());
		return result;
	}
	
	public HotelEvaluationPO VoToPo1(HotelEvaluationVO vo){
		HotelEvaluationPO result = new HotelEvaluationPO(vo.getOrder_id(), vo.getUser_id(), vo.getDate(), vo.getData(), vo.getLevel());
		return result;
	}


	
}
