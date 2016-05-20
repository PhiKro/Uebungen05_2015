package com.campus02.client;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) 
	{
		try (
			Socket client = new Socket("127.0.0.1",2222);
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));	
			)
		{
			String input;
			String output ="";
			while (!(input = line.readLine()).equalsIgnoreCase("quit") && (!output.equals("null")))
			{
				pw.println(input);
				pw.flush();
				output =br.readLine();
				if (output == null)
				{
					System.out.println("Gegenstelle hat die Verbindung beendet");
					System.exit(0);
				}
				else 
				{
				System.out.println(output);
				}
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
