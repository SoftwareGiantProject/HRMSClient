package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.userbl.client.ClientController;
import dataservice.datafactory.DatafactoryImpl;
import po.ClientPO;
import po.CreditPO;
import util.ResultMessage;
import vo.ClientVO;
import vo.CreditVO;

public class Credit {
	
	
	private ClientController clientController;
	public Credit() throws RemoteException{
		clientController = (ClientController) ControllerFactory.getClientBLSerivceInstance();
	}
	
	/**
	 * 
	 * @param user_id 客户编号 
	 * @return 该客户的Credit
	 */
	public CreditVO getCredit(String user_id){
		CreditPO po = new CreditPO();
		String id = user_id;
		
		try{
			po = DatafactoryImpl.getInstance().getCreditData().find(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditVO vo = new CreditVO();
		vo.setUserId(po.getId());
		vo.setCredit(po.getCredit());
		return vo;
	}

	/**
	 * 
	 * @param user_id 客户编号
	 * @param change  订单价值
	 * @return 客户撤销订单，扣除信用值的结果
	 * @throws RemoteException 
	 */
	public ResultMessage deduct(String user_id,int change) throws RemoteException{
		ArrayList<CreditPO> historyPo = new ArrayList<CreditPO>();
		ResultMessage result = ResultMessage.FAIL;
		String id = user_id;
		int money = change;
		
		try{
			historyPo = DatafactoryImpl.getInstance().getCreditData().getHistoryCredit(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditPO lastcreditpo = historyPo.get(historyPo.size() - 1);
		int lastcredit = lastcreditpo.getCredit() - money/2;           
		int lastchange = -money/2;
		Date now = new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String current = matter1.format(now);
		
		lastcreditpo.setCredit(lastcredit);
		lastcreditpo.setChange(lastchange);
		lastcreditpo.setTime(current);
		
		ClientVO vo = clientController.getClientInfo(user_id);
		vo.setCredit(lastcredit);
		ResultMessage result2 = clientController.modifyInfo(vo);
		
		try{
			result = DatafactoryImpl.getInstance().getCreditData().modify(lastcreditpo);
		}catch(RemoteException E){
			E.printStackTrace();
		}
		
		if(result2.equals(ResultMessage.SUCCESS) && result.equals(ResultMessage.SUCCESS)){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}
	
	/**
	 * 
	 * @param user_id 客户编号
	 * @param change 充值金额
	 * @return 客户充值信用的结果
	 * @throws RemoteException 
	 */
	public ResultMessage deposit(String user_id, int change) throws RemoteException{
		ArrayList<CreditPO> historyPo = new ArrayList<CreditPO>();
		ResultMessage result = ResultMessage.FAIL;
		String id = user_id;
		int recharge = change;
		
		try{
			historyPo = DatafactoryImpl.getInstance().getCreditData().getHistoryCredit(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		CreditPO lastcreditpo = historyPo.get(historyPo.size() - 1);
		int lastcredit = lastcreditpo.getCredit() + recharge*100;           //澧炲姞鍏呭�奸搴�*100鐨勪俊鐢ㄥ��
		int lastchange = recharge*100;
		Date now = new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String current = matter1.format(now);
		
		lastcreditpo.setCredit(lastcredit);
		lastcreditpo.setChange(lastchange);
		lastcreditpo.setTime(current);
		
		ClientVO vo = clientController.getClientInfo(user_id);
		vo.setCredit(lastcredit);
		ResultMessage result2 = clientController.modifyInfo(vo);
		
		try{
			result = DatafactoryImpl.getInstance().getCreditData().modify(lastcreditpo);
		}catch(RemoteException E){
			E.printStackTrace();
		}
		
		if(result2.equals(ResultMessage.SUCCESS) && result.equals(ResultMessage.SUCCESS)){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage addCredit(String user_id, int change) throws RemoteException {
		deposit(user_id,change/100);
		return null;
	}
	
}
