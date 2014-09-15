/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.awt.EventQueue;

/**
 *
 * @author extra
 */
public class Main {

    public Main() {
        Ambiente ambiente = new Ambiente("src/simulator/grid.txt");
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
