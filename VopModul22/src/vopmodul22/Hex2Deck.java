/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vopmodul22;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hex2Deck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a hex: ");
        String hex = sc.nextLine();
        while ((!hex.equalsIgnoreCase("quit"))) {

            try {
                System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
            } catch (HexFormatException ex) {
                Logger.getLogger(Hex2Deck.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            }
            hex = sc.nextLine();
        }

    }

    public static int hexToDecimal(String hex) throws HexFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if (hexChar > 'F') {
                throw new HexFormatException("Not a hex String...");
            } else {
                decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);

            }
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else {
            return ch - '0';
        }
    }

}
