/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
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

    private void initComponents(GridConfig gridConfig) {
        gridConfig1 = gridConfig;

        grupoBotao = new javax.swing.ButtonGroup();
        label_lista_tarefa = new javax.swing.JLabel();
        radio_robos = new javax.swing.JRadioButton();
        radio_tarefas = new javax.swing.JRadioButton();
        radio_obstaculos = new javax.swing.JRadioButton();
        label_qtdRobo = new javax.swing.JLabel();
        label_qtdTarefa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurar Ambiente");
        setAlwaysOnTop(true);
        setResizable(false);

        label_lista_tarefa.setText("Elementos para o ambiente");

        grupoBotao.add(radio_robos);
        radio_robos.setText("Robô");
        radio_robos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_robosActionPerformed(evt);
            }
        });

        grupoBotao.add(radio_tarefas);
        radio_tarefas.setText("Tarefas");
        radio_tarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tarefasActionPerformed(evt);
            }
        });

        grupoBotao.add(radio_obstaculos);
        radio_obstaculos.setText("Obstáculos");
        radio_obstaculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_obstaculosActionPerformed(evt);
            }
        });

        label_qtdRobo.setText(qtdRobos + "");

        label_qtdTarefa.setText(qtdTarefas + "");

        jButton1.setText("Começar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio_tarefas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_qtdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radio_obstaculos)
                                    .addComponent(label_lista_tarefa))
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio_robos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_qtdRobo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_lista_tarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_robos)
                    .addComponent(label_qtdRobo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_tarefas)
                    .addComponent(label_qtdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radio_obstaculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotao = new javax.swing.ButtonGroup();
        gridConfig1 = new simulator.GridConfig();
        label_lista_tarefa = new javax.swing.JLabel();
        radio_robos = new javax.swing.JRadioButton();
        radio_tarefas = new javax.swing.JRadioButton();
        radio_obstaculos = new javax.swing.JRadioButton();
        label_qtdRobo = new javax.swing.JLabel();
        label_qtdTarefa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurar Ambiente");
        setAlwaysOnTop(true);
        setResizable(false);

        label_lista_tarefa.setText("Elementos para o ambiente");

        grupoBotao.add(radio_robos);
        radio_robos.setText("Robô");
        radio_robos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_robosActionPerformed(evt);
            }
        });

        grupoBotao.add(radio_tarefas);
        radio_tarefas.setText("Tarefas");
        radio_tarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tarefasActionPerformed(evt);
            }
        });

        grupoBotao.add(radio_obstaculos);
        radio_obstaculos.setText("Obstáculos");
        radio_obstaculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_obstaculosActionPerformed(evt);
            }
        });

        label_qtdRobo.setText(qtdRobos + "");

        label_qtdTarefa.setText(qtdTarefas + "");

        jButton1.setText("Começar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio_tarefas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_qtdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radio_obstaculos)
                                    .addComponent(label_lista_tarefa))
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio_robos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_qtdRobo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_lista_tarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_robos)
                    .addComponent(label_qtdRobo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_tarefas)
                    .addComponent(label_qtdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radio_obstaculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i = 0; i < gridConfig1.getActors(Robot.class).size(); i++) {
            Actor ator = gridConfig1.getActors(Robot.class).get(i);
            for (int k = 0; k < gridConfig1.getActors(Robot.class).size(); k++) {
                Actor collider = gridConfig1.getActors(Robot.class).get(k);
                if (ator != collider) {
                    ator.addCollisionActor(collider);
                }
            }
            for (int k = 0; k < gridConfig1.getActors(Tarefa.class).size(); k++) {
                Actor collider = gridConfig1.getActors(Tarefa.class).get(k);
                if (ator != collider) {
                    ator.addCollisionActor(collider);
                }
            }
            
            for (int k = 0; k < gridConfig1.getActors(Obstaculo.class).size(); k++) {
                Actor collider = gridConfig1.getActors(Obstaculo.class).get(k);
                if (ator != collider) {
                    ator.addCollisionActor(collider);
                }
            }
        }
        gridConfig1.doRun();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changeRadios() {
        gridConfig1.setRobo_selected(radio_robos.isSelected());
        gridConfig1.setTarefa_selected(radio_tarefas.isSelected());
        gridConfig1.setObstaculo_selected(radio_obstaculos.isSelected());
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
    private simulator.GridConfig gridConfig1;
    private javax.swing.ButtonGroup grupoBotao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label_lista_tarefa;
    private javax.swing.JLabel label_qtdRobo;
    private javax.swing.JLabel label_qtdTarefa;
    private javax.swing.JRadioButton radio_obstaculos;
    private javax.swing.JRadioButton radio_robos;
    private javax.swing.JRadioButton radio_tarefas;
    // End of variables declaration//GEN-END:variables

    private int qtdRobos;
    private int qtdTarefas;

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
