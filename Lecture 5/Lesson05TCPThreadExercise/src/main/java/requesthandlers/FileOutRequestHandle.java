package requesthandlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOutRequestHandle extends AbstractRequestHandler {

    private String fileName;

    public FileOutRequestHandle(Socket socket, String fileName) {
        super(socket);
        this.fileName = fileName;


    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());
        try (Scanner scanner = new Scanner(socket.getInputStream());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Type your message:");
            String flipped = "";
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(fileName), true));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                pw.append(new Date() + "\t" + socket.getInetAddress() + ":" + socket.getPort() + "\t" + line + "\n");
                pw.close();

            }

            System.out.println("RequestHandler DONE!!!!");
        } catch (IOException ex) {
            Logger.getLogger(FlipRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
