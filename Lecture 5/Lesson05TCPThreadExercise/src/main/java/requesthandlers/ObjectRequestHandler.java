package requesthandlers;

import saviich_10_9.Species;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectRequestHandler extends AbstractRequestHandler  {

    public ObjectRequestHandler(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        Species readOne;
        int records = 0;
        System.out.println("RequestHandler started for " + socket.getPort());
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Type object file name:");

            while(true){
                readOne = (Species) ois.readObject();
                System.out.println(readOne);
                System.out.println();
                records++;
            }

        } catch (EOFException e){
            System.out.println("Reading done" + records);
        } catch (IOException ex) {
            Logger.getLogger(FlipRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
