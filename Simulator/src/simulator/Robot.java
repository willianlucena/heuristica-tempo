/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.Location;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author extra
 */
public class Robot extends Actor {

    String id;
    boolean noSul = false;
    private boolean showId = false;

    public Robot(String id, boolean showId) {
        this(id);
        this.showId = showId;
    }

    public Robot(String id) {
        super(true, Robotfill.getFill());
        this.id = id;
        this.setSlowDown(new Random().nextInt(2));
    }

    public String getId() {
        return id;
    }

    public void varredura() {
        if (isMoveValid()) {
            move();
        } else {
            Location myLocation = getLocation();

            if (myLocation.y > gameGrid.nbVertCells - 2) { // estou no sul
                noSul = true;
            } else if (myLocation.y < 1) { // estou no norte
                noSul = false;
            }

            if (myLocation.x > gameGrid.nbHorzCells - 2) { // estou na leste
                if (noSul) {
                    setDirection(Location.NORTH);
                    move();
                    setDirection(Location.WEST);
                } else {
                    setDirection(Location.SOUTH);
                    move();
                    setDirection(Location.WEST);
                }

            } else if (myLocation.x < 1) { // estou no oeste
                if (noSul) {
                    setDirection(Location.NORTH);
                    move();
                    setDirection(Location.EAST);
                } else {
                    setDirection(Location.SOUTH);
                    move();
                    setDirection(Location.EAST);
                }

            }
        }
    }

    public void esquerda() {
        setDirection(getDirection() + 270);
        if (isMoveValid()) {
            move(1);
        }
    }

    public void direita() {
        setDirection(getDirection() + 90);
        if (isMoveValid()) {
            move(1);
        }
    }

    public void frente() {
        if (isMoveValid()) {
            move(1);
        }
    }

    public void tras() {
        setDirection(getDirection() + 180);
        if (isMoveValid()) {
            move(1);
        }
    }

    @Override
    public void act() {
        if (showId) {
            showId(false);
        }
        showNextSprite();
        varredura();
    }

    private void showId(boolean showIndex) {
        this.getBackground().clear();
        ArrayList<Actor> atores = gameGrid.getActors(Robot.class);
        for (int i = 0; i < atores.size(); i++) {
            Robot robot = (Robot) atores.get(i);
            Point pt = gameGrid.toPoint(robot.getLocation());
            pt.x -= 5;
            pt.y -= 11;
            this.getBackground().setPaintColor(Color.BLACK);
            this.getBackground().setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 12));
            if (showIndex) {
                this.getBackground().drawText(String.format("%s [ %s ]", robot.getId(), i), pt);
            } else {
                this.getBackground().drawText(String.format("%s", robot.getId()), pt);
            }

        }
    }
}
