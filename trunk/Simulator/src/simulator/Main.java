/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.awt.EventQueue;
import java.util.Random;

/**
 *
 * @author extra
 */
public class Main {

    public Main() {
        Ambiente ambiente = new Ambiente();
        for (int i = 1; i < 4; i++) {
            Robot r = new Robot("r" + i, true);
            ambiente.addActor(r, ambiente.getRandomLocation());
            r.setDirection(new Random().nextInt(360));
        }

        ambiente.init();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });
    }
}
