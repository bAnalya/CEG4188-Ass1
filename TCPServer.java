/*
 * TCPServer.java
 * A simple TCP server that listens for incoming connections on port 53333,
 * reads a message from the client, and responds with a predefined message.
 * The server runs indefinitely, handling one client connection at a time.  
 * Source: Lecture 3 by Prof. Shervin Shirmohammadi
 */
import java.io.*; 
import java.net.*;

public class TCPServer {

	public static void main (String[] args) {
		try {
            // create server socket listening on port 53333
            ServerSocket serverSocket = new ServerSocket(53333);
			System.out.println("TCP Server started and listening on port 53333...");
            while (true) {
                // wait for incoming connection requests
                Socket client = serverSocket.accept();
                // get output and input streams and advanced streams
                OutputStream os = client.getOutputStream();
                InputStream is = client.getInputStream();
                PrintWriter out = new PrintWriter(os, true);
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                // read message from client and send response
                String Message = in.readLine();
                System.out.println("Client: " + Message);
                out.println("Back at you TCP");
                // close resources
                out.close(); 
                in.close(); 
                client.close();
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
