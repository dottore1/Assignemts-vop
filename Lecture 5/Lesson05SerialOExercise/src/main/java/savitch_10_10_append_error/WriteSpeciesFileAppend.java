package savitch_10_10_append_error;


import saviich_10_9.Species;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class WriteSpeciesFileAppend {

    public static void main(String[] args) {
        String fileName = getFileName("Enter output file name.");
        File file = new File(fileName);
        List<Species> list = new LinkedList<>();
        if (file.exists()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName, true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            }) {
                Species califCondor
                        = new Species("Calif. Condor", 27, 0.02);
                outputStream.writeObject(califCondor);

                Species blackRhino
                        = new Species("Black Rhino", 100, 1.0);
                outputStream.writeObject(blackRhino);
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } else try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName, true))) {
            Species blackRhino
                    = new Species("Black Rhino", 100, 1.0);
            outputStream.writeObject(blackRhino);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Records sent to file "
                + fileName + ".");
        System.out.println(
                "Now let's reopen the file and echo the records.");

        Species readOne;
        int records = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(fileName))) {

            while (true) {  //Reads untill EOF
                readOne = (Species) inputStream.readObject();
                System.out.println(readOne);
                System.out.println();
                records++;
            }
        } catch (EOFException eof) {
            System.out.println("Reading Done! " + records);

        } catch (IOException e) {
            System.err.println("Error opening input file "
                    + fileName + ": " + e.getMessage());
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

    }

    private static String getFileName(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        String fileName = null;
        System.out.println(prompt);
        fileName = keyboard.next();

        return fileName;
    }
}
