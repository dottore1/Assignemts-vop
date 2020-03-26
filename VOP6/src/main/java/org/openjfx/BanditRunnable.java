package org.openjfx;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class BanditRunnable implements Runnable {

    private int i; //Index of current picture
    private long sleepTime;
    private boolean running;
    private ImageView iw;
    private Image[] images;
    private Random random;

    public BanditRunnable(int i, long sleepTime, ImageView iw, Image[] images) {
        this.i = i;
        this.sleepTime = sleepTime;
        this.iw = iw;
        this.images = images;
        random = new Random();
    }

    @Override
    public void run() {
        // Code the animation here....
        try {

            while(true) {
                running = true;
                iw.setImage(images[(i + random.nextInt(9)) % images.length]);
                Thread.sleep(sleepTime);
            }

        } catch (InterruptedException e){
            running = false;
        }


    }


}
