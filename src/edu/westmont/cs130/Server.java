package edu.westmont.cs130;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {

		final int PORT = 8888;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Waiting for clients to connect...");

		try{
			while (true) {
				Socket s = null;
			
				s = server.accept();
				System.out.println("Client connected.");
				
				Scanner in = null;
				try {
					in = new Scanner(s.getInputStream());
					while(in.hasNextLine()){
						System.out.println(in.nextLine());
					}
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				finally{
					if(in != null){
						in.close();
					}
				}
			}
		}finally{
			if(server != null){
				server.close();
			}
		}
	}
}
