/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Doubles {

    private Scanner input;
    private File file;

    public Doubles() throws FileNotFoundException {
        this.file = new File("Doubles.txt");
        this.input = new Scanner(file);

    }

    public void readFile() {
        double[] doubles = new double[20];
        double sum = 0;
        int i = 0;
        while (input.hasNextLine()) {
            String temp = input.nextLine();
            double converted = Double.parseDouble(temp);
            doubles[i] = converted;
            sum += doubles[i];
            i++;
        }

        double tempmin = 0;
        double tempmax = 0;

        for (int k = 0; k < 19; k++) {
            tempmin = doubles[0];
            if (tempmin > doubles[k + 1]) {
                tempmin = doubles[k + 1];

            }
            tempmax = doubles[0];
            if (tempmax < doubles[k + 1]) {
                tempmax = doubles[k + 1];

            }
        }
        System.out.println(tempmin);
        System.out.println(tempmax);
        System.out.println(sum);
        System.out.println(sum / 20);

    }

    public static void main(String[] args) {
        try {
            Doubles opg = new Doubles();
            opg.readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Doubles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
