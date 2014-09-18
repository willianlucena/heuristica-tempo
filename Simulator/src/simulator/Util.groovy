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

    static void bindConfig( javax.swing.JSpinner altura_y,
        javax.swing.JSpinner largura_x,
        javax.swing.JSpinner qtd_robos,
        javax.swing.JSpinner qtd_tarefas,
        javax.swing.JCheckBox robos_random,
        org.jdesktop.swingx.JXTable tabela_robos,
        org.jdesktop.swingx.JXTable tabela_tarefas,
        javax.swing.JCheckBox tarefas_random) {

        Integer x = (Integer) largura_x.value;
        Integer y = (Integer) altura_y.value;

        Integer qtdRobos = (Integer) qtd_robos.value;
        Integer qtdTarefas = (Integer) qtd_tarefas.value;

        Boolean robosRandom = robos_random.isSelected();
        Boolean tarefasRandom = tarefas_random.isSelected();

        //table.getModel().getValueAt(row_index, col_index);
        int numeroLinhas = tabela_robos.model.getRowCount();
        if (numeroLinhas > 0)
        (1..2).each { j ->
            (0..(numeroLinhas - 1)).each { i ->
                System.out.println("Valores: [$i][$j] " + tabela_robos.model.getValueAt(i, j));
            }
        }

        //tabela_tarefas
        numeroLinhas = tabela_tarefas.model.getRowCount();
        if (numeroLinhas > 0)
        //(1..2).each { j -> //Outro jeito de fazer a iteração. Como serão colunas especificas assim fica melhor eu acho
            (0..(numeroLinhas - 1)).each { i ->
                System.out.println("Valores: [$i][0] " + tabela_tarefas.model.getValueAt(i, 0)); //0 para nome robô
                System.out.println("Valores: [$i][1] " + tabela_tarefas.model.getValueAt(i, 1)); //1 para conhecimemtos
                System.out.println("Valores: [$i][2] " + tabela_tarefas.model.getValueAt(i, 2)); //2 para habilidades
            }
        //}

    }

}

