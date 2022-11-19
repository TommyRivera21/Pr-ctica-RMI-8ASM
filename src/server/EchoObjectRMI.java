package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.EchoInt;

public class EchoObjectRMI {

	public static void main(String[] args) throws AlreadyBoundException 
        {
			/*if(System.getSecurityManager() == null) 
			{
				System.setSecurityManager(new RMISecurityManager());
			}*/
			try 
            {
                Registry registry = LocateRegistry.createRegistry(5000);
				EchoInt stub = (EchoInt) UnicastRemoteObject.exportObject(new EchoObject(), 0);
				registry.bind("echo", stub);
				System.out.println("el servidor esta listo");
			} 
            catch (RemoteException e) 	
            {
				e.getMessage();
				System.err.println("Ocurrio algo malo en el extremo remoto" + " " +  e.toString());
	            System.exit(-1); // can't just return, rmi threads may not exit
			}
			System.out.println("el servidor de echo esta listo");
	}
}