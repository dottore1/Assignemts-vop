/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vopoevelsestime1;

/**
 *
 * @author Nichlas
 */
public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
        String message;
        char[] chars = original.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (int k = 0; k < AbstractCipher.ALPHABETH.length; k++) {
                if (temp == AbstractCipher.ALPHABETH[k]) {
                    char newChar = ALPHABETH[ALPHABETH.length - (k + 1)];
                    chars[i] = newChar;

                }

            }
        }

        message = String.valueOf(chars);

        return message;
    }

    @Override
    public String decrypt(String encrypted) {
       return this.encrypt(encrypted);
       /* String message;
        char[] chars = encrypted.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            char temp = chars[i];
            for (int k = 0; k < AbstractCipher.ALPHABETH.length; k++) {
                if (temp == AbstractCipher.ALPHABETH[k]) {
                    char newChar = ALPHABETH[Math.abs(k - ALPHABETH.length)];
                    chars[i] = newChar;

                }

            }
        }
        message = String.valueOf(chars);

        return message;
    }
*/
    }
}
