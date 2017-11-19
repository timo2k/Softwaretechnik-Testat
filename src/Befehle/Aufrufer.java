package Befehle;

import Interfaces.Befehl;

/**
 * Hier werden die einzelnen Befehle zum Fahren übergeben und letztendlich auch ausgeführt.
 * @author Timo Ischen
 */
public class Aufrufer {

    /**
     * Befehlsinterface, welches in die Konkreten Befehle implementiert wird.
     */
    Befehl befehl;

    /**
     * Einzelner Befehl wird übergeben bzw. gesetzt
     * @param befehl
     *          Der konkrete Befehl
     */
    public void setBefehl(Befehl befehl) {
        this.befehl = befehl;
    }

    /**
     * Der zuvor gesetzte Befehl wird ausgeführt.
     */
    public void feuern() {
        befehl.ausfuehren();
    }
}
