package businesslogic.memberbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.client.ClientController;
import dataservice.datafactory.DatafactoryImpl;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;
import vo.ClientVO;

public class Member {
	
	private ClientController clientController;
	
	public Member() throws RemoteException {
		clientController = (ClientController) ControllerFactory.getClientBLSerivceInstance();
	}
	//缺少判断是否注册过会员，更新客户信息
	public ResultMessage registerComMember(String birthday, String user_id) throws RemoteException{
		ResultMessage result = ResultMessage.FAIL;
		
		ClientVO vo = new ClientVO();
		vo = clientController.getClientInfo(user_id);
		if(!vo.getType().equals(MemberType.NONE)){
			return ResultMessage.FAIL;
		}
		String id = user_id;
		String bir = birthday;
		MemberType type = MemberType.COMMONMEMBER;
		int credit = 0;
		int level = 0;
		String comMember_id = getMember_id();
		CommonMemberPO po;
		try {
			credit = DatafactoryImpl.getInstance().getCreditData().getCredit(id);
			level = getLevel(credit);
			po = new CommonMemberPO(level, bir, comMember_id, type);
			result = DatafactoryImpl.getInstance().getMemberData().addComMember(po);
			vo.setMemberId(comMember_id);
			vo.setType(type);
			clientController.modifyInfo(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	//缺少判断是否注册过会员，更新客户信息
	public ResultMessage registerCorMember(String birthday, String user_id, String corporate) throws RemoteException{
		ResultMessage result = ResultMessage.FAIL;
		
		ClientVO vo = new ClientVO();
		vo = clientController.getClientInfo(user_id);
		if(!vo.getType().equals(MemberType.NONE)){
			return ResultMessage.FAIL;
		}
		String id = user_id;
		String bir = birthday;
		String cor = corporate;
		MemberType type = MemberType.CORPORATEMEMBER;
		int credit = 0;
		int level = 0;
		String comMember_id = getMember_id();
		CorporateMemberPO po;
		try {
			credit = DatafactoryImpl.getInstance().getCreditData().getCredit(id);
			level = getLevel(credit);
			po = new CorporateMemberPO(level, bir, comMember_id, cor, type);
			result = DatafactoryImpl.getInstance().getMemberData().addCorMember(po);
			vo.setMemberId(comMember_id);
			vo.setType(type);
			clientController.modifyInfo(vo);	
		} catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
		
	}

	//getComMember和getCorMember返回的arraylist 第一个是编号最的，最后一个编号是最大的
	/**
	 * 
	 * @return 会员编号
	 */
	private String getMember_id(){
		ArrayList<CommonMemberPO> list1 = new ArrayList<>();
		ArrayList<CorporateMemberPO> list2 = new ArrayList<>();
		
		try {
			list1 = DatafactoryImpl.getInstance().getMemberData().getComMember();
			list2 = DatafactoryImpl.getInstance().getMemberData().getCorMember();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String L1 = "";
        String L2 = "";
        String result = "";
		if(list1.isEmpty() && list2.isEmpty()){
			return "C00001";
		}else if(list1.isEmpty()){
			L2 = list2.get(list2.size() - 1).getCorporateMember_number();
			int temp1 = Integer.parseInt(L2.substring(1)) + 1;
			return toString(temp1);
		}else if(list2.isEmpty()){
			L1 = list1.get(list1.size() - 1).getCommonMember_number();
			int temp2 = Integer.parseInt(L1.substring(1)) + 1;
			return toString(temp2);
		}else{
			L1 = list1.get(list1.size() - 1).getCommonMember_number();
			L2 = list2.get(list2.size() - 1).getCorporateMember_number();
			result = getMaxId(L1, L2);
		}
		return result;
		
		
	}
	
	/**
	 * 
	 * @param lis1
	 * @param lis2
	 * @return list1与list2最大值
	 */
	private String getMaxId(String lis1, String lis2){
		String temp1 = lis1.substring(1);
		String temp2 = lis2.substring(1);
		int a = Integer.parseInt(temp1);
		int b = Integer.parseInt(temp2);
		if(a > b){
			return toString(a+1);
		}else{
			return toString(b+1);
		}
	}
	
	/**
	 * 
	 * @param a 数字
	 * @return 根据数字返回相应的会员编号
	 */
	private String toString(int a){
		String temp = String.valueOf(a);
		int length = temp.length();
		String result = "C";
		for(int i = 0; i < 5-length; i++){
			result += "0";
		}
		result += temp;
		return result;
	}
	
	/**
	 * 
	 * @param credit 信用值
	 * @return 根据信用值得到会员等级
	 */
	private int getLevel(int credit){        
		int min = 0;
		int max = 0;
		if(credit < 0){
			return 0;
		}
		for(int i = 0; ; i++){
			max = min + 500*i + 1000;
			if(credit >= min && credit < max){
				return i;
			}else{
				min = max;
			}
			
		}
	}
}
