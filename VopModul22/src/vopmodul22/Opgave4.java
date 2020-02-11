/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vopmodul22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Opgave4 {

    private Scanner input;
    private File file;

    public Opgave4() throws FileNotFoundException {
        this.file = new File("Doubles.txt");
        this.input = new Scanner(file);

    }

    public void readFile() {
        double[] doubles = new double[20];
        double sum = 0;
        while (input.hasNextLine()) {
            int i = 0;
            int k = 0;
            String temp = input.nextLine();
            double converted = Double.parseDouble(temp);
            doubles[i] = converted;
            System.out.println(doubles[i]);
            sum += doubles[i];
            i++;
            
           

        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        try {
            Opgave4 opg = new Opgave4();
            opg.readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Opgave4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
