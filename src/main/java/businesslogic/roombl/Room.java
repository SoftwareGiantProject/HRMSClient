package businesslogic.roombl;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dataservice.datafactory.DatafactoryImpl;
import po.HotelPO;
import po.RoomConditionDatePO;
import po.RoomPO;
import util.ResultMessage;
import util.RoomCondition;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class Room {
	
	
	/**
	 * 
	 * @param vo 房间信息
	 * @return ResultMessage 添加房间的结果 
	 */
	public ResultMessage addRoom(RoomVO vo){
		
		int Max_day = 7;
		ArrayList<RoomPO> list1 = new ArrayList<>();
		String room_number = vo.getRoomNumber();
		String hotelId = vo.getHotel_id();
		//房间编号已存在
		try {
			list1  = DatafactoryImpl.getInstance().getRoomData().getAllRoom(hotelId);
			for(RoomPO lis : list1){
				if(room_number.equals(lis.getRoom_number())){
					return ResultMessage.EXIST;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String room_type = vo.getRoomType();
		int room_price = vo.getRoomPrice();
		RoomCondition room_condition = RoomCondition.UNRESERVED;
		ResultMessage result1 = ResultMessage.FAIL;
 		RoomPO po = new RoomPO(room_type, room_price, room_number, hotelId, room_condition);
		try {
			result1 = DatafactoryImpl.getInstance().getRoomData().add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		ResultMessage result2 = ResultMessage.FAIL;

		try {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
			for(int i = 0; i < Max_day; i++){
				now.add(Calendar.DAY_OF_MONTH, i);
				String date = matter1.format(now.getTime());
				RoomConditionDatePO temp = new RoomConditionDatePO(hotelId, date, room_number, room_condition);
				result2 = DatafactoryImpl.getInstance().getRoomData().addRoomCondition(temp);
				if(result2 == ResultMessage.FAIL){
					return result2;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		if(result1 == ResultMessage.SUCCESS && result2 == ResultMessage.SUCCESS){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}
	
	/**
	 * 
	 * @param Type 房间类型
	 * @param num 房间数量
	 * @param hotel_id 酒店id
	 * @param inTime 入住时间
	 * @param outTime 离开时间
	 * @return 预定结果
	 */
	public ResultMessage reserve(String Type, int num, String hotel_id, String inTime, String outTime){
		/*
		 * 先判断房间数量是否足够
		 * 日期问题，天数，
		 * 
		 * */
		String room_type = Type;
		String hotelId = hotel_id;
		String checkin_time = inTime;  //入住时间
		String checkout_time = outTime;  //离开时间
		String today = getNowTime();
		String LastDay = getLastTime();
		int room_num = num;
		//预定日期存在问题
		if(compare(today, checkin_time) < 0){
			return ResultMessage.error;
		}
		if(compare(checkin_time, checkout_time) <= 0) {
			return ResultMessage.error;
		}
		if(compare(checkout_time, LastDay) < -1){
			return ResultMessage.error;
		}
		if(room_num <= 0){
			return ResultMessage.error;
		}
		ArrayList<RoomPO> list = new ArrayList<>();

		
		//预定的房间数量多于酒店房间数量
		try {
			list = DatafactoryImpl.getInstance().getRoomData().findRoom(hotelId, room_type);
			if(room_num > list.size()){
				return ResultMessage.FAIL;
			}	
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		int day = compare(checkin_time, checkout_time);
		
		ArrayList<RoomConditionDatePO> resultPo = new ArrayList<>();
		ArrayList<RoomConditionDatePO> temp = new ArrayList<>();	
		try {
			for(int i = 0; i < list.size(); i++){
				if(room_num == 0){
					break;
				}
				temp = DatafactoryImpl.getInstance().getRoomData().getRoomConditionPO(hotelId, list.get(i).getRoom_number());
				temp = getUsefulRoom(temp, checkin_time, checkout_time);
				if(temp.size() == day){
					resultPo = ADD(resultPo, temp);
					room_num--;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		ResultMessage resultMessage = ResultMessage.FAIL;
		//修改房间状态
		if(room_num == 0){
			for(int i = 0; i < resultPo.size(); i++){
				resultPo.get(i).setRoomConditon(RoomCondition.RESERVED);
				resultMessage = modifyCondition(potovo(resultPo.get(i)));
			}	
			return resultMessage;
		}
		
		return resultMessage;		
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return a与b相加的和
	 */
	public ArrayList<RoomConditionDatePO> ADD(ArrayList<RoomConditionDatePO> a, ArrayList<RoomConditionDatePO> b){
		ArrayList<RoomConditionDatePO> result = new ArrayList<>();
		result = a;
		for(int i = 0; i < b.size(); i++){
			result.add(b.get(i));
		}
		return result;
	}
	
	/**
	 * 
	 * @param hotel_id
	 * @return 该酒店的所有房间
	 */
	public ArrayList<RoomVO> getAllRoomByHotel(String hotel_id){
		ArrayList<RoomVO> result = new ArrayList<>();
		ArrayList<RoomPO> list = new ArrayList<>();
	    try {
	    	list = DatafactoryImpl.getInstance().getRoomData().getAllRoom(hotel_id);
	    	for(RoomPO lis : list){
	    		result.add(POTOVO(lis));
	    	}
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	    
	    return result;
	}
	
	/**
	 * 
	 * @param vo
	 * @return 修改房间的状态
	 */
	public ResultMessage modifyCondition(RoomConditionDateVO vo){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = DatafactoryImpl.getInstance().getRoomData().modifyRoomCondition(VOTOPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param arr
	 * @param inTime 入住时间
	 * @param outTime 离开时间
	 * @return 未预定的在该时间段内的所有RoomConditionDatePO
	 */
	public ArrayList<RoomConditionDatePO> getUsefulRoom(ArrayList<RoomConditionDatePO> arr, String inTime, String outTime){
		ArrayList<RoomConditionDatePO> temp = arr;
		ArrayList<RoomConditionDatePO> result = new ArrayList<>();
		ArrayList<String> allDate = getDate(inTime, outTime);
		
		for(int i = 0; i < temp.size(); i++){
			for(int j = 0; j < allDate.size(); j++){
				if((temp.get(i).getRoomCondition() == RoomCondition.UNRESERVED) && temp.get(i).getRoomDate().equals(allDate.get(j))){
					result.add(temp.get(i));
				}
			}
			
		}
		return result;
	}
	
	/**
	 * 
	 * @param inTime 入住时间
	 * @param outTime 离开时间
	 * @return 入住时间到离开时间之间每天日期
	 */
	public  ArrayList<String> getDate(String inTime, String outTime){
		int days = compare(inTime, outTime);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Calendar calendar = Calendar.getInstance();

		try {
			date = sim.parse(inTime);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> result = new ArrayList<>();
		String temp = "";
		temp = sim.format(calendar.getTime());
		result.add(temp);
		for(int i = 1; i < days; i++){
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			temp = sim.format(calendar.getTime());
			result.add(temp);
		}
		return result;
	}
	
	/**
	 * 
	 * @return 返回现在的日期
	 */
	public String getNowTime(){
		 Date dt=new Date();
	     SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dds");
	     String temp = matter1.format(dt);
	     return temp;
	}
	
	/**
	 * 
	 * @return 返回今天未来第七天的日期
	 */
	public String getLastTime(){
		Calendar now = Calendar.getInstance();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		now.add(Calendar.DAY_OF_MONTH, 6);
		String date = matter1.format(now.getTime());
		return date;
	}
	
	/**
	 * 
	 * @return 返回昨天的日期
	 */
	public String getYesterday(){
		Calendar now = Calendar.getInstance();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		now.add(Calendar.DAY_OF_MONTH, -1);
		String date = matter1.format(now.getTime());
		return date;

	}
	
	/**
	 * 
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 日期2与日期1的差值
	 */
	public int compare(String date1, String date2){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		int temp = -19;
		try {
			Date time1 = sim.parse(date1);
			Date time2 = sim.parse(date2);
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.setTime(time1);
	        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
            aCalendar.setTime(time2);
            int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
            temp = day2 - day1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return temp;
		
	}
	
	/**
	 * 更新roomconditiondatepo
	 */
	public void update(){
		String yesterday = getYesterday();
		String future = getLastTime();
		
		ArrayList<RoomConditionDatePO> list = new ArrayList<>();
		while(true){
			try {
				list = DatafactoryImpl.getInstance().getRoomData().getAllByDate(yesterday);
				if(list.isEmpty()){
					return;
				}else {
					for(int i = 0; i < list.size(); i++){
						DatafactoryImpl.getInstance().getRoomData().deleteRoomCondition(list.get(i));
						list.get(i).setRoomDate(future);
						list.get(i).setRoomConditon(RoomCondition.UNRESERVED);
						DatafactoryImpl.getInstance().getRoomData().addRoomCondition(list.get(i));
					}
					return;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}
	
	/**
	 * 更新roompo
	 */
	public void UPDATE(){
		ArrayList<RoomPO> list = new ArrayList<>();
		String today = getNowTime();
		ArrayList<RoomConditionDatePO> list1 = new ArrayList<>();
		try {
			list = DatafactoryImpl.getInstance().getRoomData().getAllRooms();
			for(RoomPO lis : list){
				list1 = DatafactoryImpl.getInstance().getRoomData().getRoomConditionPO(lis.getHotel_id(), lis.getRoom_number());
				lis.setRoom_condition(getRoomCondition(list1, today));
				DatafactoryImpl.getInstance().getRoomData().modify(lis);
			}
			return;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public RoomCondition getRoomCondition(ArrayList<RoomConditionDatePO> a, String date){
		for(RoomConditionDatePO list : a){
			if(list.getRoomDate() == date){
				return list.getRoomCondition();
			}
		}
		return null;
		
	}
	
	public RoomVO POTOVO(RoomPO po){
		RoomVO result = new RoomVO(po.getRoom_type(), po.getRoom_price(), po.getRoom_number(), po.getHotel_id(), po.getRoom_condition());
		return result;
	} 
	
	public RoomConditionDatePO VOTOPO(RoomConditionDateVO vo){
		RoomConditionDatePO result = new RoomConditionDatePO(vo.getHotelId(), vo.getRoomDate(), vo.getRoomNumber(), vo.getRoomCondition());
		return result;
	}
	
	public RoomConditionDateVO potovo(RoomConditionDatePO po){
		RoomConditionDateVO result = new RoomConditionDateVO(po.getRoomDate(), po.getRoomNumber(), po.getRoomCondition(), po.getHotel_id());
		return result;
	}
	

}
