package com.campus02.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer 
{
	public static void main (String[] Args)
	{
		try (ServerSocket ssocket = new ServerSocket(3333);)
		{
			Socket client;
			while (true){
			client = ssocket.accept();
			processClient(client);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void processClient(Socket client)
	{
		try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())))
			{
			String input;
			while ((client.isConnected() && !client.isClosed()) == true &&(input = br.readLine())!=null)
			{
				if (input.equalsIgnoreCase("ping"))
						pw.println("pong");
				else if (input.equalsIgnoreCase("pong"))
						pw.println("ping");
				else 
					pw.println("Error");
				pw.flush();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
