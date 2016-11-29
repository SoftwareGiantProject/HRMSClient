package rmihelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.datafactory.DataFactory;
import dataservice.datafactory.DatafactoryImpl;

public class ClientRunner {

	public static void main(String[] args) {
		DatafactoryImpl.getInstance();
	}
}
