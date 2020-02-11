package com.mycompany.vopoevelsestime1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {

    TextField textMessage;
    TextField textEncrypt;
    TextField textDecrypt;
    TextField textRounds;
    Button btnEncrypt;
    Button btnDecrypt;
    RadioButton rbAtbash;
    RadioButton rbCaesar;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void actionHandler() {
        CipherInterface ab;
        int rounds = 12;

        ab = (CipherInterface) new CeasarCipher(rounds);
        System.out.println();
        String encrypted = ab.encrypt("hello");
        System.out.println(encrypted);

    }

}
