package Kreuzung;


import Interfaces.Beobachter;
import Interfaces.Subjekt;
import Verkehrsteilnehmer.Verkehrsteilnehmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasse, welche den Beobachter implementiert und die Verkehrskreuzung sowie die Fahrzeuge die sich
 * darauf befinden verwaltet.
 * @author Timo Ischen
 */
public class Kreuzung extends Thread implements Beobachter {
    /**
     * Arraylist welche erstmal alle Verkehrsteilnehmer der Kreuzung hält
     */
    private ArrayList<Subjekt> verkehrsteilnehmer;

    /**
     * Arraylist, welche alle Verkehrsteilnehmer beinhaltet, die sich auf der Nördlichen
     * Straße befinden.
     */
    public Queue vtNord;

    /**
     * Arraylist, welche alle Verkehrsteilnehmer beinhaltet, die sich auf der Östlichen
     * Straße befinden.
     */
    public Queue vtOst;

    /**
     * Arraylist, welche alle Verkehrsteilnehmer beinhaltet, die sich auf der Südlichen
     * Straße befinden
     */
    public Queue vtSued;

    /**
     * Arraylist, welche alle Verkehrsteilnehmer beinhaltet, die sich auf der Westlichen
     * Straße befinden
     */
    public Queue vtWest;

    /**
     * Ampeln von der Nördlichen und Südlichen Straße. Ist der Wert auf True, so gilt die
     * Ampel als grün
     */
    public Boolean lightNSIsgreen = false;

    /**
     * AMpeln von der Westlichen und Östlichen Straße. Ist der Wert auf True, so gilt die
     * Ampel als grün
     */
    public Boolean lightWOIsgreen = true;

    /**
     * Mit erzeugen der Klasse Verkehrskreuzung werden auch gleichzeitig die Arraylisten
     * der Verkehrsteilnehmer initialisiert.
     */
    public Kreuzung() {
        verkehrsteilnehmer = new ArrayList();
        vtNord = new LinkedList();
        vtOst = new LinkedList();
        vtSued = new LinkedList();
        vtWest = new LinkedList();
        start();
    }

    /**
     * Fügt einen neuen Verkehrsteilnehmer der Kreuzung hinzu. Je nachdem welche aktuelle
     * Position der Verkehrsteilnehmer besitzt, wird er dann der jeweiligen Straße zugeordnet
     * @param verkehrsteilnehmer
     *              Verkehrsteilnehmer Objekt bzw. Subjekt des Observer patterns.
     */
    public void addVerkehrsteilnehmer(Subjekt verkehrsteilnehmer) {
        this.verkehrsteilnehmer.add(verkehrsteilnehmer);
    verkehrsteilnehmer.registriereBeobachter(this);

        switch (verkehrsteilnehmer.getAktuellePosition()) {
            case "Norden":
                vtNord.add(verkehrsteilnehmer);
                break;
            case "Osten":
                vtOst.add(verkehrsteilnehmer);
                break;
            case "Sueden":
                vtSued.add(verkehrsteilnehmer);
                break;
            case "Westen":
                vtWest.add(verkehrsteilnehmer);
                break;
        }
    }

    /**
     * Entfernt das jeweilige Fahrzeug wieder von der Straße, wenn es gefahren ist.
     * @param vt
     *          Verkehrsteilnehmer Objekt
     */
    private void fahrzeugEntferner(Verkehrsteilnehmer vt) {
        switch (vt.getAktuellePosition()) {
            case "Norden":
                vtNord.remove(vt);
                break;
            case "Osten":
                vtOst.remove(vt);
                break;
            case "Sueden":
                vtSued.remove(vt);
                break;
            case "Westen":
                vtWest.remove(vt);
                break;
        }
    }

    /**
     * Funktion, welche die Ampeln auf der Kreuzung hin und her schaltet.
     */
    public void lightSwitcher() {
        if (lightNSIsgreen) {
            lightNSIsgreen = false;
            lightWOIsgreen = true;
            System.out.println("\nAmpel Nord/Süd ist nun Rot");
            System.out.println("Ampel West/Ost ist nun Grün\n");
        } else {
            lightNSIsgreen = true;
            lightWOIsgreen = false;
            System.out.println("\nAmpel West/Ost ist nun Rot");
            System.out.println("Ampel Nord/Süd ist nun Grün\n");
        }
    }

    @Override
    public void vtNordAktualisieren(Verkehrsteilnehmer vt) {
        fahrzeugEntferner(vt);
        //vtNord.add(vt);

    }

    @Override
    public void vtOstAktualisieren(Verkehrsteilnehmer vt) {
        fahrzeugEntferner(vt);
        //vtOst.add(vt);
    }

    @Override
    public void vtSuedAktualisieren(Verkehrsteilnehmer vt) {
        fahrzeugEntferner(vt);
        //vtSued.add(vt);
    }

    @Override
    public void vtWestAktualisieren(Verkehrsteilnehmer vt) {
        fahrzeugEntferner(vt);
        //vtWest.add(vt);
    }

    @Override
    public String toString() {
        return "\n##################### STATUS DER KREUZUNG ########################### \n" +
                "Im Norden befinden sich: " + vtNord.size() + " Verkehrsteilnehmer \n" +
                "Im Osten befinden sich: " + vtOst.size() + " Verkehrsteilnehmer \n" +
                "Im Sueden befinden sich: " + vtSued.size() + " Verkehrsteilnehmer \n" +
                "Im Westen befinden sich: " + vtWest.size() + " Verkehrsteilnehmer \n" +
                "####################################################################\n";
    }
}
