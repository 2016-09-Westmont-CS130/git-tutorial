package edu.westmont.cs130;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public Client(String destinationIP, int destinationPort){
		Socket s = null;
		PrintWriter out;
		
		try {
			System.out.println("Connecting...");
			s = new Socket(destinationIP,destinationPort);
			
			out = new PrintWriter(s.getOutputStream());
    		System.out.println("\t ...connected.");
    		
    		out.println("Hello world");
    		out.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args){

		System.out.println("Matthew Coffman");

		System.out.println("Jon Skidanov is here");

		new Client("192.168.1.97", 8888);
	}
}
