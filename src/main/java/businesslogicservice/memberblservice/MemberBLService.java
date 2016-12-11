package businesslogicservice.memberblservice;

import vo.*;
import util.*;

public interface MemberBLService {

	public ResultMessage regieterComMember(String birthday, String user_id);
	public ResultMessage registerCorMember(String birthday, String user_id, String corporate);
	
}
