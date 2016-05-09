package com.campus02.server;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {
	
	ServerSocket my;
	
	public TimeServer() throws IOException
	{
		ServerSocket my = new ServerSocket(8045);
		System.out.println("Server Running!");	
	}
	
	public ServerSocket getMy() {
		return my;
	}



	public void setMy(ServerSocket my) {
		this.my = my;
	}



	public void time (ServerSocket my) throws IOException
	{

		System.out.println("loop");
		while (true)
		{
			Socket client = null;
		try		
			{
				client = my.accept();
				PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
				LocalDateTime now = LocalDateTime.now();
				pw.println(now);
				pw.flush();
				pw.close();
				client.close();
			}
		finally
		{
		}
		}
		
	}

	public static void main(String[] Args) throws IOException
	{
		TimeServer server = new TimeServer();
		server.time(server.getMy());
	}
}
