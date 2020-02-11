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
public abstract class AbstractCipher implements CipherInterface {

    protected int findCharIndex(char ch) {
        int temp = -1;
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ch == ALPHABETH[i]) {
                temp = i;

            }

        }
        return temp;
    }

}
