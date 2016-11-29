package rmiTest;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
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
			String ip = null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			try{
				dataFactory = (DataFactory) Naming.lookup("rmi://" + ip +  ":" + port + "/DataFactory");
			}catch(MalformedURLException | RemoteException | NotBoundException e){
				e.printStackTrace();
			}
		}
		return dataFactory;
	}
}
