package com.campus02.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {
	public static void main(String[] Args) {
		try (ServerSocket ssocket = new ServerSocket(3333);) {
			Socket client;
			while (true) {
				client = ssocket.accept();
				ClientComunication cc = new ClientComunication(client);
				Thread th = new Thread(cc);
				th.start();
				//processClient(client);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
