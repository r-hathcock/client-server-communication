import java.io.*;
import java.net.*;

public class ClientSide
{
    public static void main (String[] args)
    {
        // prompts user for valid input
        if (args.length != 3)
        {
            System.out.println("Simple Client Side Communication"); 
            System.out.println("Input desired host IP address, port, and message");
            System.out.println("Usage: java ClientSide [Hostname] [port] [message]");
            System.exit(0);
        }

        String serverIp = args[0]; 
        int serverPort = Integer.parseInt(args[1]);
        String message = args[2];

        try 
        {                   
            Socket s = new Socket(serverIp, serverPort); // wait for server to accept
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); // gets outputstream from server
            dos.writeUTF(message); // sends message through datastream
            dos.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

