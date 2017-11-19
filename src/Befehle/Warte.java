package Befehle;

import Interfaces.Befehl;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Befehl, welcher den Verkehrsteilnehmer warten lässt wenn die Straße belegt ist.
 * @author Timo Ischen
 */
public class Warte implements Befehl {

    /**
     * Verkehrsteilnehmer Objekt
     */
    private Verkehrsteilnehmer verkehrsteilnehmer;

    /**
     * Verkehrsteilnehmer Objekt wird gesetzt um es hinterher warten zu lassen
     * @param verkehrsteilnehmer
     *          Verkehrsteilnehmer Objekt
     */
    public Warte(Verkehrsteilnehmer verkehrsteilnehmer) {
        this.verkehrsteilnehmer = verkehrsteilnehmer;
    }

    @Override
    public void ausfuehren() {
        verkehrsteilnehmer.warte();
    }
}
