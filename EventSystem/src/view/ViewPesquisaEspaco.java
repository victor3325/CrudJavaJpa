/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AlunosEntity;
import model.IdCompostoAlunoEtapaEspaco;
import repository.AlunoEtapaEspacoRep;
import repository.AlunosRep;
import repository.EspacoCafeRep;
import repository.EtapaRep;







/**
 *
 * @author victo
 */
public class ViewPesquisaEspaco extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaAlunoId
     */
    public ViewPesquisaEspaco() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EventSystemPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("EventSystemPU").createEntityManager();
        alunoetapasalaQuery = java.beans.Beans.isDesignTime() ? null : EventSystemPUEntityManager.createQuery("SELECT a FROM Alunoetapasala a");
        alunoetapasalaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : alunoetapasalaQuery.getResultList();
        alunoetapaespacoQuery = java.beans.Beans.isDesignTime() ? null : EventSystemPUEntityManager.createQuery("SELECT a FROM Alunoetapaespaco a");
        alunoetapaespacoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : alunoetapaespacoQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnEspaco = new javax.swing.JButton();
        txtIdEspaco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspaco = new javax.swing.JTable();
        radEtapa1 = new javax.swing.JRadioButton();
        radEtapa2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Espaço");
        setResizable(false);

        btnEspaco.setText("Consultar Espaco");
        btnEspaco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspacoActionPerformed(evt);
            }
        });

        jLabel1.setText("idEspaco");

        tblEspaco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idAluno", "Nome", "Sobrenome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEspaco);
        if (tblEspaco.getColumnModel().getColumnCount() > 0) {
            tblEspaco.getColumnModel().getColumn(0).setResizable(false);
            tblEspaco.getColumnModel().getColumn(1).setResizable(false);
            tblEspaco.getColumnModel().getColumn(2).setResizable(false);
        }

        buttonGroup1.add(radEtapa1);
        radEtapa1.setText("Etapa 1");

        buttonGroup1.add(radEtapa2);
        radEtapa2.setText("Etapa 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdEspaco, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEspaco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radEtapa2)
                            .addComponent(radEtapa1))
                        .addGap(56, 56, 56))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdEspaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btnEspaco))
                    .addComponent(radEtapa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radEtapa2)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void PopularJTable(int idAluno, int idEspaco, int idEtapa) {
        
        
        DefaultTableModel model =(DefaultTableModel) tblEspaco.getModel();
                    
                
                List<AlunosEntity> alunos = new AlunosRep().listarPorEspaco(idAluno, idEspaco, idEtapa);
                Object RowData[] = new Object[3];
                for (int i = 0; i < alunos.size(); i++) {
                     
                     //retorna os dados da tabela do BD, cada campo e um coluna.
                    RowData[0] = alunos.get(i).getIdAluno();
                    RowData[1] = alunos.get(i).getNomeAluno();
                    RowData[2] = alunos.get(i).getSobrenome();
                    model.addRow(RowData);
                }

        
    }
    
    
    private void btnEspacoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspacoActionPerformed
        
        DefaultTableModel model =(DefaultTableModel) tblEspaco.getModel();
        model.setRowCount(0);
        AlunosRep alunos = new AlunosRep();
        EspacoCafeRep espaco = new EspacoCafeRep();
        EtapaRep etapa = new EtapaRep();
        alunos.setIdAluno(0);
        espaco.setIdEspaco(0);
        etapa.setIdEtapa(0);
        int idEspaco = Integer.parseInt(txtIdEspaco.getText());  
        int idEtapa = 0;
        if(radEtapa1.isSelected()){
            idEtapa = 1;
        }else if(radEtapa2.isSelected()){
            idEtapa = 2;
        }else {
           JOptionPane.showMessageDialog(this,"Selecione uma das etapas");
        }
        
        ArrayList<IdCompostoAlunoEtapaEspaco> listaidEspaco = new AlunoEtapaEspacoRep().listarPorIdEspacoComposto(idEspaco, idEtapa);
        
        for (int i = 0; i < listaidEspaco.size(); i++) {
            alunos.setIdAluno(listaidEspaco.get(i).getIdAluno());
            listaidEspaco.get(i).getIdEspaco();
            listaidEspaco.get(i).getIdEtapa();
            PopularJTable(listaidEspaco.get(i).getIdAluno(), idEspaco, idEtapa);
        }

        System.out.println(listaidEspaco);
    }//GEN-LAST:event_btnEspacoActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPesquisaEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPesquisaEspaco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager EventSystemPUEntityManager;
    private java.util.List<repository.Alunoetapaespaco> alunoetapaespacoList;
    private javax.persistence.Query alunoetapaespacoQuery;
    private java.util.List<repository.Alunoetapasala> alunoetapasalaList;
    private javax.persistence.Query alunoetapasalaQuery;
    private javax.swing.JButton btnEspaco;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radEtapa1;
    private javax.swing.JRadioButton radEtapa2;
    private javax.swing.JTable tblEspaco;
    private javax.swing.JTextField txtIdEspaco;
    // End of variables declaration//GEN-END:variables
}
