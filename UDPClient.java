/*
 * UDPClient.java
 * A simple UDP client that sends a message to a server and waits for a response.
 * Source: Lecture 3 by Prof. Shervin Shirmohammadi
 */

import java.io.*; 
import java.net.*;

public class UDPClient {

    public static void main (String[] args) {

        DatagramSocket clientSocket;
        try {
            clientSocket = new DatagramSocket();
            // prepare data to be sent
            String Message = "Hello UDP";
            byte[] Buffer_out = Message.getBytes();
            DatagramPacket packet_out = new DatagramPacket(Buffer_out, Buffer_out.length, InetAddress.getLocalHost(), 53444);
            // send data
            clientSocket.send(packet_out);
            // receive response
            byte[] Buffer_in = new byte[256];
            DatagramPacket packet_in = new DatagramPacket(Buffer_in, Buffer_in.length);
            clientSocket.receive(packet_in);
            String Response = new String(packet_in.getData());
            System.out.println("UDP Server: " + Response);
            clientSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
