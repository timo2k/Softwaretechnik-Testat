package Verkehrsteilnehmer;

/**
 * Konkrete Klasse des Autos als Verkehrsteilnehmer.
 * @author Timo Ischen
 */
public class Auto extends Verkehrsteilnehmer {
    /**
     * Mit der Erzeugung des Auto Objekts bekommt das Auto ein Start- und Zielpunkt zugewiesen.
     * @param start
     *          Startpunkt als String. Gültige Übergabeparamter sind: Norden, Sueden, Westen, Osten.
     * @param ziel
     *          Startpunkt als String. Gültige Übergabeparamter sind: Norden, Sueden, Westen, Osten.
     */
    public Auto(String start, String ziel) {
        setAktuellePosition(start);
        setZiel(ziel);
        setVtName("Auto");
        System.out.println(getVtName() + " erscheint im " + getAktuellePosition());
    }

    @Override
    public void bewegeNorden() {
        System.out.println("Das " + getVtName() +  " fährt von " + getAktuellePosition() + " richtung Norden");
        aktualisiereBeobachter("Norden");
    }

    @Override
    public void bewegeOsten() {
        System.out.println("Das " + getVtName() + " fährt von " + getAktuellePosition() + " richtung Osten");
        aktualisiereBeobachter("Osten");
    }

    @Override
    public void bewegeSueden() {
        System.out.println("Das " + getVtName() + " fährt von " + getAktuellePosition() + " richtung Sueden");
        aktualisiereBeobachter("Sueden");

    }

    @Override
    public void bewegeWesten() {
        System.out.println("Das " + getVtName() + " fährt von " + getAktuellePosition() + " richtung Westen");
        aktualisiereBeobachter("Westen");
    }

    @Override
    public void warte() {
        System.out.println("Das " + getVtName() + " wartet auf der Straße im " + getAktuellePosition());
    }
}
