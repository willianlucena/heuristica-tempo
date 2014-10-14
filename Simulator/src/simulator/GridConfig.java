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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

    private List<Tarefa> tarefas = new ArrayList<>();
    private List<Robot> robos = new ArrayList<>();

    private boolean robo_selected = false;
    private boolean tarefa_selected = false;
    private boolean obstaculo_selected = false;
    public int contDeployRobot = 0;
    public int contDeployTask = 0;

    public static void main(String[] args) {
        new GridConfig();
    }

    public GridConfig() {
        super(5, 5, 20, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
        //setTitle("Click to create a honey pot, press and drag to move it");
        addMouseListener(this, GGMouse.lPress);
        show();
        doRun();
    }

    public GridConfig(int nbHorzCells, int nbVertCells, int cellSize) {
        super(nbHorzCells, nbVertCells, cellSize, Color.BLACK, true);
        this.setBgColor(Color.WHITE);
        addMouseListener(this, GGMouse.lPress);
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

    @Override
    public boolean mouseEvent(GGMouse mouse) {
        Location location = toLocationInGrid(mouse.getX(), mouse.getY());
        if (isEmpty(location)) {// Do not create an actor if cell is occupied
            if (robo_selected) {
                if (contDeployRobot < qtdRobos) {
                    Robot robot = robos.get(contDeployRobot);
                    contDeployRobot++;
                    addActor(robot, location);
                    addMouseListener(robot, GGMouse.lPress | GGMouse.lDrag | GGMouse.lRelease);
                } else {
                    ArrayList<Actor> atores = getActors(Robot.class);
                    for (Actor at : atores) {
                        Robot a = (Robot) at;
                        System.out.println(a.getId());
                        System.out.println(a.getSabeRobot());
                        System.out.println(a.getFazRobot());
                    }
                    JOptionPane.showMessageDialog(this, "Quantidade de robôs no limite. Para mudar a localização do robô clique sobre um a sua escolha e arraste para o local desejado.");
                }
            } else if (tarefa_selected) {
                if (contDeployTask < qtdTarefas) {
                    Tarefa tarefa = tarefas.get(contDeployTask);
                    contDeployTask++;
                    addActor(tarefa, location);
                    addMouseListener(tarefa, GGMouse.lPress | GGMouse.lDrag | GGMouse.lRelease);
                } else {
                    ArrayList<Actor> atores = getActors(Tarefa.class);
                    for (Actor at : atores) {
                        Tarefa a = (Tarefa) at;
                        System.out.println(a.getNomeTask());
                        System.out.println(a.getSabeTask());
                        System.out.println(a.getFazTask());
                    }
                    JOptionPane.showMessageDialog(this, "Quantidade de tarefas no limite. Para mudar a localização da tarefa clique sobre um a sua escolha e arraste para o local desejado.");
                }
            } else if (obstaculo_selected) {
                Obstaculo obstaculo = new Obstaculo();
                addActor(obstaculo, location);
                addMouseListener(obstaculo, GGMouse.lPress | GGMouse.lDrag | GGMouse.lRelease);
            } else {
//                Obstaculo obstaculo = new Obstaculo();
//                addActor(obstaculo, location);
//                addMouseListener(obstaculo, GGMouse.lPress | GGMouse.lDrag | GGMouse.lRelease);
            }
            //TODO descrementar contador.
//            System.out.println("robo : " + robo_selected);
//            System.out.println("tarefa : " + tarefa_selected);
//            System.out.println("obstaculo : " + obstaculo_selected);
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

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Robot> getRobos() {
        return robos;
    }

    public void setRobos(List<Robot> robos) {
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
