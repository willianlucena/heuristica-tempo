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

        String gridTeste =
                "    xxxxx          \n" + // 0 (19)
                "    x...x          \n" + // 1
                "    x*..x          \n" + // 2
                "  xxx..*xx         \n" + // 3
                "  x..*.*.x         \n" + // 4
                "xxx.x.xx.x   xxxxxx\n" + // 5
                "x...x.xx.xxxxx..oox\n" + // 6
                "x.*..*..........oox\n" + // 7
                "xxxxx.xxx.xAxx..oox\n" + // 8
                "    x.....xxxxxxxxx\n" + // 9
                "    xxxxxxx        \n";  //10

        Ambiente ambiente = new Ambiente(gridTeste);
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
