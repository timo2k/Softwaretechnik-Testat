package Interfaces;

/**
 * Interface für sämtliche Befehle. Jeder konkrete Befehl implementiert
 * dieses Interface.
 * @author Timo Ischen
 */
public interface Befehl {

    /**
     * Befehl wird ausgeführt
     */
    public void ausfuehren();
}
