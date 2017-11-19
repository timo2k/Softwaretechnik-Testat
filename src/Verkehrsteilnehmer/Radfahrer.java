package Verkehrsteilnehmer;

/**
 * Konkrete Klasse für den Radfahrer als Verkehrsteilnehmer
 * @author Timo Ischen
 */
public class Radfahrer extends Verkehrsteilnehmer {
    /**
     * Legt einen neuen Radfahrer mit Start- und Zielpunkt an. Zudem wird der Radfahrer mit einem Namen
     * gekennzeichnet.
     * @param start
     *          Startparamter als String. Norden, Osten, Sueden, Westen sind hierbei die gültigen
     *          Übergabeparameter
     * @param ziel
     *          Zielparamter als String. Norden, Osten, Sueden, Westen sind hierbei die gültigen
     *          Übergabeparameter
     */
    public Radfahrer(String start, String ziel) {
        setAktuellePosition(start);
        setZiel(ziel);
        setVtName("Radfahrer");
        System.out.println(getVtName() + " erscheint im " + getAktuellePosition());
    }

    @Override
    public void bewegeNorden() {
        System.out.println("Der "+ getVtName() +" radelt von " + getAktuellePosition() + " richtung Norden");
        aktualisiereBeobachter("Norden");
    }

    @Override
    public void bewegeOsten() {
        System.out.println("Der "+ getVtName() +" radelt von " + getAktuellePosition() + " richtung Osten");
        aktualisiereBeobachter("Osten");
    }

    @Override
    public void bewegeSueden() {
        System.out.println("Der "+ getVtName() +" radelt von " + getAktuellePosition() + " richtung Süden");
        aktualisiereBeobachter("Sueden");
    }

    @Override
    public void bewegeWesten() {
        System.out.println("Der "+ getVtName() +" radelt von " + getAktuellePosition() + " richtung Westen");
        aktualisiereBeobachter("Westen");
    }

    @Override
    public void warte() {
        System.out.println("Der "+ getVtName() +" wartet im " + getAktuellePosition());
    }
}
