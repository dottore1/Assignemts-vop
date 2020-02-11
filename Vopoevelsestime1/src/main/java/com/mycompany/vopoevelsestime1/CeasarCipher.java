/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vopoevelsestime1;

import java.util.*;
import java.lang.*;

public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public int getRotFactor() {
        return rotFactor;
    }

    public void setRotFactor(int rotFactor) {
        this.rotFactor = rotFactor;
    }

    public CeasarCipher(int factor) {
        if (factor >= 0 && factor < CipherInterface.ALPHABETH.length) {
            this.rotFactor = factor;
        }
    }

    public String encrypt(String message) {
        String text;
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int currentIndex = findCharIndex(chars[i]);
            int newIndex = currentIndex + rotFactor;
            char temp = chars[i];
            char newChar = ALPHABETH[newIndex % 52];
            for (int x = 0; x < ALPHABETH.length; x++) {
                if (chars[i] != ALPHABETH[x]) {

                } else {
                    chars[i] = newChar;
                }
            }

        }

        //for (int x = 0; x < chars.length; x++) {
        //   char temp2 = chars[x];
        // for (int i = 0; i < CipherInterface.ALPHABETH.length; i++) {
        //   if (temp2 == CipherInterface.ALPHABETH[i]) {
        // char temp = chars[i % CipherInterface.ALPHABETH.length];
        //     char temp3 = CipherInterface.ALPHABETH[(rotFactor) % CipherInterface.ALPHABETH.length + (i % CipherInterface.ALPHABETH.length)];
        //   chars[x] = temp3;
        // }
        // }
        //}
        text = String.valueOf(chars);
        return text;

    }

    public String decrypt(String decrypt) {
        String text;
        char[] chars = decrypt.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int currentIndex = findCharIndex(chars[i]);
            int newIndex = Math.abs(currentIndex - rotFactor);
            char newChar = ALPHABETH[newIndex % 52];
            for(int x = 0; x < ALPHABETH.length; x++){
                if(chars[i] != ALPHABETH[x]){
                    
                } else{
                    chars[i] = newChar;
                }
                
            } 
            
        }
        text = String.valueOf(chars);
        return text;
    }

}
