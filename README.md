Network Communication Java Project
This Java project consists of two files: Client.java and Server.java, which facilitate communication between a client and a server over a network. The project allows clients to connect to the server, perform simple arithmetic calculations, and exchange text messages.

Client.java
The Client.java file represents the client-side of the network communication. It establishes a connection with the server, sends input to the server, and receives responses. The functionalities of the client 

include:

Connecting to the server via the provided host and port number.
Providing a client name to the server.
Offering options for the client to choose between a calculator mode (option 1) and a text messaging mode (option 2).
Sending arithmetic expressions or text messages to the server based on the chosen mode.
Receiving responses from the server and displaying them.
Server.java
The Server.java file represents the server-side of the network communication. It listens for incoming client connections, handles multiple clients concurrently using threads, and processes client requests. The functionalities of the server include:

Listening for client connections on port 1234.
Accepting connections from multiple clients and assigning a dedicated thread to each client.
Receiving client names and processing them.
Offering calculator functionality to clients, where clients can send arithmetic expressions, and the server evaluates and returns the results.
Providing text messaging functionality, allowing clients to exchange text messages with the server.


Usage:

Client Interaction:
Run the Server.java file to start the server.
Run the Client.java file to start a client.
Connect the client to the server by providing the host (usually "localhost") and port number (1234).
Enter the client name when prompted.
Choose between calculator mode (option 1) or text messaging mode (option 2).
Follow the prompts to perform arithmetic calculations or exchange text messages.

Dependencies
Java sockets for network communication.
Input/output streams for data transmission.
Threads for handling multiple clients concurrently.
