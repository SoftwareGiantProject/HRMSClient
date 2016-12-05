package businesslogic.userbl.netsale;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.networker.NetsaleInfo;
import businesslogicservice.userblservice.NetsaleBLService;
import dataservice.datafactory.DatafactoryImpl;
import dataservice.userdataservice.NetsaleDataService;
import util.ResultMessage;
import vo.NetsaleVO;

public class NetsaleController implements NetsaleBLService,NetsaleInfo{
	
	private Netsale netsale;
	
	public NetsaleController() {
		netsale = new Netsale();
	}

	@Override
	public NetsaleVO getInfo(String netsale_id) {
		// TODO Auto-generated method stub
		return netsale.getInfo(netsale_id);
	}

	@Override
	public ResultMessage modifyInfo(NetsaleVO vo) {
		// TODO Auto-generated method stub
		return netsale.modifyInfo(vo);
	}

	@Override
	public NetsaleVO getNetsaleInfo(String netsale_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addNetsaleInfo(NetsaleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyNetsaleInfo(NetsaleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NetsaleVO> getAllNetsaleInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
