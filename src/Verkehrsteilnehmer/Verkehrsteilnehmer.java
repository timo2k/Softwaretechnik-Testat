package Verkehrsteilnehmer;

import Interfaces.Beobachter;
import Interfaces.Subjekt;

import java.util.ArrayList;

/**
 * Abstrakte Verkehrsteilnehmer Klasse, welche das Subjekt implementiert und somit den Beobachter (Kreuzung)
 * über jede aktualisierung informiert.
 * @author Timo Ischen
 */
public abstract class Verkehrsteilnehmer extends Thread implements Subjekt {
    /**
     * Arraylist welche alle Beobachter beinhaltet. In diesen Szenario ist dies letztendlich
     * nur die eine Verkehrskreuzung.
     */
    protected ArrayList beobachter;

    /**
     * Name des Fahrzeugs
     */
    private String name;

    /**
     * Aktuelle Position des Fahrzeugs als String (Norden, Sueden, Westen, Osten)
     */
    private String aktuellePosition;

    /**
     * Das Ziel des Fahrzeugs als String (Norden, Sueden, Westen, Osten)
     */
    private String ziel;

    /**
     * Mit Erzeugung des Obejkts wird die gleichzeitig die Arraylist initialisiert.
     */
    public Verkehrsteilnehmer() {
        beobachter = new ArrayList();
        start();
    }

    /**
     * Setzt den Namen des Verkehrsteilnehmers
     * @param name
     *          Name des Verkehrsteilnehmers
     */
    public void setVtName(String name) {
        this.name = name;
    }

    /**
     * Setzt die Aktuelle Position des Verkehrsteilnehmers
     * @param aktuellePos
     *          Aktuelle Position des Verkehrsteilnehmers (Norden, Sueden, Westen, Osten)
     */
    public void setAktuellePosition(String aktuellePos) {
        this.aktuellePosition = aktuellePos;
    }

    /**
     * Setzt das Ziel des Verkehrsteilnehmers als String
     * @param ziel
     *          Ziel des Verkehrsteilnehmers (Norden, Sueden, Westen, Osten)
     */
    public void setZiel(String ziel) {
        this.ziel = ziel;
    }

    /**
     * Gibt den Namen des Verkehrsteilnehmers als String zurück
     * @return
     *      Name des Verkehrsteilnehmers als String
     */
    public String getVtName() {
        return name;
    }

    @Override
    public String getAktuellePosition() {
        return aktuellePosition;
    }

    /**
     * Gibt das Ziel des Verkehrsteilnehmers zurück
     * @return
     *      Ziel als String
     */
    public String getZiel() {
        return ziel;
    }

    @Override
    public void registriereBeobachter(Beobachter b) {
        beobachter.add(b);
    }

    @Override
    public void entferneBeobachter(Beobachter b) {
        int i = beobachter.indexOf(b);
        if (i >= 0) {
            beobachter.remove(i);
        }
    }

    @Override
    public void aktualisiereBeobachter(String richtung) {
        for(int i = 0; i < beobachter.size(); i++) {
            Beobachter b = (Beobachter)beobachter.get(i);
            switch (richtung) {
                case "Norden":
                    b.vtNordAktualisieren(this);
                    setAktuellePosition("Norden");
                    break;
                case "Osten":
                    b.vtOstAktualisieren(this);
                    setAktuellePosition("Osten");
                    break;
                case "Sueden":
                    b.vtSuedAktualisieren(this);
                    setAktuellePosition("Sueden");
                    break;
                case "Westen":
                    b.vtWestAktualisieren(this);
                    setAktuellePosition("Westen");
                    break;
            }
        }
    }

    /**
     * Befehl, welches den Verkehrsteilnehmer nach Norden bewegen soll
     */
    public abstract void bewegeNorden();

    /**
     * Befehl welcher den Verkehrsteilnehmer, nach Osten bewegen soll
     */
    public abstract void bewegeOsten();

    /**
     * Befehl, welcher den Verkehrsteilnehmer nach Süden bewegen soll
     */
    public abstract void bewegeSueden();

    /**
     * Befehl, welcher den Verkehrsteilnehmer nach Westen bewegen soll
     */
    public abstract void bewegeWesten();

    /**
     * Befehl, welcher den Verkehrsteilnehmer warten lassen soll, wenn bspw. die Ampel
     * rot ist oder die Kreuzung belegt ist.
     */
    public abstract void warte();

    /**
     * Gibt den Namen, aktuelle Position und das Ziel des Verkehrsteilnehmers als String aus.
     * @return
     *      Informationen zum einzelnen Verkehrsteilnehmer.
     */
    @Override
    public String toString() {
        return "Name: " + getVtName() + " Aktuelle Position: " + getAktuellePosition() + " Ziel: " + getZiel();
    }
}
