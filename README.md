Assignment 1 – TCP and UDP Client-Server Programs

**Course:** CEG4188   

**Student Name:** Baya Manal

**Professor:** Prof. Shervin Shirmohammadi

**Date:** September 29, 2025


This repository contains simple Java client-server programs that demonstrate socket programming using both **TCP** and **UDP**.

---

Files

TCPServer.java – Listens on port 53333, receives "Hello TCP", replies "Back at you TCP".

TCPClient.java – Connects to port 53333, sends "Hello TCP", prints server reply.

UDPServer.java – Listens on port 53444, receives "Hello UDP", replies "back at you UDP".

UDPClient.java – Sends "Hello UDP" to port 53444, prints server reply.

---

How to Compile

From the project directory, run:

```
javac TCPServer.java TCPClient.java UDPServer.java UDPClient.java
```

This will generate the corresponding .class files.

---

How to Run

+ TCP Example

1. Start the server:
  ```
   java TCPServer
```
2. In another terminal, start the client:
```
   java TCPClient
```
3. Expected output:

  + Server:
  ```
     TCP Server started and listening on port 53333...
     Client connected.
     Client: Hello TCP
  ```
  + Client:

```
     Server: Back at you TCP
```



