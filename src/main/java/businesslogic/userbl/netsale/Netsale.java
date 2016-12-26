package businesslogic.userbl.netsale;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.LoginIn;
import dataservice.userdataservice.NetsaleDataService;
import po.NetsalePO;
import util.ResultMessage;
import vo.NetsaleVO;

public class Netsale {

	private NetsaleDataService netsaleDataService;
	private LoginIn login;
	
	public Netsale() {
		try{
			netsaleDataService = DatafactoryImpl.getInstance().getNetsaleData();
			login = DatafactoryImpl.getInstance().getLoginData();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	/**
	 * 获取网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public NetsaleVO getInfo(String netsale_id){
		NetsalePO po = new NetsalePO();
		
		try {
			po = netsaleDataService.findNetsale(netsale_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		NetsaleVO vo = po2vo(po);
		return vo;
	}
	
	/**
	 * 修改网络营销人员信息
	 * @param netsale_id
	 * @return
	 */
	public ResultMessage modifyInfo(NetsaleVO vo){
		NetsalePO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = netsaleDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 添加网络营销人员信息
	 * @param vo
	 * @return
	 */
	public ResultMessage addNetsale(NetsaleVO vo){
		NetsalePO po = vo2po(vo);
		
		ResultMessage result = ResultMessage.FAIL;
		
		ArrayList<NetsaleVO> list = getAllNetsale();
		for(NetsaleVO netsale : list){
			if(netsale.getUserId().get().equals(vo.getUserId().get())){
				return result;
			}
		}
		
		try {
			result = netsaleDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获得全部网络营销人员信息
	 * @return
	 */
	public ArrayList<NetsaleVO> getAllNetsale(){
		ArrayList<NetsalePO> list = new ArrayList<>();
		
		try {
			list = netsaleDataService.getAllNetsale();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<NetsaleVO> resultList = new ArrayList<>();
		
		for(NetsalePO po : list){
			resultList.add(po2vo(po));
		}
		return resultList;
	}
	
	/**
	 * 登录
	 * @param user_id
	 * @param password
	 * @return
	 */
	public ResultMessage login(String user_id,String password){
		ResultMessage result = ResultMessage.FAIL;
		
		try {
			result = login.login(user_id, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private NetsaleVO po2vo(NetsalePO po){
		NetsaleVO vo = new NetsaleVO();
		
		vo.setContact(po.getContact());
		vo.setPassword(po.getPassword());
		vo.setUserId(po.getUserId());
		vo.setUserName(po.getUserName());
		
		return vo;
	}
	
	private NetsalePO vo2po(NetsaleVO vo){
		NetsalePO po = new NetsalePO();
		
		po.setContact(vo.getContact().get());
		po.setPassword(vo.getPassword().get());
		po.setUserId(vo.getUserId().get());
		po.setUserName(vo.getUserName().get());
		
		return po;
	}
}
