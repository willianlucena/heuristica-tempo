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
            (1..qtd_robos).each {
                mapa.add(["Robô $it", null, null])
            }
            
            /* R={R1, R2, R3, R4, R5, R6, R7, R8, R9, R10} */
            /*mapa.add(["r1", "c4", "f1"])
            mapa.add(["r2", null, "f1,f2"])
            mapa.add(["r3", "c1", "f2,f3"])
            mapa.add(["r4", "c1,c4", "f1"])
            mapa.add(["r5", "c2", "f1,f2,f3"])
            mapa.add(["r6", "c1,c3", "f2"])
            mapa.add(["r7", "c3", "f1,f3"])
            mapa.add(["r8", null, "f1,f2,f3"])
            mapa.add(["r9", "c2,c3", "f3"])
            mapa.add(["r10", "c2,c3,c4", "f1,f3"])
            */
            /* R1={[c4];[f1]} */
            /* R2={[];[f1, f2]} */
            /* R3={[c1];[f2, f3]} */
            /* R4={[c4, c1];[f1]} */
            /* R5={[c2];[f1, f2, f3]} */
            /* R6={[c1, c3];[f2]} */
            /* R7={[c3];[f1, f3]} */
            /* R8={[];[f1, f2, f3]} */
            /* R9={[c2, c3];[f3]} */
            /* R10={[c2, c3, c4];[f1, f3]} */

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
            /* T={T4, T9, T6, T8, T1, T10, T2, T5, T3, T7} */
            /*
            mapa.add(["t4", "c2", "f2", 2])
            mapa.add(["t9", "c4", "f1,f2,f3", 3])
            mapa.add(["t6", "c4", "f2", 1])
            mapa.add(["t8", "c3", "f1", 1])
            mapa.add(["t1", "c1", "f3", 4])
            mapa.add(["t10", "c1,c4", "f1,f2", 6])
            mapa.add(["t2", "c1,c2,c3", "f1,f3", 3])
            mapa.add(["t5", "c3,c4", "f1", 4])
            mapa.add(["t3", "c2,c3", "f1,f2", 1])
            mapa.add(["t7", "c1,c3", "f3", 2])
             */    
            /* T4={[c2];[f2];[2]} */
            /* T9={[c4];[f1, f2, f3];[3]} */
            /* T6={[c4];[f2];[1]} */
            /* T8={[c3];[f1];[1]} */
            /* T1={[c1];[f3];[4]} */
            /* T10={[c1, c4];[f1, f2];[6]} */
            /* T2={[c1, c2, c3];[f1, f3];[3]} */
            /* T5={[c3, c4];[f1];[4]} */
            /* T3={[c2, c3];[f1, f2];[1]} */
            /* T7={[c1, c3];[f3];[2]} */
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
        javax.swing.JSpinner qtd_obstaculos,

        org.jdesktop.swingx.JXTable tabela_robos,
        org.jdesktop.swingx.JXTable tabela_tarefas,

        javax.swing.JCheckBox robos_random,
        javax.swing.JCheckBox tarefas_random) {

        Integer x = (Integer) largura_x.value;
        Integer y = (Integer) altura_y.value;

        Integer qtdRobos = (Integer) qtd_robos.value;
        Integer qtdTarefas = (Integer) qtd_tarefas.value;
        Integer qtdObstaculos = (Integer) qtd_obstaculos.value;

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
                Integer custo = tabela_tarefas.model.getValueAt(i, 3);
                t.setNomeTask(nomeTarefa);
                List<String> c = (conhecimentos?.split(",") as List<String>) ?: [];
                if (c.size() > 0) t.setSabeTask(new TreeSet<>(c));
                List<String> f = (habilidades?.split(",") as List<String>) ?: [];
                if (f.size() > 0) t.setFazTask(new TreeSet<>(f));
                listaTarefas.add(t);
                t.setTempoTask(custo ?: 0);
            }
        }

        GridConfig grid = new GridConfig(x, y, 20);
        grid.setLargura(x);
        grid.setAltura(y);
        grid.setQtdTarefas(listaTarefas.size());
        grid.setQtdRobos(listaRobos.size());
        grid.setQtdObstaculos(qtdObstaculos ?: 0);
        grid.setRobos(listaRobos);
        grid.setTarefas(listaTarefas);
        grid.setRobosRandom(robosRandom);
        grid.setTarefasRandom(tarefasRandom);
        
        return grid;

    }

}

