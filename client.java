/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package network;
import java.io.*;
import java.net.*;
import java.util.*;
  
// Client class
class Client {
    
    // driver code
    public static void main(String[] args)
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1234)) {
            Scanner sc = new Scanner(System.in); 
            // writing to server
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
  
            // reading from server
            BufferedReader in
                = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            // Step 2: Communication-get the input and output stream
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                System.out.println("please enter the client name:");
                String name =sc.nextLine();
                out.println(name);
  
            System.out.println("enter 1 for calculator ");
            System.out.println("enter 2 for texting  ");
             int g =sc.nextInt();
             if (g==1 || g==2 ){
             String h = String.valueOf(g) ;  
            out.println(h);
            Scanner scc = new Scanner(System.in); 
            switch(g){
                
                case 1:
            while (true)
		{
			// Enter the equation in the form-
			// "operand1 operation operand2"
			System.out.print("Enter the equation in the form: ");
			System.out.println("'operand operator operand'");

                      //  sc.nextLine();
			String inp = scc.nextLine();
                       // inp = sc.nextLine();

			if (inp.equals("bye")){
				break;}
                
			// send the equation to server
			dos.writeUTF(inp);
                       // out.println(inp);
			// wait till request is processed and sent back to client
			String ans = dis.readUTF();
                         //String ans  =  in.readLine() ;
			System.out.println("Answer=" + ans);
		
                }
            
            
            
                case 2:
            // object of scanner class
            //Scanner sc = new Scanner(System.in);
            String line = null;
            String li = null;
     //System.out.print("client " + name+" :" );
                // reading from user
                li = sc.nextLine();  
                // sending the user input to server 
                out.println(li);
            while (!"bye".equalsIgnoreCase(line)) {
                System.out.print("client " + name+" :" );
                // reading from user
                line = sc.nextLine();
  
                // sending the user input to server
               
                out.println(line);
                out.flush();
              
  
                // displaying server reply
                System.out.println("Server replied "
                                   + in.readLine());
            }}}else{
                 System.out.println("wrong input");
             }
            
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
