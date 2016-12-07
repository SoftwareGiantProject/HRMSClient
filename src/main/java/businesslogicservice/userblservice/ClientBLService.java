package businesslogicservice.userblservice;

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
	 */
	public ResultMessage regist(ClientVO vo,String password);
	
	
	/**
	 * 获取用户信息
	 * @param user_id
	 * @return
	 */
	public ClientVO getClientInfo(String user_id);
	
	
	/**
	 * 修改用户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyInfo(ClientVO vo);
	
	
	/**
	 * 注册普通会员
	 * @param vo
	 * @return
	 */
	public ResultMessage registComMember(CommonMemberVO vo);
	
	
	/**
	 * 注册企业会员
	 * @param vo
	 * @return
	 */
	public ResultMessage registCorMember(CorporateMemberVO vo);
	
	
}
