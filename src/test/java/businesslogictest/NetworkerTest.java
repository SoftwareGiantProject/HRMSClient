package businesslogictest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.networker.NetworkerController;
import vo.ClientVO;
import vo.NetworkerVO;

public class NetworkerTest {
	
	private NetworkerController networkerController;
	
	@Before
	public void init()throws RemoteException{
		networkerController = (NetworkerController) ControllerFactory.getNetworkerBLSericeInstance();
	}
	
	@Test
	public void testGetNetworkerInfo(){
		String id = "n001";
		
		NetworkerVO vo = new NetworkerVO();
		
		try {
			vo = networkerController.getNetworkerInfo(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals("itisnetworker",vo.getPassword());
	}
	
	/**
	@Test 添加网站管理人员测试成功
	public void testAddNetworkerInfo(){
		NetworkerVO vo = new NetworkerVO();
		
		vo.setUserId("n002");
		vo.setUserName("Networker2");
		vo.setPassword("123456");
		vo.setContact("asdasdad@163.com");
		
		try {
			networkerController.addNetworkerInfo(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/

	/**
	@Test
	public void testModifyNetworker(){
		NetworkerVO vo = new NetworkerVO();
	
		vo.setUserId("n002");
		vo.setUserName("Networker2");
		vo.setPassword("0000");
		vo.setContact("a66666@163.com");
		
		try {
			networkerController.modifyNetworkerInfo(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 登录测试成功
	public void testLogin()throws RemoteException{
		String id = "w00001";
		String password = "itisnetworker";
		
		assertEquals(ResultMessage.FAIL, networkerController.login(id, password));
	}
	*/
	
	
	/**  未测试
	 * 
	@Test
	public void testAddHotel(){
		HotelVO vo = new HotelVO();
		
		vo.setHotel_id("h004");
		vo.setHotel_name("速8酒店");
		vo.setHotel_level(3);
		vo.setHotel_score(4);
		vo.setHotel_address("南京市栖霞区仙林大道111号");
		vo.setHotel_area("栖霞区");
		vo.setHotel_intro("靠近地铁站,方便快捷");
		vo.setHotel_serve("酒店餐厅，免费停车场，免费wifi，叫醒服务");
		vo.setHotel_room("大床房，标准间，单人间，商务间");
		
		try {
			networkerController.addHotel(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/ 
	
	/**
	@Test 获得客户信息方法 测试成功
	public void testGetClientInfo() throws RemoteException{
		String id = "151250061";
		
		ClientVO vo = new ClientVO();
		
		vo = networkerController.getClientInfo(id);

		assertEquals("C00002",vo.getMemberId());
	}
	*/ 
}	

