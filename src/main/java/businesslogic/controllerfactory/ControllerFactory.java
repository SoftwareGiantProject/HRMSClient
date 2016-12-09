package businesslogic.controllerfactory;

import java.rmi.RemoteException;

import businesslogic.creditbl.CreditController;
import businesslogic.hotelbl.HotelController;
import businesslogic.memberbl.MemberController;
import businesslogic.orderbl.OrderController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.roombl.RoomController;
import businesslogic.userbl.client.ClientController;
import businesslogic.userbl.netsale.NetsaleController;
import businesslogic.userbl.networker.NetworkerController;
import businesslogic.userbl.worker.WorkerController;
import businesslogicservice.creditblservice.CreditBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.ClientBLService;
import businesslogicservice.userblservice.NetsaleBLService;
import businesslogicservice.userblservice.NetworkerBLService;
import businesslogicservice.userblservice.WorkerBLService;

public class ControllerFactory {

	private static CreditController creditController;
	private static HotelController hotelController;
	private static MemberController memberController;
	private static OrderController orderController;
	private static PromotionController promotionController;
	private static RoomController roomController;
	private static ClientController clientController;
	private static NetsaleController netsaleController;
	private static NetworkerController networkerController;
	private static WorkerController workerController;
	
	public ControllerFactory() {
		
	}
	
	public static CreditBLService getCreditBLServiceInstance()throws RemoteException{
		if(creditController == null){
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static HotelBLService getHotelBLServiceInstance()throws RemoteException{
		if(hotelController == null){
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static MemberBLService getMemberBLServiceInstance()throws RemoteException{
		if(memberController == null){
			memberController = new MemberController();
		}
		return memberController;
	}
	
	public static OrderBLService getOrderBLServiceInstance()throws RemoteException{
		if(orderController == null){
			orderController = new OrderController();
		}
		return orderController;
	}
	
	public static PromotionBLService getPromotionBLServiceInstance()throws RemoteException{
		if(promotionController == null){
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static RoomBLService getRoomBLServiceInstance()throws RemoteException{
		if(roomController == null){
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public static ClientBLService getClientBLSerivceInstance()throws RemoteException{
		if(clientController == null){
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static WorkerBLService getWorkerBLServiceInstance()throws RemoteException{
		if(workerController == null){
			workerController = new WorkerController();
		}
		return workerController;
	}
	
	public static NetsaleBLService getNetsaleBLServiceInstance()throws RemoteException{
		if(netsaleController == null){
			netsaleController = new NetsaleController();
		}
		return netsaleController;
	}
	
	public static NetworkerBLService getNetworkerBLSericeInstance()throws RemoteException{
		if(networkerController == null){
			networkerController = new NetworkerController();
		}
		return networkerController;
	}
	
}
