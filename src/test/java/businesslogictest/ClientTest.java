package businesslogictest;



import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.client.Client;
import businesslogic.userbl.client.ClientController;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public class ClientTest {

	private ClientController clientController;
	
	@Before
	public void init() throws RemoteException{
		clientController =  (ClientController) ControllerFactory.getClientBLSerivceInstance();
	}

	/** 
	@Test 注册方法测试成功
	public void testRegist(){
		ClientVO vo = new ClientVO();
		
		vo.setUserId("151250090");
		vo.setPassword("test");
		vo.setCredit(100);
		vo.setBirthday("1997-5-13");
		vo.setType(MemberType.NONE);
		vo.setContact("123123123@163.com");
		vo.setUserName("Kerl");
		
		try {
			clientController.regist(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testGetClientInfo(){
		String user_id = "151250061";
		
		ClientVO vo = new ClientVO();
		try {
			vo = clientController.getClientInfo(user_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(vo.getBirthday()+vo.getContact(),"1997-5-29"+"loohaze529@gmail.com");
	}
	
	/**
	@Test modify方法测试成功
	public void testModify(){
		ClientVO vo = new ClientVO();
		
		vo.setUserId("151250090");
		vo.setBirthday("1996-5-21");
		vo.setContact("13423525643");
		vo.setPassword("testPass");
		vo.setType(MemberType.NONE);
		vo.setUserName("Kerl");
		vo.setCredit(200);
		
		try {
			clientController.modifyInfo(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/** 注册普通会员测试通过
	@Test  
	public void testRegistComMember(){
		CommonMemberVO vo = new CommonMemberVO();
		String id = "151250090";
		
		vo.setCommonMember_number("C00005");
		vo.setCommonMember_level(2);
		vo.setCommonMember_Birthday("1996-5-21");
		vo.setMember_type(MemberType.COMMONMEMBER);
		
		try {
			clientController.registComMember(id, vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/** 注册企业会员测试成功
	@Test 
	public void testRegistCorMember(){
		CorporateMemberVO vo = new CorporateMemberVO();
		String id = "151250058";
		
		vo.setCorporateMember_number("C00003");
		vo.setCorporateMember_Birthday("1998-8-23");
		vo.setCorporateMember_level(0);
		vo.setMember_type(MemberType.CORPORATEMEMBER);
		vo.setCorporate("Tencent");
		
		try {
			clientController.registCorMember(id, vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testGetAllClient(){
		ArrayList<ClientVO> list = new ArrayList<>();
		
		try {
			list = clientController.getAllClientInfo();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("C00003",list.get(1).getMemberId());
	}
	
	@Test
	public void testLogin() throws RemoteException{
		String id1 = "151250061";
		String password1 = "huangyan529";
		
		String id2 = "151250060";
		String password2 = "11";
		
		assertEquals(ResultMessage.SUCCESS, clientController.login(id1, password1));
		assertEquals(ResultMessage.FAIL,clientController.login(id2, password2));
	}
}
