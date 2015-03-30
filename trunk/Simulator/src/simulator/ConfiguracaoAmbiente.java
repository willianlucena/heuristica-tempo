/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author willian
 */
public class ConfiguracaoAmbiente extends javax.swing.JFrame {

    /**
     * Creates new form ConfiguracaoAmbiente
     *
     */
    public ConfiguracaoAmbiente() {
        qtdRobos = qtdTarefas = 0;
        initComponents();
    }

    /**
     * Creates new form ConfiguracaoAmbiente
     *
     * @param gridConfig
     */
    public ConfiguracaoAmbiente(GridConfig gridConfig) {
        qtdRobos = gridConfig.getQtdRobos();
        qtdTarefas = gridConfig.getQtdTarefas();
        initComponents(gridConfig);
        //initComponents();
    }

    private void initComponents(GridConfig grid) {
        gridConfig = grid;
        getContentPane().add(gridConfig, BorderLayout.NORTH);

        grupoBotao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radio_tarefas = new javax.swing.JRadioButton();
        label_lista_tarefa = new javax.swing.JLabel();
        botaoStep = new javax.swing.JButton();
        botaoReset = new javax.swing.JButton();
        label_qtdRobo = new javax.swing.JLabel();
        botaoRun = new javax.swing.JButton();
        radio_robos = new javax.swing.JRadioButton();
        radio_obstaculos = new javax.swing.JRadioButton();
        label_qtdTarefa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("H-CT com Obstáculos");
        setAlwaysOnTop(true);
        setMaximumSize(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoBotao.add(radio_tarefas);
        radio_tarefas.setText("Tarefas");
        radio_tarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tarefasActionPerformed(evt);
            }
        });
        jPanel1.add(radio_tarefas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, -1));

        label_lista_tarefa.setText("Elementos para o ambiente");
        jPanel1.add(label_lista_tarefa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        botaoStep.setText("Passo");
        botaoStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoStepActionPerformed(evt);
            }
        });
        jPanel1.add(botaoStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, 75, -1));

        botaoReset.setText("Resetar");
        botaoReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResetActionPerformed(evt);
            }
        });
        jPanel1.add(botaoReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, 75, -1));

        label_qtdRobo.setText(qtdRobos + "");
        jPanel1.add(label_qtdRobo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 36, 20, 25));

        botaoRun.setText("Começar");
        botaoRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRunActionPerformed(evt);
            }
        });
        jPanel1.add(botaoRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, -1, -1));

        grupoBotao.add(radio_robos);
        radio_robos.setText("Robô");
        radio_robos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_robosActionPerformed(evt);
            }
        });
        jPanel1.add(radio_robos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, -1, -1));

        grupoBotao.add(radio_obstaculos);
        radio_obstaculos.setText("Obstáculos");
        radio_obstaculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_obstaculosActionPerformed(evt);
            }
        });
        jPanel1.add(radio_obstaculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, -1, -1));

        label_qtdTarefa.setText(qtdTarefas + "");
        jPanel1.add(label_qtdTarefa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 67, 20, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        if (gridConfig.robosRandom) {
            for (int i = 0; i < gridConfig.getQtdRobos(); i++) {
                Robot robot = gridConfig.getRobos().get(i);
                gridConfig.addRoboRandom(robot);
            }
            gridConfig.setContDeployRobot(gridConfig.getQtdRobos());
        }

        if (gridConfig.tarefasRandom) {
            for (int i = 0; i < gridConfig.getQtdTarefas(); i++) {
                Tarefa tarefa = gridConfig.getTarefas().get(i);
                gridConfig.addTarefaRandom(tarefa);
            }
            gridConfig.setContDeployTask(gridConfig.getQtdTarefas());
        }

        for (int i = 0; i < gridConfig.getQtdObstaculos(); i++) {
            gridConfig.addObstaculoRandom(new Obstaculo());
        }
        if (gridConfig.getQtdObstaculos() > 0) gridConfig.setContDeployObstaculo(gridConfig.getQtdObstaculos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radio_tarefas = new javax.swing.JRadioButton();
        label_lista_tarefa = new javax.swing.JLabel();
        botaoStep = new javax.swing.JButton();
        botaoReset = new javax.swing.JButton();
        label_qtdRobo = new javax.swing.JLabel();
        botaoRun = new javax.swing.JButton();
        radio_robos = new javax.swing.JRadioButton();
        radio_obstaculos = new javax.swing.JRadioButton();
        label_qtdTarefa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("H-CT com Obstáculos");
        setAlwaysOnTop(true);
        setMaximumSize(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoBotao.add(radio_tarefas);
        radio_tarefas.setText("Tarefas");
        radio_tarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tarefasActionPerformed(evt);
            }
        });
        jPanel1.add(radio_tarefas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, -1));

        label_lista_tarefa.setText("Elementos para o ambiente");
        jPanel1.add(label_lista_tarefa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        botaoStep.setText("Passo");
        botaoStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoStepActionPerformed(evt);
            }
        });
        jPanel1.add(botaoStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, 75, -1));

        botaoReset.setText("Resetar");
        botaoReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResetActionPerformed(evt);
            }
        });
        jPanel1.add(botaoReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, 75, -1));

        label_qtdRobo.setText(qtdRobos + "");
        jPanel1.add(label_qtdRobo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 36, 20, 25));

        botaoRun.setText("Começar");
        botaoRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRunActionPerformed(evt);
            }
        });
        jPanel1.add(botaoRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, -1, -1));

        grupoBotao.add(radio_robos);
        radio_robos.setText("Robô");
        radio_robos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_robosActionPerformed(evt);
            }
        });
        jPanel1.add(radio_robos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, -1, -1));

        grupoBotao.add(radio_obstaculos);
        radio_obstaculos.setText("Obstáculos");
        radio_obstaculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_obstaculosActionPerformed(evt);
            }
        });
        jPanel1.add(radio_obstaculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, -1, -1));

        label_qtdTarefa.setText(qtdTarefas + "");
        jPanel1.add(label_qtdTarefa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 67, 20, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radio_robosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_robosActionPerformed
        changeRadios();
    }//GEN-LAST:event_radio_robosActionPerformed

    private void radio_tarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_tarefasActionPerformed
        changeRadios();
    }//GEN-LAST:event_radio_tarefasActionPerformed

    private void radio_obstaculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_obstaculosActionPerformed
        changeRadios();
    }//GEN-LAST:event_radio_obstaculosActionPerformed

    private void botaoRunActionPerformed(java.awt.event.ActionEvent evt) {
        /*
         TreeSet<Robot> robotsMission = new TreeSet<Robot>(new OrdenaRobotNome());
         Set<Tarefa> taskMission = new LinkedHashSet<Tarefa>();
         for (Actor ator : gridConfig.getActors(Robot.class)) {
         robotsMission.add((Robot) ator);
         }
         for (Actor task : gridConfig.getActors(Tarefa.class)) {
         taskMission.add((Tarefa) task);
         }
         */

        for (Actor ator : gridConfig.getActors(Robot.class)) {
            ArrayList robos = gridConfig.getActors(Robot.class);
            robos.remove(ator);
            ator.addCollisionActors(robos);
            ator.addCollisionActors(gridConfig.getActors(Tarefa.class));
            ator.addCollisionActors(gridConfig.getActors(Obstaculo.class));
        }
        gridConfig.doRun();
        /*
         //Cria o ambiente definindo uma missão
         Missao m = new Missao();
         // Insere a lista de robôs na missão previamente definida
         m.setCandidates(robotsMission);
         // Insere a lista de tarefas na missão previamente definida
         m.setToDo(taskMission);
         // Exibe as configurações dos robôs, antes de realizarem a missão
         m.configRobots();
         // Exibe as configurações das tarefas que compõem a missão 
         m.configTasks();
         // Exibe a lista de robôs escalados para resolver a missão 
         m.listaRobots();
         // Exibe a lista de tarefas a serem resolvidas pelos robôs 
         m.listaTasks();
         // Executa a missão, na qual cada tarefa deve ser resolvida 
         m.execMissao();
         // Exibe as configurações dos robôs, após realizarem a missão 
         System.out.println("\n\n------------------------------");
         System.out.println("Após a realização da missão:");
         m.configRobots();
         */

//        gridConfig1.doStep();
//        gridConfig1.doPause();
//        gridConfig1.doReset();
    }

    private void botaoStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoStepActionPerformed
        gridConfig.doStep();
    }//GEN-LAST:event_botaoStepActionPerformed

    private void botaoResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResetActionPerformed
        gridConfig.doReset();
    }//GEN-LAST:event_botaoResetActionPerformed

    private void changeRadios() {
        gridConfig.setRobo_selected(radio_robos.isSelected());
        gridConfig.setTarefa_selected(radio_tarefas.isSelected());
        gridConfig.setObstaculo_selected(radio_obstaculos.isSelected());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfiguracaoAmbiente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoReset;
    private javax.swing.JButton botaoRun;
    private javax.swing.JButton botaoStep;
    private javax.swing.ButtonGroup grupoBotao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_lista_tarefa;
    private javax.swing.JLabel label_qtdRobo;
    private javax.swing.JLabel label_qtdTarefa;
    private javax.swing.JRadioButton radio_obstaculos;
    private javax.swing.JRadioButton radio_robos;
    private javax.swing.JRadioButton radio_tarefas;
    // End of variables declaration//GEN-END:variables

    private int qtdRobos;
    private int qtdTarefas;
    private GridConfig gridConfig;

    public int getQtdRobos() {
        return qtdRobos;
    }

    public void setQtdRobos(int qtd) {
        qtdRobos = qtd;
    }

    public int getQtdTarefas() {
        return qtdTarefas;
    }

    public void setQtdTarefas(int qtd) {
        qtdTarefas = qtd;
    }

    public JLabel getLabel_lista_tarefa() {
        return label_lista_tarefa;
    }

    public void setLabel_lista_tarefa(JLabel label_lista_tarefa) {
        this.label_lista_tarefa = label_lista_tarefa;
    }

    public JLabel getLabel_qtdRobo() {
        return label_qtdRobo;
    }

    public void setLabel_qtdRobo(JLabel label_qtdRobo) {
        this.label_qtdRobo = label_qtdRobo;
    }

    public JLabel getLabel_qtdTarefa() {
        return label_qtdTarefa;
    }

    public void setLabel_qtdTarefa(JLabel label_qtdTarefa) {
        this.label_qtdTarefa = label_qtdTarefa;
    }

}
