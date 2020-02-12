import java.io.*;
import java.net.*;
import java.util.*;

public class BufferedServer
{
   public static void main (String[] args)
    {
        try 
        {
            int portNumber = 0; // let the system find an available port to use.
            ServerSocket ss = new ServerSocket(portNumber);

            System.out.println("Server listening at " +
                                InetAddress.getLocalHost() +
                                " on port " + ss.getLocalPort());
            while (true)
            {
                Socket s = ss.accept(); // wait here for a client to call
                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String msg = br.readLine();
                System.out.println(msg);
            }                           
        }                                 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   
}       
