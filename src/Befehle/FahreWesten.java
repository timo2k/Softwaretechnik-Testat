package Befehle;

import Interfaces.Befehl;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Konkreter Befehl um ein Verkehrsteilnehmer nach Westen zu bewegen.
 * @author Timo Ischen
 */
public class FahreWesten implements Befehl {

    /**
     * Verkehrsteilnehmer Objekt
     */
    private Verkehrsteilnehmer verkehrsteilnehmer;

    /**
     * Verkehrsteilnehmer Objekt wird gesetzt um es hinterher nach Westen zu bewegen
     * @param verkehrsteilnehmer
     *          Verkehrsteilnehmer Objekt
     */
    public FahreWesten(Verkehrsteilnehmer verkehrsteilnehmer){
        this.verkehrsteilnehmer = verkehrsteilnehmer;
    }

    @Override
    public void ausfuehren() {
        verkehrsteilnehmer.bewegeWesten();
    }
}
