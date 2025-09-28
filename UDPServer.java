/*
 * UDPServer.java
 * A simple UDP server that listens for incoming datagrams on port 53444,
 * reads a message from the client, and responds with a predefined message.
 * The server runs indefinitely, handling one datagram at a time.  
 * Source: Lecture 3 by Prof. Shervin Shirmohammadi
 */

import java.io.*; 
import java.net.*;

public class UDPServer {
    public static void main (String[] args) {
        DatagramSocket serverSocket;
        try {
            serverSocket = new DatagramSocket(53444);
            System.out.println("UDP server started and listening on port 53444...");
    
            byte[] Buffer_in = new byte[256];
            DatagramPacket packet_in = new DatagramPacket(Buffer_in, Buffer_in.length);
            
            while (true) {
                serverSocket.receive(packet_in);
                String Message = new String(packet_in.getData());
                System.out.println("Client: " + Message);
                // send response
                String Response = "Back at you UDP";
                byte[] Buffer_out = Response.getBytes();
                DatagramPacket packet_out = new DatagramPacket(Buffer_out, Buffer_out.length, packet_in.getAddress(), packet_in.getPort());
                serverSocket.send(packet_out);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
