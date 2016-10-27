package businesslogicservice.hotelblservice;

import util.*;
import vo.HotelVO;

public class HotelBLService_Driver {

    public void drive(HotelBLService hotelBLService){
    	
    	HotelVO vo1 = new HotelVO("如家连锁酒店","南京市秦淮区新街口231号","秦淮区","XXXX","XXXX","大床房，单人间，双人间");
    	
    	ResultMessage result1 = hotelBLService.addHotel(vo1);
    	if(result1 == ResultMessage.EXIST)
    		System.out.println("Hotel exist");
    	else
    		System.out.println("Add success");
    	
    	ResultMessage result2 = hotelBLService.modifyHotel(vo1);
    	if(result2 == ResultMessage.SUCCESS)
    		System.out.println("Modify success");
    	else if(result2 == ResultMessage.FAIL)
    		System.out.println("Modify fail");
    	
    	ResultMessage result3 = hotelBLService.evaluateHotel(vo1);
    	if(result3 == ResultMessage.SUCCESS)
    		System.out.println("Evaluate success");
    	else if(result3 == ResultMessage.FAIL)
    		System.out.println("Evaluate fail");
    	
    	HotelVO vo2 = hotelBLService.viewHotel();
    	System.out.println("hotel name: " + vo2.getHotelName() + "hotel address: " + vo2.getHotelAddress()
    	+ "hotel area: " + vo2.getHotelArea() + "hotel intro: " + vo2.getHotelIntro() + "hotel room: "
    	+ vo2.getHotelRoom() + "hotel serve: " + vo2.getHotelServe());
    	
    	String name = "";
        HotelVO vo3 = hotelBLService.seekHotel(name);
        if(vo3.getHotelName() == name)
        	System.out.println("hotel name: " + vo3.getHotelName() + "hotel address: " + vo3.getHotelAddress()
    	+ "hotel area: " + vo3.getHotelArea() + "hotel intro: " + vo3.getHotelIntro() + "hotel room: "
    	+ vo3.getHotelRoom() + "hotel serve: " + vo3.getHotelServe());
        else
        	System.out.println("no hotel exist");
        
    }
}
