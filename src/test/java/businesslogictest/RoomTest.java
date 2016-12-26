package businesslogictest;
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.roombl.RoomController;
import util.ResultMessage;
import util.RoomCondition;
import vo.RoomConditionDateVO;
import vo.RoomVO;

public class RoomTest {
	
	public RoomVO ro;
	public RoomController controller;
	
	@Before
	public void setup(){
		try {
			controller = (RoomController) ControllerFactory.getRoomBLServiceInstance();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ro = new RoomVO("大床房", 198, "001", "Hotel001", RoomCondition.UNRESERVED);
	}
	
	/**
	@Test
	public void testaddRoom(){
		assertEquals(ResultMessage.SUCCESS, controller.addRoom(ro));
	}
	*/
	
	/**
	@Test
	public void testgetAllRoomByHotel(){
		assertEquals(198, controller.getAllRoomByHotel("Hotel001").get(0).getRoomPrice());
	}
	*/
	
	/**
    @Test
    public void testmodifyCondition(){
    	RoomConditionDateVO vo = new RoomConditionDateVO("2016-12-12", "001", RoomCondition.CHECKIN, "Hotel001");
    	assertEquals(ResultMessage.SUCCESS, controller.modifyCondition(vo));
    }
    */
	
	
	@Test
	public void testreserve(){
		assertEquals(ResultMessage.SUCCESS,controller.reserve("大床房", 1,"h001", "2016-12-26", "2016-12-27","112412"));
	}
	
	
	/**
	@Test
	public void testUpdate(){
		controller.update();
		controller.UPDATE();
	}
	*/
	
	/**
	@Test
	public void testGetRoomConditionByhotel(){
		String hotel_id = "h001";
		ArrayList<RoomConditionDateVO> list = new ArrayList<>();
		
		list = controller.getRoomConditionByHotel(hotel_id);
		
		for(RoomConditionDateVO vo : list){
			System.out.println(vo.getHotelId().get());
			System.out.println(vo.getOrder_id().get());
			System.out.println(vo.getRoomCondition());
			System.out.println(vo.getRoomDate().get());
			System.out.println(vo.getRoomNumber().get());
		}
	}
	*/
}