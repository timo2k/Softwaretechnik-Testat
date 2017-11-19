package Befehle;

import Interfaces.Befehl;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Konkreter Befehl um ein Verkehrsteilnehmer nach Osten zu bewegen.
 * @author Timo Ischen
 */
public class FahreOsten implements Befehl {

    /**
     * Verkehrsteilnehmer Objekt
     */
    private Verkehrsteilnehmer verkehrsteilnehmer;

    /**
     * Verkehrsteilnehmer Objekt wird gesetzt um es hinterher nach Osten zu bewegen
     * @param verkehrsteilnehmer
     *          Verkehrsteilnehmer Objekt
     */
    public FahreOsten(Verkehrsteilnehmer verkehrsteilnehmer) {
        this.verkehrsteilnehmer = verkehrsteilnehmer;
    }

    @Override
    public void ausfuehren() {
        verkehrsteilnehmer.bewegeOsten();
    }
}
