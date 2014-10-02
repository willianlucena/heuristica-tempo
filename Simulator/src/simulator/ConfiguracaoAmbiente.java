/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.util.Set;

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
        Set<Robot> robos = gridConfig.getRobos();
        qtdRobos = robos.size();
        Set<Tarefa> tarefas = gridConfig.getTarefas();
        qtdTarefas = tarefas.size();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radio_tarefas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_qtdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_obstaculos)
                            .addComponent(label_lista_tarefa))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radio_robos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_qtdRobo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configurar Ambiente");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(2048, 2048));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gridConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel label_lista_tarefa;
    private javax.swing.JLabel label_qtdRobo;
    private javax.swing.JLabel label_qtdTarefa;
    private javax.swing.JRadioButton radio_obstaculos;
    private javax.swing.JRadioButton radio_robos;
    private javax.swing.JRadioButton radio_tarefas;
    // End of variables declaration//GEN-END:variables

    private final int qtdRobos;
    private final int qtdTarefas;
}