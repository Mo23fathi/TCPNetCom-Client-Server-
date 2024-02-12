
package network;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
  
// Server class
class Server {
    public static void main(String[] args)
    {
        ServerSocket server = null;
  
        try {
  
            // server is listening on port 1234
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
  
            // running infinite loop for getting
            // client request
            while (true) {
  
                // socket object to receive incoming client
                // requests
                Socket client = server.accept();
  
                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                                   + client.getInetAddress()
                                         .getHostAddress());
  
                // create a new thread object
                ClientHandler clientSock
                    = new ClientHandler(client);
  
                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
  
    // ClientHandler class
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
  
        // Constructor
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }
  
        @Override
        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                //  Scanner sc = new Scanner(System.in);  
                  // get the outputstream of client
                out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
                 Scanner inFromServer = new Scanner(System.in);  //gg
                  // get the inputstream of client
                in = new BufferedReader(
                    new InputStreamReader(
                        clientSocket.getInputStream()));
  
                
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
             
             String name = in.readLine(); // recieving client name
                System.out.println("the name of the new client is "+name);
                
                String l = in.readLine();
                if(l.equals("1")) {
                
                    System.out.println("the client "+name+" in  calculator mode");
                    String input;
                       while (true)
        {
        
            input = dis.readUTF();
          
            if(input.equals("bye")){
                break;}
  
            System.out.println("Equation received: " + input);
            int result;
  
            // Use StringTokenizer to break the equation into operand and
            // operation
            StringTokenizer st = new StringTokenizer(input);
  
            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());
  
            // perform the required operation.
            if (operation.equals("+"))
            {
                result = oprnd1 + oprnd2;
            }
  
            else if (operation.equals("-"))
            {
                result = oprnd1 - oprnd2;
            }
            else if (operation.equals("*"))
            {
                result = oprnd1 * oprnd2;
            }
            else
            {
                result = oprnd1 / oprnd2;
            }
            System.out.println("Sending the result to " + name );
  
            // send the result back to the client.
            dos.writeUTF(Integer.toString(result));
        
        }
                    
                    
            } else{
                    
                
                
                
                    System.out.println("the client "+name+ " in  texting mode ");
                String line;
                while (true) {
                    line = in.readLine();
                    if ( line.isEmpty() != true ){
                      if(line.equals("bye")){
                break;}
                    // writing the received message from
                    // client
                    System.out.println( name+ "  Sent  :  "  +line);
                      //  System.out.println("line :"+line.isEmpty());
                    //out.println(line);
                    
                     System.out.print("Server: "); //gg
                     String output = inFromServer.nextLine(); //gg
                     out.println(output);//sending to client
                    }
                }}
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
