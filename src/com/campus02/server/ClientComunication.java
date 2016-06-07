package com.campus02.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientComunication implements Runnable{
	static Socket client;
	

	@SuppressWarnings("static-access")
	public ClientComunication(Socket client) {
		super();
		this.client = client;
	}

	private static void processClient() {
		try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
			String input = "";
			while ((client.isConnected() && !client.isClosed()) == true && (input = br.readLine()) != null
					&& !input.equalsIgnoreCase("quit")) {
				if (input.equalsIgnoreCase("ping"))
					pw.println("pong");
				else if (input.equalsIgnoreCase("pong"))
					pw.println("ping");
				else
					pw.println("Error");
				pw.flush();
				input.split(" ");
			}
			if (input.equalsIgnoreCase("exit")) {
				pw.println("Exit empfangen, Verbindung beendet.");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		processClient();
		
	}
}
