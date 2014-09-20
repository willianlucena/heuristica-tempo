/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.GGMouse;
import ch.aplu.jgamegrid.GGMouseListener;
import ch.aplu.jgamegrid.GameGrid;
import java.awt.Color;

/**
 *
 * @author willian
 */
public class GridConfig extends GameGrid implements GGActorCollisionListener, GGMouseListener {

    public GridConfig() {
        super(30, 30, 20, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
    }
    
    public GridConfig(int nbHorzCells, int nbVertCells, int cellSize) {
        super(nbHorzCells, nbVertCells, cellSize, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
    }
   
    @Override
    public int collide(Actor actor, Actor actor1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mouseEvent(GGMouse ggm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
