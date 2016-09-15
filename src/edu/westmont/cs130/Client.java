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
		System.out.println("Prof. Patterson");
		System.out.println("Hi this is James Solum");
		System.out.println("Hi this is Caleb Armacost");
   		System.out.println("Bryan Miner");
		System.out.println("Matthew Coffman");
		System.out.println("Jon Skidanov is here");
		System.out.println("This is Jacob Ochs");
		System.out.println("Mark Carlson");
		System.out.println("Bethany was here :)");
		System.out.println("Matthew Beall!!!!11!!11!!!!!1!;)");
		System.out.println("This is Ryan Kleinberg");
		new Client("192.168.1.97", 8888);
	}
}
