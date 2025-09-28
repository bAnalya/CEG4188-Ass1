/*
 * TCPClient.java
 * A simple TCP client that connects to a server on localhost at port 53333,
 * sends a predefined message, and prints the server's response.
 * Source: Lecture 3 by Prof. Shervin Shirmohammadi
 */

import java.io.*; 
import java.net.*;

public class TCPClient {

	public static void main (String[] args) {
        
		try {
			//establish connection to server
			Socket clientSocket = new Socket("localhost", 53333);
			// get output and input streams and advanced streams
			OutputStream os = clientSocket.getOutputStream();
			PrintWriter out = new PrintWriter(os, true);
			InputStream is = clientSocket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			// send token
			out.println("Hello TCP");
			// read response
			System.out.println("Server: " + in.readLine());
			// close resources
			out.close();
			in.close();
			clientSocket.close();
		
		} catch (IOException e) { // catch possible io exceptions
			e.printStackTrace();
		}
	}

}
