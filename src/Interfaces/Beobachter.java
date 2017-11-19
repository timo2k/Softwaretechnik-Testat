package Interfaces;

import Verkehrsteilnehmer.Verkehrsteilnehmer;

/**
 * Beobachter Interface, welches vom Subjekt über Änderungen informiert wird.
 * @author Timo Ischen
 */
public interface Beobachter {
    /**
     * Funktion, welche das jeweilige Verkehrsteilnehmerobjekt an der Nördlichen
     * Straße aktualisieren soll.
     * @param vt
     *          Verkehrsteilnehmer Objekt
     */
    public void vtNordAktualisieren(Verkehrsteilnehmer vt);

    /**
     * Funktion, welche das jeweilige Verkehrsteilnehmerobjekt an der Östlichen
     * Straße aktualisieren soll.
     * @param vt
     *          Verkehrsteilnehmer Objekt
     */
    public void vtOstAktualisieren(Verkehrsteilnehmer vt);

    /**
     * Funktion, welche das jeweilige Verkehrsteilnehmerobjekt an der Südlichen
     * Straße aktualisieren soll.
     * @param vt
     *          Verkehrsteilnehmer Objekt
     */
    public void vtSuedAktualisieren(Verkehrsteilnehmer vt);

    /**
     * Funktion, welche das jeweilige Verkehrsteilnehmerobjekt an der Westlichen
     * Straße aktualiseren soll.
     * @param vt
     *          Verkehrsteilnehmer Objekt
     */
    public void vtWestAktualisieren(Verkehrsteilnehmer vt);
}
