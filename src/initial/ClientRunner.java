package initial;
import javax.naming.Context;

import java.net.*;
import java.rmi.Naming;
import java.rmi.Remote;




import javax.naming.InitialContext; 

import dataservice.orderdataservice.*;
import po.*;
public class ClientRunner {
	private static Remote remote;
	public static void main(String[] args) {
		
	    try {
	    	
	    	remote=Naming.lookup("rmi://localhost:8888/OrderService");
	      
	      
	      System.out.println(remote);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	}

}
