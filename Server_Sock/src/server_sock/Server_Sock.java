package server_sock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Sock {

    public static void main(String[] args) {
        
        try
        {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server is running...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String radiusStr = input.readLine();
                
                double radius = Double.parseDouble(radiusStr);
                double area = Math.PI * radius * radius;
                
                PrintStream output = new PrintStream(socket.getOutputStream());
                output.println("Area of the circle with radius " + radius + " is " + area);
                
                socket.close();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
