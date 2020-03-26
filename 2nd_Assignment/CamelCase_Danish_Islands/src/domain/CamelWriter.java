/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        this.inFile = new File("C:\\Users\\Nichlas\\Desktop\\" + fName + ".txt");

    }

    public void readLines() {
        Scanner input = null;
        try {
            input = new Scanner(this.inFile);

            while (input.hasNextLine()) {
                convert2camel(input.nextLine());
            }

            // Benyt en Scanner til at læse inFile én linje ad gangen
            // Kald convert2camel med hver linje.
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally{
            input.close();
        }
    }

    private void convert2camel(String line) {
        try {
            String toPrint = "";
            String[] words;
            String delimiter = " ";
            words = line.split(delimiter);

            if (words.length != 0) {
                toPrint += words[0].toLowerCase();

                for (int i = 1; i < words.length; i++) {
                    char[] toUppercase = words[i].toCharArray();
                    toUppercase[0] = Character.toUpperCase(toUppercase[0]);
                    String newwords = new String(toUppercase);
                    toPrint += newwords;

                }

                System.out.println(toPrint);

                // Split line til et String[] af de enkelte ord i linjen
                // Konverter 1. ord til små og resten til stort begyndelsesbogstav
                // Sammensæt ordene til ét langt ord og udskriv.
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamelWriter cw = new CamelWriter("hello.txt");
        cw.readLines();
    }

}
