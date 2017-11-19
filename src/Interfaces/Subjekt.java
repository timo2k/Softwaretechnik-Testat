package Interfaces;

/**
 * Interface des Subjekts. Ändert sich der Status des Subjekts, teilt es seinen Beobachtern die dementsprechende
 * Veränderung mit.
 * @author Timo Ischen
 */
public interface Subjekt {

    /**
     * Registriert einen neuen Beobachter, welcher dann vom Subjekt über alle
     * Änderungen informiert wird.
     * @param b
     *          Beobachter Objekt
     */
    public void registriereBeobachter(Beobachter b);

    /**
     * Entfernt einen Beobachter aus der Liste. Wird in diesem Szenario nicht verwendet
     * aber wurde der Vollständigkeithalber mit implementiert.
     * @param b
     *          Beobachter Objekt
     */
    public void entferneBeobachter(Beobachter b);

    /**
     * Aktualisiert den Beobachter über die Veränderung des Subjekts. Hierbei wird geprüft,
     * auf welcher Straße sich die Änderung bezieht. Trifft eine Bedingung zu, übergibt sich die
     * aktuelle Verkehrsteilnehmer Instanz dem Beobachter.
     * @param richtung
     *          Himmelsrichtung als String (Norden, Sueden, Osten, Westen)
     */
    public void aktualisiereBeobachter(String richtung);

    /**
     * Gibt die aktuelle Position des Fahrzeugs zurück
     * @return
     *      Aktuelle Position als String.
     */
    public String getAktuellePosition();
}
