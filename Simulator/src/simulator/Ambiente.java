/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.GameGrid;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author extra
 */
public class Ambiente extends GameGrid implements GGActorCollisionListener {

    private static Color ambienteColor = Color.WHITE;

    public Ambiente() {
        super(30, 30, 20, ambienteColor, true);
        this.setBgColor(ambienteColor);
        desenharAmbiente("");
        desenharAtores();

    }

    public void init() {
        ArrayList<Actor> atores = getActors(Robot.class);
        for (int i = 0; i < atores.size(); i++) {
            Actor ac = atores.get(i);
            //ac.act();
            ac.setCollisionCircle(new Point(0, 0), 5);
            ac.addActorCollisionListener(this);
            for (int k = 0; k < getActors(Robot.class).size(); k++) {
                Actor collider = getActors(Robot.class).get(k);
                if (ac != collider) {
                    ac.addCollisionActor(collider);
                }
            }

        }

        show();
    }

    @Override
    public int collide(Actor a, Actor b) {
        if (a instanceof Robot) {
            System.out.print("o robo " + ((Robot) a).getId());
        }
        if (b instanceof Robot) {
            System.out.println(" colidiu com o robo " + ((Robot) b).getId());
        }
        double dir1 = a.getDirection();
        double dir2 = b.getDirection();
        int sd1 = a.getSlowDown();
        int sd2 = b.getSlowDown();
        a.setDirection(dir2);
        a.setSlowDown(sd2);
        b.setDirection(dir1);
        b.setSlowDown(sd1);
        return 5;  // Wait a moment until collision is rearmed

    }

    private void desenharAmbiente(String plantaAmbiente) {
        String gridTeste =
                "    xxxxx          " + // 0 (19)
                "    x...x          " + // 1
                "    x*..x          " + // 2
                "  xxx..*xx         " + // 3
                "  x..*.*.x         " + // 4
                "xxx.x.xx.x   xxxxxx" + // 5
                "x...x.xx.xxxxx..oox" + // 6
                "x.*..*..........oox" + // 7
                "xxxxx.xxx.xAxx..oox" + // 8
                "    x.....xxxxxxxxx" + // 9
                "    xxxxxxx        ";  //10
        if (plantaAmbiente.length() > 0) {
            plantaAmbiente = gridTeste;
        } else {
        }
        //Trazer já o numero de linhas e colunas? ou tentar pegar da string passada?
        //Como será em um arquivo, o readline já iria indicando a quantidade de linhas.
        //Caso seja uma string como a de ex, não tem como saber. A não ser que colocasse um char para dizer que acabou a linha.
    }

    private void desenharAtores() {
        for (int i = 1; i < 4; i++) {
            Robot r = new Robot("r" + i, true);
            this.addActor(r, this.getRandomLocation());
            r.setDirection(new Random().nextInt(360));
        }

//        int stoneIndex = 0;
//        int targetIndex = 0;
//        for (int y = 0; y < nbVertCells; y++) {
//            for (int x = 0; x < nbHorzCells; x++) {
//                Location location = new Location(x, y);
//                int a = grid.getCell(location);
//                if (a == 5) // Sokoban actor
//                {
//                    sok = new SokobanActor();
//                    addActor(sok, location);
//                }
//                if (a == 3) // Stones
//                {
//                    stones[stoneIndex] = new SokobanStone();
//                    addActor(stones[stoneIndex], location);
//                    stoneIndex++;
//                }
//                if (a == 4) // Targets
//                {
//                    targets[targetIndex] = new SokobanTarget();
//                    addActor(targets[targetIndex], location);
//                    targetIndex++;
//                }
//            }
//        }
//        setPaintOrder(SokobanTarget.class);
    }

}
