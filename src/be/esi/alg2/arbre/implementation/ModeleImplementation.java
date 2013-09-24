/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.implementation;


import be.esi.alg2.arbre.mvc.ArbreModificationListener;
import be.esi.alg2.arbre.mvc.ArbreSelectionListener;
import be.esi.alg2.arbre.mvc.Modele;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.ProfondeurMaximaleAtteinteException;
import be.esi.alg2.arbre.mvc.Valeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alain
 */
public class ModeleImplementation implements Modele {

    private ArbreBinaireImplementation arbre;
    private NoeudBinaireImplementation sel;
    private List<ArbreModificationListener> arbreModlisteners;  //écouteurs des modifications de l'arbre
    private List<ArbreSelectionListener> arbreSellisteners;     //écouteurs des sélections de noeud de l'arbre

    public ModeleImplementation() {
        arbreModlisteners = new ArrayList<ArbreModificationListener>();
        arbreSellisteners = new ArrayList<ArbreSelectionListener>();
        arbre = new ArbreBinaireImplementation();
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre infixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getGRD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre préfixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getRGD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre postfixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getGDR() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * ajoute la valeur fournie à l'arbre
     *
     * @param valeur
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     * @throws ProfondeurMaximaleAtteinteException si l'ajout se fait au delà de
     * la profondeur maximale permise
     */
    @Override
    public void addValeur(Valeur valeur) throws  ProfondeurMaximaleAtteinteException {
        int cle = valeur.getCle();
        if (arbre.getRacine() == null) {
            arbre.setRacine(new NoeudBinaireImplementation(valeur));
        } else {
            int i = 2;
            NoeudBinaireImplementation nb = arbre.getRacine();
            while ((nb.getGauche() != null && cle <= nb.getVal().getCle())
                    || nb.getDroite() != null && cle > nb.getVal().getCle()) {
                if (cle <= nb.getVal().getCle()) {
                    nb = nb.getGauche();
                } else {
                    nb = nb.getDroite();
                }
                i++;
            }
            if (i <= 5) {
                if (cle <= nb.getVal().getCle()) {
                    nb.setGauche(new NoeudBinaireImplementation(valeur));
                }else{
                    nb.setDroite(new NoeudBinaireImplementation(valeur));
                }
            }else{
                throw new ProfondeurMaximaleAtteinteException();
            }
        }
        fire();
    }

    /**
     * retire à l'arbre le sous-arbre de racine noeud
     *
     * @param noeud racine du sous-arbre à ôter
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public void oteSousArbre(NoeudBinaire noeud) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    /**
     * retourne l'arbre repris par le modèle
     * @return the arbre
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public ArbreBinaireImplementation getArbre() {
        return arbre;
    }

    /**
     * retourne le NoeudBinaire sélectionné, null à défaut.
     * @return the sel
     */
    @Override
    public NoeudBinaire getSel() {
        return sel;
    }

    /**
     * positionne le noeud sélectionné au noeud fourni
     * @param sel the sel to set
     */
    @Override
    public void setSel(NoeudBinaire sel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addModificationListener(ArbreModificationListener listener) {
        arbreModlisteners.add(listener);
    }

    @Override
    public void removeModificationListener(ArbreModificationListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addSelectionListener(ArbreSelectionListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeSelectionListener(ArbreSelectionListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * retire le noeud fourni de l'arbre courant
     *  A NE PAS DEVELOPPER
     * @param noeud 
     */
    @Override
    public void oteNoeud(NoeudBinaire noeud) {
  throw new UnsupportedOperationException("Not supported yet.");
    }



    /*
     * crée un nouvela arbre vide dans le modèle
     */
    @Override
    public void nouvelArbre() {
       arbre = new ArbreBinaireImplementation();
       fire();
    }
    
    private void fire(){
        for(ArbreModificationListener unArbre: arbreModlisteners){
            unArbre.notifyModArbre();
        }
    }
}
