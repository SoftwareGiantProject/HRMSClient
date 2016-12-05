package businesslogic.userbl.networker;

import java.rmi.RemoteException;

import util.ResultMessage;
import vo.HotelVO;

public interface Hoteladd {

	public ResultMessage addHotel(HotelVO vo)throws RemoteException;
}
