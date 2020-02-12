import java.io.*;
import java.net.*;

public class ServerSide 
{
    public static void main (String[] args)
    {
        try 
        {
            ServerSocket ss = new ServerSocket(3250); // specify port number.
            System.out.println("Simple Serverside communication"); 
            System.out.println("Server listening at " +
                                InetAddress.getLocalHost() + // gets server IP address
                                " on port " + ss.getLocalPort()); // gets socket's port
            while (true)
            {
                Socket s = ss.accept(); //wait for new client to call
                DataInputStream dis = new DataInputStream(s.getInputStream()); // gets input stream from client side
                String message = dis.readUTF(); // retrieves message from Client Side
                System.out.println(message);
            }                           
        }                                 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   
}   