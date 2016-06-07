package com.campus02.client;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {

	public static void main(String[] args) 
	{
		try (Socket toserver = new Socket("127.0.0.1",3333);
				PrintWriter pw = new PrintWriter(new BufferedOutputStream(toserver.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(toserver.getInputStream()));
				BufferedReader line = new BufferedReader(new InputStreamReader(System.in))
				)
		{
			String input;
			String output ="";
			while (!(input =line.readLine()).equalsIgnoreCase("quit"))
			{
			pw.println(input);
			pw.flush();
			output = br.readLine();
			System.out.println(output);
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
