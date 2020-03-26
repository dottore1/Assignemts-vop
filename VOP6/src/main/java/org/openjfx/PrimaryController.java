package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    ImageView img1;
    @FXML
    ImageView img2;
    @FXML
    ImageView img3;
    Thread thread1;
    Thread thread2;
    Thread thread3;
    @FXML
    private Button start;
    @FXML
    private Button stop1;
    @FXML
    private Button stop2;
    @FXML
    private Button stop3;
    @FXML
    private Label result;
    private Image[] images;


    private int counter;

    private Random magicNumber;

    @FXML
    private void handleStart(ActionEvent event) {
        stop1.setDisable(false);
        stop2.setDisable(false);
        stop3.setDisable(false);

        thread1 = new Thread(new BanditRunnable(1, magicNumber.nextInt(150), img1, images));
        thread2 = new Thread(new BanditRunnable(1, magicNumber.nextInt(110), img2, images));
        thread3 = new Thread(new BanditRunnable(1, magicNumber.nextInt(130), img3, images));



/*

         thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                    img1.setImage(images[magicNumber.nextInt(10)]);
                    Thread.sleep(magicNumber.nextInt(1500));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

         thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        img2.setImage(images[magicNumber.nextInt(10)]);
                        Thread.sleep(magicNumber.nextInt(1500));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
         thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        img3.setImage(images[magicNumber.nextInt(10)]);
                        Thread.sleep(magicNumber.nextInt(1500));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
*/
        start.setDisable(true);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @FXML
    private void handleStop(ActionEvent event) {
        if (event.getSource() == stop1) {
            thread1.interrupt();
            stop1.setDisable(true);
        }
        if (event.getSource() == stop2) {
            thread2.interrupt();
            stop2.setDisable(true);
        }
        if (event.getSource() == stop3) {
            thread3.interrupt();
            stop3.setDisable(false);
            checkCondition();
            start.setDisable(false);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        images = new Image[10];
        for (int i = 0; i < 10; i++) {
            images[i] = new Image(new File("fruits" + i + ".png").toURI().toString());
        }

        img1.setImage(images[1]);
        img2.setImage(images[2]);
        img3.setImage(images[3]);
        magicNumber = new Random();
    }


    public synchronized int getCounter() {
        return this.counter;
    }

    public void checkCondition() {
        if (img1.getImage() == img2.getImage() && img1.getImage() == img3.getImage()) {
            result.setText("Jackpot.. You win");
        } else if (img1.getImage() == img2.getImage() | img2.getImage() == img3.getImage() | img1.getImage() == img3.getImage()) {
            result.setText("Very nice Try, 2 identical. You need 3... ");
        } else {
            result.setText("That's bad... None identical");
        }
    }


}
