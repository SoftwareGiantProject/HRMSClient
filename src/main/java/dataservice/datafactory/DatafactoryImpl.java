package dataservice.datafactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import dataservice.creditdataservice.CreditDataServiceImpl;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.hoteldataservice.HotelDataServiceImpl;
import dataservice.memberdataservice.MemberDataService;
import dataservice.memberdataservice.MemberDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataServiceImpl;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.promotiondataservice.PromotionDataServiceImpl;
import dataservice.roomdataservice.RoomDataService;
import dataservice.roomdataservice.RoomDataServiceImpl;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserDataServiceImpl;

public class DatafactoryImpl implements DataFactory{

	
	private static final long serialVersionUID = 1L;
	
	private static DataFactory datafactory;
	
	private static String address = "127.0.0.1";
	
	private static String port = "8888";
	
	public  DatafactoryImpl() throws RemoteException {
		super();
	}
	
	public static DataFactory getInstance(){
		try{
			datafactory = (DataFactory) Naming.lookup("rmi://" + address + ":" + port + "/DataFactory");
			System.out.println("linked success");
		}catch(MalformedURLException | RemoteException | NotBoundException e){
			e.printStackTrace();
		}
		return datafactory;
	}

	@Override
	public UserDataService getUserData() throws RemoteException {
		// TODO Auto-generated method stub
		return new UserDataServiceImpl();
	}

	@Override
	public MemberDataService getMemberData() throws RemoteException {
		// TODO Auto-generated method stub
		return new MemberDataServiceImpl();
	}

	@Override
	public PromotionDataService getPromotionData() throws RemoteException {
		// TODO Auto-generated method stub
		return new PromotionDataServiceImpl();
	}

	@Override
	public CreditDataService getCreditData() throws RemoteException {
		// TODO Auto-generated method stub
		return new CreditDataServiceImpl();
	}

	@Override
	public OrderDataService getOrderData() throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderDataServiceImpl();
	}

	@Override
	public HotelDataService getHotelData() throws RemoteException {
		// TODO Auto-generated method stub
		return new HotelDataServiceImpl();
	}

	@Override
	public RoomDataService getRoomData() throws RemoteException {
		// TODO Auto-generated method stub
		return new RoomDataServiceImpl();
	}
	
	
	
}