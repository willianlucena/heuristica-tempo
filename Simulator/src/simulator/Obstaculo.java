/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGMouse;
import ch.aplu.jgamegrid.GGMouseListener;
import ch.aplu.jgamegrid.Location;

/**
 *
 * @author willian
 */
public class Obstaculo extends Actor implements GGMouseListener {

    //auxiliar na inserção do robo no ambiente no momento da configuracao
    private Location lastLocation;
    private boolean isDragging = false;

    public Obstaculo() {
        super("sprite/stone.gif");
    }

    @Override
    public boolean mouseEvent(GGMouse mouse) {
        Location location = gameGrid.toLocationInGrid(mouse.getX(), mouse.getY());
        switch (mouse.getEvent()) {
            case GGMouse.lPress:
                if (gameGrid.getOneActorAt(location) == this) // Must restrict to current instance
                {
                    isDragging = true;
                }
                lastLocation = location.clone();
                break;
            case GGMouse.lDrag:
                if (isDragging && gameGrid.isEmpty(location)) // Prevent to drag at occupied location
                {
                    setLocation(location);
                    lastLocation = location.clone();
                }
                break;
            case GGMouse.lRelease:
                if (isDragging) {
                    setLocation(lastLocation);
                    isDragging = false;
                }
                break;
        }
        gameGrid.refresh();
        return false; // Don't consume the event, other listener must be notified
    }
}
