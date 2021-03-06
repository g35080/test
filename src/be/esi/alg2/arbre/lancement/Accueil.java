/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.lancement;

import be.esi.alg2.arbre.db.ArbreDbException;
import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.gui.AffichageParcoursJDialog;
import be.esi.alg2.arbre.gui.ChargerArbreJDialog;
import be.esi.alg2.arbre.gui.NouveauNoeudJDialog;
import be.esi.alg2.arbre.gui.SaveAsJDialog;
import be.esi.alg2.arbre.gui.VoirNoeudSelJDialog;
import be.esi.alg2.arbre.implementation.NoeudBinaireImplementation;
import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.arbre.mvc.ArbreModificationListener;
import be.esi.alg2.arbre.mvc.ArbreSelectionListener;
import be.esi.alg2.arbre.mvc.Modele;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.ProfondeurMaximaleAtteinteException;
import be.esi.alg2.visuarbre.VisuArbre;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * JFrame d'accueil de l'application de visualisation des arbres binaires
 */
public class Accueil extends javax.swing.JFrame implements ArbreSelectionListener {

    private NouveauNoeudJDialog nouvNoeud;
    private ChargerArbreJDialog chargerArbre;
    private SaveAsJDialog saveAs;
    private VoirNoeudSelJDialog vueNoeud;
    private AffichageParcoursJDialog affParcours;
    private Modele modele;
    private String nomArbreCourant;
    
    /**
     * Creates new form Accueil
     */
    public Accueil() {
        initComponents();
        jMsupprimer.setEnabled(false);
        jMDelSousArbre.setEnabled(false);
        modele = ArbreBinaireFacade.getModele();
        modele.addModificationListener(visuArbre1);
        modele.addSelectionListener(visuArbre1);
        
        visuArbre1.setModele(modele);
        setTitle("Arbre binaire ordonné");
        nomArbreCourant  = "";
        visuArbre1.addPropertyChangeListener(VisuArbre.NOEUDSELECTED, new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                modele.setSel((NoeudBinaireImplementation) pce.getNewValue());
            }
        });
        modele.addSelectionListener(this);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        visuArbre1 = new be.esi.alg2.visuarbre.VisuArbre();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMNouveau = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jAjoutNoeud = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMSauve = new javax.swing.JMenuItem();
        jMSaveAs = new javax.swing.JMenuItem();
        jLLoad = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuGRD = new javax.swing.JMenuItem();
        jMenuRGD = new javax.swing.JMenuItem();
        jMenuGDR = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMVoir = new javax.swing.JMenuItem();
        jMsupprimer = new javax.swing.JMenuItem();
        jMDelSousArbre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout visuArbre1Layout = new javax.swing.GroupLayout(visuArbre1);
        visuArbre1.setLayout(visuArbre1Layout);
        visuArbre1Layout.setHorizontalGroup(
            visuArbre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        visuArbre1Layout.setVerticalGroup(
            visuArbre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        getContentPane().add(visuArbre1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Arbre");

        jMNouveau.setText("Nouveau");
        jMNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNouveauActionPerformed(evt);
            }
        });
        jMenu1.add(jMNouveau);
        jMenu1.add(jSeparator1);

        jAjoutNoeud.setText("Ajout d'un noeud");
        jAjoutNoeud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAjoutNoeudActionPerformed(evt);
            }
        });
        jMenu1.add(jAjoutNoeud);
        jMenu1.add(jSeparator3);

        jMSauve.setText("Sauver");
        jMSauve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSauveActionPerformed(evt);
            }
        });
        jMenu1.add(jMSauve);

        jMSaveAs.setText("Sauver comme ...");
        jMSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(jMSaveAs);

        jLLoad.setText("Charger un arbre");
        jLLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLLoadActionPerformed(evt);
            }
        });
        jMenu1.add(jLLoad);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vues");

        jMenuGRD.setText("GRD");
        jMenuGRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGRDActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuGRD);

        jMenuRGD.setText("RGD");
        jMenuRGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRGDActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRGD);

        jMenuGDR.setText("GDR");
        jMenuGDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGDRActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuGDR);
        jMenu2.add(jSeparator4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Noeud Sélectionné");

        jMVoir.setText("Voir");
        jMVoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVoirActionPerformed(evt);
            }
        });
        jMenu3.add(jMVoir);

        jMsupprimer.setText("Supprimer");
        jMenu3.add(jMsupprimer);

        jMDelSousArbre.setText("Supprimer Sous-Arbre");
        jMDelSousArbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDelSousArbreActionPerformed(evt);
            }
        });
        jMenu3.add(jMDelSousArbre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAjoutNoeudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAjoutNoeudActionPerformed
        nouvNoeud= new NouveauNoeudJDialog(this, true);
        nouvNoeud.addPropertyChangeListener(NouveauNoeudJDialog.ajoutNoeud, new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    modele.addValeur(nouvNoeud.getValeur());
                } catch (ProfondeurMaximaleAtteinteException ex) {
                     JOptionPane.showMessageDialog(null, "Profondeur Maximale Atteinte", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        nouvNoeud.setVisible(true);
    }//GEN-LAST:event_jAjoutNoeudActionPerformed

    private void jMVoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVoirActionPerformed
        vueNoeud = new VoirNoeudSelJDialog(this, false);
        vueNoeud.notifyNewSelection(modele.getSel());
        vueNoeud.setVisible(true);
        modele.addSelectionListener(vueNoeud);
        vueNoeud.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                modele.removeSelectionListener((VoirNoeudSelJDialog) e.getSource());
            }
        });
    }//GEN-LAST:event_jMVoirActionPerformed

    private void afficherParcours(String str){
        affParcours = new AffichageParcoursJDialog(this, false, modele, str);
        affParcours.setVisible(true);
        modele.addModificationListener(affParcours);
        modele.addSelectionListener(affParcours);
        affParcours.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                modele.removeSelectionListener((ArbreSelectionListener) e.getSource());
                modele.removeModificationListener((ArbreModificationListener) e.getSource());
            }
        });
    }
    
    private void jMenuGRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGRDActionPerformed
        afficherParcours(AffichageParcoursJDialog.GRD);
    }//GEN-LAST:event_jMenuGRDActionPerformed

    private void jMenuRGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRGDActionPerformed
        afficherParcours(AffichageParcoursJDialog.RGD);
    }//GEN-LAST:event_jMenuRGDActionPerformed

    private void jMenuGDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGDRActionPerformed
        afficherParcours(AffichageParcoursJDialog.GDR);
    }//GEN-LAST:event_jMenuGDRActionPerformed

    private void jMNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNouveauActionPerformed
        modele.setSel(null);
        modele.nouvelArbre();
        nomArbreCourant  = "";
    }//GEN-LAST:event_jMNouveauActionPerformed

    private void jMSauveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSauveActionPerformed
        if(!nomArbreCourant.isEmpty()){
            ArbreBinaireFacade.persisteArbre(new ArbreCompletDto(nomArbreCourant, new Date(),modele.getArbre()));
        }else{
            saveAs= new SaveAsJDialog(this, false, modele);
            saveAs.setVisible(true);
        }
    }//GEN-LAST:event_jMSauveActionPerformed

    private void jLLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLLoadActionPerformed
        try {
            chargerArbre= new ChargerArbreJDialog(this, true);
            chargerArbre.addPropertyChangeListener(ChargerArbreJDialog.chargementArbre, new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ArbreCompletDto monArbre =chargerArbre.getArbreACharger();
                modele.nouvelArbre();
                nomArbreCourant = monArbre.getId();
                for(int i=0; i<monArbre.getListe().size();i++){
                    try {
                        modele.addValeur(monArbre.getListe().get(i));
                    } catch (ProfondeurMaximaleAtteinteException ex) {
                        Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            });
            chargerArbre.setVisible(true);
        } catch (ArbreDbException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLLoadActionPerformed

    private void jMSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSaveAsActionPerformed
        saveAs= new SaveAsJDialog(this, true, modele);
        saveAs.setVisible(true);
    }//GEN-LAST:event_jMSaveAsActionPerformed

    private void jMDelSousArbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDelSousArbreActionPerformed
        modele.oteSousArbre(modele.getSel());
    }//GEN-LAST:event_jMDelSousArbreActionPerformed

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAjoutNoeud;
    private javax.swing.JMenuItem jLLoad;
    private javax.swing.JMenuItem jMDelSousArbre;
    private javax.swing.JMenuItem jMNouveau;
    private javax.swing.JMenuItem jMSauve;
    private javax.swing.JMenuItem jMSaveAs;
    private javax.swing.JMenuItem jMVoir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuGDR;
    private javax.swing.JMenuItem jMenuGRD;
    private javax.swing.JMenuItem jMenuRGD;
    private javax.swing.JMenuItem jMsupprimer;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private be.esi.alg2.visuarbre.VisuArbre visuArbre1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notifyNewSelection(NoeudBinaire nb) {
        if(modele.getSel() == null){
            jMsupprimer.setEnabled(false);
            jMDelSousArbre.setEnabled(false);
        }else{
            jMsupprimer.setEnabled(true);
            jMDelSousArbre.setEnabled(true);
        }
    }
}
