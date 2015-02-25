/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulator

import java.awt.Point

/**
 *
 * @author willian
 */
class Util {

    static Object[][] montarTabelaRobos(Integer qtd_robos) {
        def mapa = []
        if (qtd_robos > 0) {
//            (1..qtd_robos).each {
//                mapa.add(["Robô $it", null, null])
//            }
            
            /* R1={[c4];[f1]} */
//            Robot r1 = new Robot("r1");
//            r1.setSabeRobot("c4");
//            r1.setFazRobot("f1");
            mapa.add(["r1", "c4", "f1"])

            /* R2={[];[f1, f2]} */
//            Robot r2 = new Robot("r2");
//            r2.setFazRobot("f1");
//            r2.setFazRobot("f2");
            mapa.add(["r2", null, "f1,f2"])

            /* R3={[c1];[f2, f3]} */
//            Robot r3 = new Robot("r3");
//            r3.setSabeRobot("c1");
//            r3.setFazRobot("f2");
//            r3.setFazRobot("f3");
            mapa.add(["r3", "c1", "f2,f3"])

            /* R4={[c4, c1];[f1]} */
//            Robot r4 = new Robot("r4");
//            r4.setSabeRobot("c4");
//            r4.setSabeRobot("c1");
//            r4.setFazRobot("f1");
            mapa.add(["r4", "c1,c4", "f1"])

            /* R5={[c2];[f1, f2, f3]} */
//            Robot r5 = new Robot("r5");
//            r5.setSabeRobot("c2");
//            r5.setFazRobot("f1");
//            r5.setFazRobot("f2");
//            r5.setFazRobot("f3");
            mapa.add(["r5", "c2", "f1,f2,f3"])

            /* R6={[c1, c3];[f2]} */
//            Robot r6 = new Robot("r6");
//            r6.setSabeRobot("c1");
//            r6.setSabeRobot("c3");
//            r6.setFazRobot("f2");
            mapa.add(["r6", "c1,c3", "f2"])

            /* R7={[c3];[f1, f3]} */
//            Robot r7 = new Robot("r7");
//            r7.setSabeRobot("c3");
//            r7.setFazRobot("f1");
//            r7.setFazRobot("f3");
            mapa.add(["r7", "c3", "f1,f3"])

            /* R8={[];[f1, f2, f3]} */
//            Robot r8 = new Robot("r8");
//            r8.setFazRobot("f1");
//            r8.setFazRobot("f2");
//            r8.setFazRobot("f3");
            mapa.add(["r8", null, "f1,f2,f3"])

            /* R9={[c2, c3];[f3]} */
//            Robot r9 = new Robot("r9");
//            r9.setSabeRobot("c2");
//            r9.setSabeRobot("c3");
//            r9.setFazRobot("f3");
            mapa.add(["r9", "c2,c3", "f3"])

            /* R10={[c2, c3, c4];[f1, f3]} */
//            Robot r10 = new Robot("r10");
//            r10.setSabeRobot("c2");
//            r10.setSabeRobot("c3");
//            r10.setSabeRobot("c4");
//            r10.setFazRobot("f1");
//            r10.setFazRobot("f3");
            mapa.add(["r10", "c2,c3,c4", "f1,f3"])
            
            return mapa
        } else {
            return mapa
        }
    }

    static Object[][] montarTabelaTarefas(Integer qtd_tarefas) {
        def mapa = []
        if (qtd_tarefas > 0) {
            (1..qtd_tarefas).each {
                mapa.add(["Tarefa $it", null, null, null])
            }
            
//            Tarefa t1 = new Tarefa("t1");
//            t1.setSabeTask("c1");
//            t1.setFazTask("f3");
//            t1.setTempoTask(4);
                mapa.add(["t1", "c1", "f3", 4])
//            Tarefa t2 = new Tarefa("t2");
//            t2.setSabeTask("c1");
//            t2.setSabeTask("c2");
//            t2.setSabeTask("c3");
//            t2.setFazTask("f1");
//            t2.setFazTask("f3");
//            t2.setTempoTask(3);
                mapa.add(["t2", "c1,c2,c3", "f1,f3", 3])
//            Tarefa t3 = new Tarefa("t3");
//            t3.setSabeTask("c2");
//            t3.setSabeTask("c3");
//            t3.setFazTask("f1");
//            t3.setFazTask("f2");
//            t3.setTempoTask(1);
                mapa.add(["t3", "c2,c3", "f1,f2", 1])
//            Tarefa t4 = new Tarefa("t4");
//            t4.setSabeTask("c2");
//            t4.setFazTask("f2");
//            t4.setTempoTask(2);
                mapa.add(["t4", "c2", "f2", 2])
//            Tarefa t5 = new Tarefa("t5");
//            t5.setSabeTask("c3");
//            t5.setSabeTask("c4");
//            t5.setFazTask("f1");
//            t5.setTempoTask(4);
                mapa.add(["t5", "c3,c4", "f1", 4])
//            Tarefa t6 = new Tarefa("t6");
//            t6.setSabeTask("c4");
//            t6.setFazTask("f2");
//            t6.setTempoTask(1);
                mapa.add(["t6", "c4", "f2", 1])
//            /* T7={[c1, c3];[f3];[2]} */
//            Tarefa t7 = new Tarefa("t7");
//            t7.setSabeTask("c1");
//            t7.setSabeTask("c3");
//            t7.setFazTask("f3");
//            t7.setTempoTask(2);
                mapa.add(["t7", "c1,c3", "f3", 2])
//            /* T8={[c3];[f1];[1]} */
//            Tarefa t8 = new Tarefa("t8");
//            t8.setSabeTask("c3");
//            t8.setFazTask("f1");
//            t8.setTempoTask(1);
                mapa.add(["t8", "c3", "f1", 1])
//            /* T9={[c4];[f1, f2, f3];[3]} */
//            Tarefa t9 = new Tarefa("t9");
//            t9.setSabeTask("c4");
//            t9.setFazTask("f1");
//            t9.setFazTask("f2");
//            t9.setFazTask("f3");
//            t9.setTempoTask(3);
                mapa.add(["t9", "c4", "f1,f2,f3", 3])
//            /* T10={[c1, c4];[f1, f2];[6]} */
//            Tarefa t10 = new Tarefa("t10");
//            t10.setSabeTask("c1");
//            t10.setSabeTask("c4");
//            t10.setFazTask("f1");
//            t10.setFazTask("f2");
//            t10.setTempoTask(6);
                mapa.add(["t10", "c1,c4", "f1,f2", 6])
            return mapa
        } else {
            return mapa
        }
    }

    static GridConfig bindConfig(
        javax.swing.JSpinner altura_y,
        javax.swing.JSpinner largura_x,

        javax.swing.JSpinner qtd_robos,
        javax.swing.JSpinner qtd_tarefas,

        org.jdesktop.swingx.JXTable tabela_robos,
        org.jdesktop.swingx.JXTable tabela_tarefas,

        javax.swing.JCheckBox robos_random,
        javax.swing.JCheckBox tarefas_random) {

        Integer x = (Integer) largura_x.value;
        Integer y = (Integer) altura_y.value;

        Integer qtdRobos = (Integer) qtd_robos.value;
        Integer qtdTarefas = (Integer) qtd_tarefas.value;

        Boolean robosRandom = robos_random.isSelected();
        Boolean tarefasRandom = tarefas_random.isSelected();

        //tabela_robos
        int numeroLinhasR = tabela_robos.model.getRowCount();
        def listaRobos = []
        if (numeroLinhasR > 0) {
            (0..(numeroLinhasR - 1)).each { i ->
                //System.out.println("Nome robô: [$i][0] " + tabela_robos.model.getValueAt(i, 0)); //0 para nome robô
                //System.out.println("C robô: [$i][1] " + tabela_robos.model.getValueAt(i, 1)); //1 para conhecimentos básicos que possui
                //System.out.println("F robô: [$i][2] " + tabela_robos.model.getValueAt(i, 2)); //2 para habilidades físicas que possui

                String nomeRobo = tabela_robos.model.getValueAt(i, 0);
                Robot r = new Robot(nomeRobo, true);
                String conhecimentos = tabela_robos.model.getValueAt(i, 1);
                String habilidades = tabela_robos.model.getValueAt(i, 2);
                List<String> c = (conhecimentos?.split(",") as List<String>) ?: [];
                if (c.size() > 0) r.setSabeRobot(new TreeSet<>(c));
                List<String> f = (habilidades?.split(",") as List<String>) ?: [];
                if (f.size() > 0) r.setFazRobot(new TreeSet<>(f));
                listaRobos.add(r);
            }
        }

        //tabela_tarefas
        def numeroLinhasT = tabela_tarefas.model.getRowCount();
        def listaTarefas = []
        if (numeroLinhasT > 0) {
            (0..(numeroLinhasT - 1)).each { i ->
                //System.out.println("Nome tarefa: [$i][0] " + tabela_tarefas.model.getValueAt(i, 0)); //0 para nome tarefa
                //System.out.println("c tarefa: [$i][1] " + tabela_tarefas.model.getValueAt(i, 1)); //1 para conhecimentos básicos necessários a realização da tarefa
                //System.out.println("f tarefa: [$i][2] " + tabela_tarefas.model.getValueAt(i, 2)); //2 para habilidades físicas necessárias a realização da tarefa
                Tarefa t = new Tarefa();
                String nomeTarefa = tabela_tarefas.model.getValueAt(i, 0);
                String conhecimentos = tabela_tarefas.model.getValueAt(i, 1);
                String habilidades = tabela_tarefas.model.getValueAt(i, 2);
                t.setNomeTask(nomeTarefa);
                List<String> c = (conhecimentos?.split(",") as List<String>) ?: [];
                if (c.size() > 0) t.setSabeTask(new TreeSet<>(c));
                List<String> f = (habilidades?.split(",") as List<String>) ?: [];
                if (f.size() > 0) t.setFazTask(new TreeSet<>(f));
                listaTarefas.add(t);
            }
        }

        GridConfig grid = new GridConfig(x, y, 20);
        grid.setLargura(x);
        grid.setAltura(y);
        grid.setQtdTarefas(listaTarefas.size());
        grid.setQtdRobos(listaRobos.size());
        grid.setRobos(listaRobos);
        grid.setTarefas(listaTarefas);
        
        if (robosRandom) {
            for (int i = 0; i < grid.getQtdRobos(); i++) {
                Robot robot = listaRobos.get(i);
                grid.addRoboRandom(robot);
            }
            grid.setContDeployRobot(grid.getQtdRobos());
        }
        
        if (tarefasRandom) {
            for (int i = 0; i < grid.getQtdTarefas(); i++) {
                Tarefa tarefa = listaTarefas.get(i);
                grid.addTarefaRandom(tarefa);
            }
            grid.setContDeployTask(grid.getQtdTarefas());
        }
        
//        if (obstaculosRandom) {
//            for (int i = 0; i < grid.getQtdObstaculos(); i++) {
//                grid.addObstaculoRandom(new Obstaculo());
//            }
//            grid.setContDeployObstaculo(grid.getQtdObstaculos());
//        }

        return grid;

    }

}

