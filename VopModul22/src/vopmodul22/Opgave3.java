package vopmodul22;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Opgave3 {

    private PrintWriter outStream;
    private File file;

    public Opgave3(String fname) {
        this.file = new File(fname + ".txt");

        if (this.file.exists()) {
            append("hello kity");
        } else {
            append("Hello world");
        }

    }

    public void empty() {
        try {
            PrintWriter pw = new PrintWriter(this.file);
            pw.print("");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Opgave3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void append(String newText) {
        try {
            this.outStream = new PrintWriter(new FileOutputStream(this.file, true));
            outStream.println(newText);
            this.outStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Opgave3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Opgave3 opg = new Opgave3(input.nextLine());

    }

}
