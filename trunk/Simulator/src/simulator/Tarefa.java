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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author willian
 */
public class Tarefa extends Actor implements GGMouseListener {

    //propriedade presente no robo da heuristica
    private String nomeTask;
    private Set<String> sabeTask = new TreeSet<>();
    private Set<String> fazTask = new TreeSet<>();
    private String logRobot = "NENHUM robô!";
    private boolean isSolved = false;
    private Integer tempoTask = 0;
    private Robot apto;
    private boolean hasApto = false;

    //auxiliar na inserção do robo no ambiente no momento da configuracao
    private Location lastLocation;
    private boolean isDragging = false;

    public Tarefa() {
        super("sprite/target.gif");
    }

    public String getNomeTask() {
        return nomeTask;
    }

    public void setNomeTask(String nomeTask) {
        this.nomeTask = nomeTask;
    }

    public Set<String> getSabeTask() {
        return sabeTask;
    }

    public void setSabeTask(Set<String> sabeTask) {
        this.sabeTask = sabeTask;
    }

    public Set<String> getFazTask() {
        return fazTask;
    }

    public void setFazTask(Set<String> fazTask) {
        this.fazTask = fazTask;
    }

    public String getLogRobot() {
        return logRobot;
    }

    public void setLogRobot(String logRobot) {
        this.logRobot = logRobot;
    }

    public boolean isIsSolved() {
        return isSolved;
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public Integer getTempoTask() {
        return tempoTask;
    }

    public void setTempoTask(Integer tempoTask) {
        this.tempoTask = tempoTask;
    }

    public Robot getApto() {
        return apto;
    }

    public void setApto(Robot apto) {
        this.apto = apto;
    }

    public boolean isHasApto() {
        return hasApto;
    }

    public void setHasApto(boolean hasApto) {
        this.hasApto = hasApto;
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
        return false; // Don't consume the event, other listener must be notified
    }

}
