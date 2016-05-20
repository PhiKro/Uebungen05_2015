package com.campus02.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main (String Args[])
	{
		try (ServerSocket ssocket = new ServerSocket(2222))
		{
			while (true) 
			{
				int count= 0;
				try 
				(
				Socket client = ssocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); 
				PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
				)
				{
				String echo;
				while ((echo = br.readLine()) !=null && ++count < 3)
				{
					if (echo.equalsIgnoreCase("Hallo Echo"))
					{
						pw.println("Hallo Otto");
					}
					else 
						{pw.println(echo);}
					pw.flush();
					
				}
				System.out.println("connection closed");
			}
		} 
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}	
	}
}
