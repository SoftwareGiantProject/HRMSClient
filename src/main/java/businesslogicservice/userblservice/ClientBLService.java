package businesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage;
import vo.ClientVO;
import vo.CommonMemberVO;
import vo.CorporateMemberVO;

public interface ClientBLService {
	
	/**
	 * 注册
	 * @param vo
	 * @param password
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage regist(ClientVO vo) throws RemoteException;
	
	
	/**
	 * 获取用户信息
	 * @param user_id
	 * @return
	 * @throws RemoteException 
	 */
	public ClientVO getClientInfo(String user_id) throws RemoteException;
	
	
	/**
	 * 修改用户信息
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage modifyInfo(ClientVO vo) throws RemoteException;
	
	
	/**
	 * 注册普通会员
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage registComMember(String id,CommonMemberVO vo) throws RemoteException;
	
	
	/**
	 * 注册企业会员
	 * @param vo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage registCorMember(String id,CorporateMemberVO vo) throws RemoteException;
	
	/**
	 * 确认客户是否存在
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage checkClientExist(String id)throws RemoteException;
	
}
