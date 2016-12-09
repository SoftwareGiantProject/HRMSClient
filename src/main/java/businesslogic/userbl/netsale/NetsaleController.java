package businesslogic.userbl.netsale;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.networker.NetsaleInfo;
import businesslogicservice.userblservice.Login;
import businesslogicservice.userblservice.NetsaleBLService;
import util.ResultMessage;
import vo.NetsaleVO;

public class NetsaleController implements NetsaleBLService,NetsaleInfo,Login{
	
	private Netsale netsale;
	
	public NetsaleController() {
		netsale = new Netsale();
	}

	@Override
	public NetsaleVO getInfo(String netsale_id) throws RemoteException  {
		// TODO Auto-generated method stub
		return netsale.getInfo(netsale_id);
	}

	@Override
	public ResultMessage modifyInfo(NetsaleVO vo)throws RemoteException  {
		// TODO Auto-generated method stub
		return netsale.modifyInfo(vo);
	}

	@Override
	public NetsaleVO getNetsaleInfo(String netsale_id) throws RemoteException {
		// TODO Auto-generated method stub
		return netsale.getInfo(netsale_id);
	}

	@Override
	public ResultMessage addNetsaleInfo(NetsaleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return netsale.addNetsale(vo);
	}

	@Override
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return netsale.modifyInfo(vo);
	}

	@Override
	public ArrayList<NetsaleVO> getAllNetsaleInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return netsale.getAllNetsale();
	}

	@Override
	public ResultMessage login(String user_id, String password)throws RemoteException {
		// TODO Auto-generated method stub
		return netsale.login(user_id, password);
	}
	
	
}
