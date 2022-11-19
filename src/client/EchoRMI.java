package client;

import java.io.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.EchoInt;

public class EchoRMI {

	public static void main(String[] args) {
		/*if (args.length<1)
		{
			System.out.println("Uso echo <host>");
			System.exit(1);
		}*/
		
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter stdOut = new PrintWriter(System.out);

		String input,fin,output;
		try
		{
			//String host = "192.168.1.6";
            EchoInt eo = (EchoInt) Naming.lookup("rmi://localhost:5000/echo");
			//Registry reg = LocateRegistry.getRegistry(host);
			//EchoInt eo = (EchoInt) reg.lookup("echo");
            System.out.print("heyy!!!" + eo.echo("hola servidor"));
	          //Bucle que lee de teclado, invoca el eco y escribe respuesta en la pantalla:
			input="";
			fin="fin";
			output = "";
			while(!input.equals(fin)) 
			{
				stdOut.println("Escriba cadena para invocar su eco...");
				stdOut.flush();
	          	input = stdIn.readLine(); //Lee cadena introducida por teclado
	  	        //EJERCICIO: Invocar para la cadena leida el m�todo echo del objeto RMI
                output = eo.echo(input);
	          	stdOut.println(output); //Escribe la respuesta del eco en la pantalla
				stdOut.flush();
			}  	
		}
        catch(Exception e)
        {
			System.out.println("Error en el cliente de echo RMI : " + e.getMessage());
		}
	}

}