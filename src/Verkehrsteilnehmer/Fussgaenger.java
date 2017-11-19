package Verkehrsteilnehmer;

/**
 * Konkrete Klasse des Fußgängers als Verkehrsteilnehmer.
 * @author Timo Ischen
 */
public class Fussgaenger extends Verkehrsteilnehmer {
    /**
     * Mit erzeugen des Fußgängers müssen zwei Übergabeparameter übergeben werden. Der Startpunkt
     * und das Ziel des Fußgängers. Zudem wird dem Fußgänger automatisch ein Name zugewiesen.
     * @param start
     *          Startpunkt des Fußgängers als String. Gültige Übergabeparamter sind:
     *          Norden, Sueden, Osten, Westen.
     * @param ziel
     *          Ziel des Fußgängers als String. Gültige Übergabeparamter sind:
     *          Norden, SUeden, Osten, Westen.
     */
    public Fussgaenger(String start, String ziel) {
        setAktuellePosition(start);
        setZiel(ziel);
        setVtName("Fußgänger");
        System.out.println(getVtName() + " erscheint im " + getAktuellePosition());
    }

    @Override
    public void bewegeNorden() {
        System.out.println("Der " + getVtName() +" läuft von " + getAktuellePosition() + " richtung Norden");
        aktualisiereBeobachter("Norden");
    }

    @Override
    public void bewegeOsten() {
        System.out.println("Der "+ getVtName() +" läuft von " + getAktuellePosition() + " richtung Osten");
        aktualisiereBeobachter("Osten");
    }

    @Override
    public void bewegeSueden() {
        System.out.println("Der "+ getVtName() +" läuft von " + getAktuellePosition() + " richtung Süden");
        aktualisiereBeobachter("Sueden");
    }

    @Override
    public void bewegeWesten() {
        System.out.println("Der "+ getVtName() +" läuft von " + getAktuellePosition() + " richtung Westen");
        aktualisiereBeobachter("Westen");
    }

    @Override
    public void warte() {
        System.out.println("Der "+ getVtName() +" wartet im " + getAktuellePosition());
    }
}
