/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oevelsestime2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Searcher {

    private File inFile;
    private Scanner input;
    private String toPrint = "";
    private PrintWriter pw;

    public Searcher(File file) {

        this.inFile = file;
        this.input = null;
        this.pw = null;

    }

    public String destroyAll(String searchWord, String replaceWord) {
        try {
            this.input = new Scanner(inFile);
            while (input.hasNextLine()) {
                String currentLine = input.nextLine();
                
                if (currentLine.contains(searchWord)) {
                    toPrint += currentLine.replaceAll(searchWord, replaceWord);
                    toPrint += "\n";
                } else {
                    toPrint += currentLine + "\n";
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            input.close();
        }
        System.out.println(toPrint);
        return toPrint;
    }
}
