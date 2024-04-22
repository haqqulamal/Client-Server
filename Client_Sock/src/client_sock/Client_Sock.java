package client_sock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client_Sock {

    public static void main(String[] args) {
        try 
        {
            Socket socket = new Socket("localhost", 9999);
            PrintStream output = new PrintStream(socket.getOutputStream());
            
            System.out.print("Enter the radius of the circle: ");
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(rd);
            
            String radiusStr = input.readLine();
            output.println(radiusStr);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();
            
            System.out.println("Server response: " + response);
            
            socket.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
