package com.campus02.server;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {
	
	ServerSocket ssock;
	
	public TimeServer() throws IOException
	{
		ssock = new ServerSocket(1111);
		System.out.println("Server Created");
		logger("Server Created @" + LocalDateTime.now(),"worker.log");
	}
	
	public ServerSocket getMy() 
	{
		return ssock;
	}

	public void time (ServerSocket my)
	{
		System.out.println("Server gestartet");
		logger("Server started @" + LocalDateTime.now(),"worker.log");
		try {
		Socket client = null;
		int counter = 1;
		while (counter <=10)
			{
				client = ssock.accept();
				PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
				LocalDateTime now = LocalDateTime.now();
				pw.println(now);
				pw.println(counter);
				logger("Uhrzeit:" + now +" Count: "+counter,"worker.log");
				if (counter == 10)
					{pw.println("Letzte übertragung");}
				pw.flush();
				pw.close();
				client.close();
				counter++;
			}
		
		System.out.println("10 Verbindungen erreicht Programm wird beendet.");
		logger("Uhrzeit:" + LocalDateTime.now() + "10 Verbindungen erreicht Programm wird beendet.","worker.log");
		} 
		catch (IOException e) 
		{
			logger("Uhrzeit:" + LocalDateTime.now() +"Catch getriggert" ,"error.log");
			e.printStackTrace();
		}
		finally 
		{
			System.out.println("Server gestoppt, bitte Prüfen");
		}
	}
	
	public static void logger (String text, String file)
	{
		try (PrintWriter log = new PrintWriter(new FileWriter(new File ("c:\\Temp\\"+file),true));)
		{
			log.println(text);
			log.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] Args) throws IOException
	{
		TimeServer server = new TimeServer();
		server.time(server.getMy());
	}
}
