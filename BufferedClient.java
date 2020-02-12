import java.io.*;
import java.net.*;
import java.util.*;

public class BufferedClient
{
   public static void main (String[] args)
    {
        // prompts user until valid input
        if (args.length < 3)
        {
           System.out.println("Usage: java ClientSide Hostname port message");
           System.exit(0);
        }
        try 
        {
            String serverIp = args[0];
            int serverPort = Integer.parseInt(args[1]);
            Socket s = new Socket(serverIp, serverPort);
            OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(args[2]); // Send message to server.
            bw.close(); // flush
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
