package tcp_server_runnable;

import saviich_10_9.Species;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientObject {
    public static void main(String[] args) {
        String str;
        Species object;
        Scanner inputStream = null;
        ObjectOutputStream outputStream = null;

        try (Socket clientSocket = new Socket("localhost", 3336);
             Scanner keyboard = new Scanner(System.in)) {
            // Set up streams to send/receive data
            inputStream = new Scanner(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // Start massage from server:
            System.out.println(inputStream.nextLine());
            // Read a line from the keyboard:
            String name = keyboard.next();
            int ip = Integer.parseInt(keyboard.next());
            double igr = Double.parseDouble(keyboard.next());
            object = new Species(name, ip, igr);
            outputStream.writeObject(object);

            // Read answer from the server and output it to the screen
            str = inputStream.nextLine();
            System.out.println(str);

        } catch (Exception e) {
            // If any exception occurs, display it
            System.out.println("Error " + e);
        } finally {
            inputStream.close();
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
