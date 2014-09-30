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
import ch.aplu.jgamegrid.Location;
import java.awt.Color;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author willian
 */
public class GridConfig extends GameGrid implements GGActorCollisionListener, GGMouseListener {

    private Integer largura;
    private Integer altura;

    private Integer qtdRobos;
    private Integer qtdTarefas;

    private Boolean robosRandom;
    private Boolean tarefasRandom;

    private Set<Tarefa> tarefas = new TreeSet<>();
    private Set<Robot> robos = new TreeSet<>();

    private boolean robo_selected = false;
    private boolean tarefa_selected = false;
    private boolean obstaculo_selected = false;

    //private
    public GridConfig() {
        super(30, 30, 20, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
    }

    public GridConfig(int nbHorzCells, int nbVertCells, int cellSize) {
        super(nbHorzCells, nbVertCells, cellSize, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
        addMouseListener(this, GGMouse.lPress);
    }

    @Override
    public int collide(Actor actor, Actor actor1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mouseEvent(GGMouse mouse) {
        Location location = toLocationInGrid(mouse.getX(), mouse.getY());
        if (isEmpty(location)) {// Do not create an actor if cell is occupied
            Tarefa robot = new Tarefa();
            addActor(robot, location);
            addMouseListener(robot, GGMouse.lPress | GGMouse.lDrag | GGMouse.lRelease);
            System.out.println("robo : " + robo_selected);
            System.out.println("tarefa : " + tarefa_selected);
            System.out.println("obstaculo : " + obstaculo_selected);
        }
        return false; // Don't consume the event, other listeners must be notified
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getQtdRobos() {
        return qtdRobos;
    }

    public void setQtdRobos(Integer qtdRobos) {
        this.qtdRobos = qtdRobos;
    }

    public Integer getQtdTarefas() {
        return qtdTarefas;
    }

    public void setQtdTarefas(Integer qtdTarefas) {
        this.qtdTarefas = qtdTarefas;
    }

    public Boolean getRobosRandom() {
        return robosRandom;
    }

    public void setRobosRandom(Boolean robosRandom) {
        this.robosRandom = robosRandom;
    }

    public Boolean getTarefasRandom() {
        return tarefasRandom;
    }

    public void setTarefasRandom(Boolean tarefasRandom) {
        this.tarefasRandom = tarefasRandom;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Set<Robot> getRobos() {
        return robos;
    }

    public void setRobos(Set<Robot> robos) {
        this.robos = robos;
    }

    public boolean isRobo_selected() {
        return robo_selected;
    }

    public void setRobo_selected(boolean robo_selected) {
        this.robo_selected = robo_selected;
    }

    public boolean isTarefa_selected() {
        return tarefa_selected;
    }

    public void setTarefa_selected(boolean tarefa_selected) {
        this.tarefa_selected = tarefa_selected;
    }

    public boolean isObstaculo_selected() {
        return obstaculo_selected;
    }

    public void setObstaculo_selected(boolean obstaculo_selected) {
        this.obstaculo_selected = obstaculo_selected;
    }

}
