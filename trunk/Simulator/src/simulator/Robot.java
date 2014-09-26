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
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author extra
 */
public class Robot extends Actor implements GGMouseListener {

    String id; //nome robo
    boolean noSul = false;
    private boolean showId = false;

    //propriedade presente no robo da heuristica
    private Set<String> sabeRobot = new TreeSet<>();
    private Set<String> fazRobot = new TreeSet<>();
    private Integer peso = 0;
    private Integer tempoRobot = 0;
    private Integer tempoTrabalhoRobot = 0;

    //auxiliar na inserção do robo no ambiente no momento da configuracao
    private Location lastLocation;
    private boolean isDragging = false;

    public Robot(String id, boolean showId) {
        this(id);
        this.showId = showId;
    }

    public Robot(String id) {
        //super(true, Robotfill.getFill());
        super("sprite/robot_0.gif");
        this.id = id;
        //this.setSlowDown(new Random().nextInt(2));
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

    public Set<String> getSabeRobot() {
        return sabeRobot;
    }

    public void setSabeRobot(Set<String> sabeRobot) {
        this.sabeRobot = sabeRobot;
    }

    public Set<String> getFazRobot() {
        return fazRobot;
    }

    public void setFazRobot(Set<String> fazRobot) {
        this.fazRobot = fazRobot;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getTempoRobot() {
        return tempoRobot;
    }

    public void setTempoRobot(Integer tempoRobot) {
        this.tempoRobot = tempoRobot;
    }

    public Integer getTempoTrabalhoRobot() {
        return tempoTrabalhoRobot;
    }

    public void setTempoTrabalhoRobot(Integer tempoTrabalhoRobot) {
        this.tempoTrabalhoRobot = tempoTrabalhoRobot;
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
        return false;  // Don't consume the event, other listener must be notified
    }

}
