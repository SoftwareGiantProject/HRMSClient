package businesslogictest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.netsale.NetsaleController;
import dataservice.datafactory.DatafactoryImpl;
import util.ResultMessage;
import vo.NetsaleVO;

public class NetsaleTest {

	private NetsaleController netsaleController;
	
	@Before
	public void init() throws RemoteException{
		netsaleController = (NetsaleController) ControllerFactory.getNetsaleBLServiceInstance();
	}
	
	@Test
	public void testGetInfo() throws RemoteException{
		String id = "s001";
		
		NetsaleVO vo = new NetsaleVO();
		
		vo = netsaleController.getInfo(id);
		
		assertEquals("s001s001",vo.getPassword());
	}
	
	/**
	 * @throws RemoteException 
	 * @Test 添加网站营销人员测试成功
	public void testAdd() throws RemoteException{
		NetsaleVO vo = new NetsaleVO();
		
		vo.setUserId("s002");
		vo.setUserName("No.2");
		vo.setPassword("000000");
		vo.setContact("12341231");
		
		netsaleController.addNetsaleInfo(vo);
	}
	*/
	/**
	@Test 修改网站营销人员信息测试成功
	public void testModify() throws RemoteException{
		NetsaleVO vo = new NetsaleVO();
		
		vo.setUserId("s002");
		vo.setUserName("No.2");
		vo.setPassword("netsale2");
		vo.setContact("13755372854");
		
		netsaleController.modifyInfo(vo);
	}
	*/
	
	/**
	@Test 获得所有网站营销人员信息 测试成功
	public void testGetAll(){
		ArrayList<NetsaleVO> list = new ArrayList<>();
		
		try {
			list = netsaleController.getAllNetsaleInfo();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("NetsaleNo1@gmail.com", list.get(0).getContact());
		assertEquals("13755372854", list.get(1).getContact());
	}
	*/ 

	/**
	@Test 登陆测试成功
	public void testLogin() throws RemoteException{
		String id1 = "s001", password1 = "s001s001";
		String id2 = "s002", password2 = "n";
		
		assertEquals(ResultMessage.SUCCESS,netsaleController.login(id1, password1));
		assertEquals(ResultMessage.FAIL, netsaleController.login(id2, password2));
	}
	*/
}

