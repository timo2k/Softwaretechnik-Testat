package Befehle;

import Interfaces.Befehl;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Konkreter Befehl um ein Verkehrsteilnehmer nach Norden zu bewegen.
 * @author Timo Ischen
 */
public class FahreNorden implements Befehl {

    /**
     * Verkehrsteilnehmer Objekt
     */
    private Verkehrsteilnehmer verkehrsteilnehmer;

    /**
     * Verkehrsteilnehmer Objekt wird gesetzt um es hinterher nach Norden zu bewegen
     * @param verkehrsteilnehmer
     *          Verkehrsteilnehmer Objekt
     */
    public FahreNorden(Verkehrsteilnehmer verkehrsteilnehmer) {
        this.verkehrsteilnehmer = verkehrsteilnehmer;
    }

    @Override
    public void ausfuehren() {
        verkehrsteilnehmer.bewegeNorden();
    }
}
