package businesslogictest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.worker.WorkerController;
import util.ResultMessage;
import vo.WorkerVO;

public class WorkerTest {
	
	private WorkerController workerController;
	
	@Before
	public void init() throws RemoteException{
		workerController = (WorkerController) ControllerFactory.getWorkerBLServiceInstance();
	}
	
	@Test
	public void testGetInfo(){
		String id = "w00001";
		
		WorkerVO vo = new  WorkerVO();
		
		try {
			vo = workerController.getInfo(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("no1no1no1",vo.getPassword());
		assertEquals("15895870321",vo.getContact());
	}
	
	/** 
	@Test 修改酒店工作人员信息 测试成功
	public void testModify(){
		WorkerVO vo = new WorkerVO();
		
		vo.setUserId("w00001");
		vo.setHotel_id("h001");
		vo.setUserName("WorkerNo1");
		vo.setPassword("no1no1no1");
		vo.setContact("15895870321");
		
		try {
			workerController.modifyInfo(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 获得所有酒店工作人员方法测试成功
	public void testGetAll(){
		ArrayList<WorkerVO> list = new ArrayList<>();
		
		try {
			list = workerController.getAllWorkerInfo();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("no1no1no1", list.get(0).getPassword());
		assertEquals("15803422012", list.get(1).getContact());
	}
	*/
	
	/**
	@Test 添加酒店工作人员 测试成功
	public void testAdd(){
		WorkerVO vo = new WorkerVO();
		
		vo.setUserId("w00003");
		vo.setHotel_id("h001");
		vo.setPassword("123456");
		vo.setUserName("No3");
		vo.setContact("64364325");
		
		try {
			workerController.addWorker(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 酒店工作人员登录测试成功
	public void testLogin()throws RemoteException{
		String id1 = "w00001", password1 = "no1no1no1";
		String id2 = "w00002", password2 = "123";
		
		assertEquals(ResultMessage.SUCCESS, workerController.login(id1, password1));
		assertEquals(ResultMessage.FAIL, workerController.login(id2, password2));
	}
	*/
}
