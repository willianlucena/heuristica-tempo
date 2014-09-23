/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulator

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
            return mapa
        } else {
            return mapa
        }
    }

    static Object[][] montarTabelaTarefas(Integer qtd_tarefas) {
        def mapa = []
        if (qtd_tarefas > 0) {
            (1..qtd_tarefas).each {
                mapa.add(["Tarefa $it", null, null])
            }
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
                System.out.println("Nome robô: [$i][0] " + tabela_robos.model.getValueAt(i, 0)); //0 para nome robô
                System.out.println("C robô: [$i][1] " + tabela_robos.model.getValueAt(i, 1)); //1 para conhecimentos básicos que possui
                System.out.println("F robô: [$i][2] " + tabela_robos.model.getValueAt(i, 2)); //2 para habilidades físicas que possui

                String nomeRobo = tabela_robos.model.getValueAt(i, 0);
                Robot r = new Robot(nomeRobo, true);
                String conhecimentos = tabela_robos.model.getValueAt(i, 1);
                String habilidades = tabela_robos.model.getValueAt(i, 2);
                r.setSabeRobot(conhecimentos?.split(","));
                r.setFazRobot(habilidades?.split(","));
                listaRobos.add(r);
            }
        }

        //tabela_tarefas
        def numeroLinhasT = tabela_tarefas.model.getRowCount();
        def listaTarefas = []
        if (numeroLinhasT > 0) {
            (0..(numeroLinhasT - 1)).each { i ->
                System.out.println("Nome tarefa: [$i][0] " + tabela_tarefas.model.getValueAt(i, 0)); //0 para nome tarefa
                System.out.println("c tarefa: [$i][1] " + tabela_tarefas.model.getValueAt(i, 1)); //1 para conhecimentos básicos necessários a realização da tarefa
                System.out.println("f tarefa: [$i][2] " + tabela_tarefas.model.getValueAt(i, 2)); //2 para habilidades físicas necessárias a realização da tarefa
                Tarefa t = new Tarefa();
                String nomeTarefa = tabela_tarefas.model.getValueAt(i, 0);
                String conhecimentos = tabela_tarefas.model.getValueAt(i, 1);
                String habilidades = tabela_tarefas.model.getValueAt(i, 2);
                t.setNomeTask(nomeTarefa);
                t.setSabeTask(conhecimentos?.split(","));
                t.setFazTask(habilidades?.split(","));
                listaTarefas.add(t);
            }
        }

        GridConfig grid = new GridConfig(x, y, 20);
        grid.setLargura(x);
        grid.setAltura(y);
        grid.setQtdTarefas(qtdTarefas);
        grid.setQtdRobos(qtdRobos);
        grid.setRobosRandom(robosRandom);
        grid.setTarefasRandom(tarefasRandom);
        grid.setRobos(listaRobos as Set);
        grid.setTarefas(listaTarefas as Set);

        return grid;

    }

}

