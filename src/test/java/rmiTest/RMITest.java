package rmiTest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.mysql.fabric.xmlrpc.base.Data;

import dataservice.datafactory.DataFactory;
import dataservice.hoteldataservice.HotelDataService;
import initial.ClientRunner;

public class RMITest {

	private final static int port = 8888;
	
	private static DataFactory dataFactory;
	
	private RMITest(){
		
	}
	
	public static void main(String[] args) {
		dataFactory = getDataFactoryInstance();
		
		try{
			HotelDataService hotelDataService = dataFactory.getHotelData();
			System.out.println(hotelDataService.toString());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	public static synchronized DataFactory getDataFactoryInstance(){
		if(dataFactory == null){
			String ip = "127.0.0.1";
			try{
				dataFactory = (DataFactory) Naming.lookup("rmi://" +  ip +  ":" + port + "/DataFactory");
			}catch(MalformedURLException | RemoteException | NotBoundException e){
				e.printStackTrace();
			}
		}
		return dataFactory;
	}
}
