/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.arbre.mvc.Modele;
import java.util.Date;

/**
 *
 * @author florian
 */
public class SaveAsJDialog extends javax.swing.JDialog {

    private Modele modele;
    
    /**
     * Creates new form SaveAsJDialog
     */
    public SaveAsJDialog(java.awt.Frame parent, boolean modal, Modele mod) {
        super(parent, modal);
        modele = mod;
        initComponents();
        this.setTitle("Enregistrer Sous ...");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        arbreNameJTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        duplicateJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nom :");

        arbreNameJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbreNameJTFActionPerformed(evt);
            }
        });

        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        duplicateJLabel.setForeground(new java.awt.Color(255, 0, 0));
        duplicateJLabel.setText(" ");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(duplicateJLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(arbreNameJTF))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 172, Short.MAX_VALUE)
                        .add(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(arbreNameJTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(duplicateJLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         ArbreBinaireFacade.persisteArbre(new ArbreCompletDto(arbreNameJTF.getText(), new Date(),modele.getArbre()));
         this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void arbreNameJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbreNameJTFActionPerformed

    }//GEN-LAST:event_arbreNameJTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arbreNameJTF;
    private javax.swing.JLabel duplicateJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
