package Befehle;

import Interfaces.Befehl;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Konkreter Befehl um ein Verkehrsteilnehmer nach Süden zu bewegen.
 * @author Timo Ischen
 */
public class FahreSueden implements Befehl {

    /**
     * Verkehrsteilnehmer Objekt
     */
    private Verkehrsteilnehmer verkehrsteilnehmer;

    /**
     * Verkehrsteilnehmer Objekt wird gesetzt um es hinterher nach Süden zu bewegen
     * @param verkehrsteilnehmer
     *          Verkehrsteilnehmer Objekt
     */
    public FahreSueden(Verkehrsteilnehmer verkehrsteilnehmer) {
        this.verkehrsteilnehmer = verkehrsteilnehmer;
    }

    @Override
    public void ausfuehren() {
        verkehrsteilnehmer.bewegeSueden();
    }
}
