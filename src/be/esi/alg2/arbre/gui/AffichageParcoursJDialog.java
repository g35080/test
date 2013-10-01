/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.mvc.ArbreModificationListener;
import be.esi.alg2.arbre.mvc.ArbreSelectionListener;
import be.esi.alg2.arbre.mvc.Modele;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import java.util.List;

/**
 *
 * @author florian
 */
public class AffichageParcoursJDialog extends javax.swing.JDialog implements ArbreSelectionListener, ArbreModificationListener {

    public Modele modele;
    public List<NoeudBinaire> listeParcours;
    public String typeParcours;
    public static final String GRD ="Parcours GRD";
    public static final String GDR ="Parcours GDR";
    public static final String RGD ="Parcours RGD";
    /**
     * Creates new form AffichageParcoursJDialog
     */
    public AffichageParcoursJDialog(java.awt.Frame parent, boolean modal, Modele mod, String str) {
        super(parent, modal);
        initComponents();
        modele = mod;
        typeParcours = str;
        this.setTitle(str);
        notifyModArbre();
        notifyNewSelection(modele.getSel());
    }

    @Override
    public void notifyNewSelection(NoeudBinaire nb) {
        if(nb ==null){
            parcoursJList.clearSelection();
        }else{
            for(int i = 0; i <listeParcours.size(); i++){
                if (listeParcours.get(i) == nb) {
                    parcoursJList.setSelectedIndex(i);
                }
            }
        }
    }
    
    @Override
    public void notifyModArbre() {
        if(typeParcours.equals(GRD)){
            listeParcours = modele.getGRD();
        }else if(typeParcours.equals(GDR)){
            listeParcours = modele.getGDR();
        }else{
            listeParcours = modele.getRGD();
        }
        parcoursJList.setListData(listeParcours.toArray());
        this.pack();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parcoursJList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        parcoursJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        parcoursJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                parcoursJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(parcoursJList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parcoursJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_parcoursJListValueChanged
        modele.setSel((NoeudBinaire) parcoursJList.getSelectedValue());
    }//GEN-LAST:event_parcoursJListValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList parcoursJList;
    // End of variables declaration//GEN-END:variables
}