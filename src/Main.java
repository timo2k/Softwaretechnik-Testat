import Befehle.Aufrufer;
import Befehle.*;
import Kreuzung.Kreuzung;
import Verkehrsteilnehmer.*;

import java.util.ArrayList;

/**
 * Main Klasse, welche sich hauptsächlich darum kümmert die Fahrzeuge sowie die Kreuzung zu erzeugen und die Fahrzeuge
 * gemäß ihrer zufällig ausgewürfelten Intention dementsprechend handeln zu lassen.
 * @author Timo Ischen
 */
public class Main extends Thread {
    /**
     * Aufrufer an welchen die Befehle übergeben werden
     */
    private static Aufrufer steuerung = new Aufrufer();

    /**
     * Hier werden alle zuvor erzeugten Verkehrsteilnehmer reingepackt
     */
    private static Verkehrsteilnehmer[] verkersteilnehmer;

    /**
     * Das Kreuzungsobjekt auf welchen sich die Verkehrsteilnehmer befinden
     */
    private static Kreuzung kreuzung = new Kreuzung();

    /**
     * Konkreter Befehl um nach Norden zu fahren.
     */
    private static FahreNorden fahreNorden;

    /**
     * Konkreter Befehl um nach Osten zu fahren.
     */
    private static FahreOsten fahreOsten;

    /**
     * Konkreter Befehl um nach Süden zu fahren.
     */
    private static FahreSueden fahreSueden;

    /**
     * Konkreter Befehl um nach Westen zu fahren.
     */
    private static FahreWesten fahreWesten;

    /**
     * Generiert einen zufälligen Start order Zielpunkt für den neuen Verkehrsteilnehmer.
     */
    private static String generateRichtung() {
        int richtung;
        richtung = (int) (Math.random() * 4) + 1;

        switch (richtung) {
            case 1:
                return "Norden";
            case 2:
                return "Osten";
            case 3:
                return "Sueden";
            case 4:
                return "Westen";
            default:
                return "Norden";
        }
    }


    /**
     * Erzeugt zufällige Verkehrsteilnehmer mit zufälligen Parametern.
     * @param anzahl
     *          Die Anzahl der Verkehrsteilnehmer die erzeugt werden soll.
     */
    private static void erzeugeFahrzeuge(int anzahl) {
        verkersteilnehmer = new Verkehrsteilnehmer[anzahl];

        for (int i = 0; i < verkersteilnehmer.length; i++) {

            // Zufällige Zahl zwischen 1 und 3
            int fahrzeug;
            fahrzeug = (int) (Math.random() * 3 + 1);

            // Je nach gewürfelte Zahl wird ein anderer Verkehrsteilnehmer generiert.
            if (fahrzeug == 1) {
                verkersteilnehmer[i] = new Auto(generateRichtung(), generateRichtung());
                verkersteilnehmer[i].setVtName("Auto " + i);
            } else if (fahrzeug == 2) {
                verkersteilnehmer[i] = new Radfahrer(generateRichtung(), generateRichtung());
                verkersteilnehmer[i].setVtName("Radfahrer " + i);
            } else if (fahrzeug == 3) {
                verkersteilnehmer[i] = new Fussgaenger(generateRichtung(), generateRichtung());
                verkersteilnehmer[i].setVtName("Fussgaenger " + i);
            }

            // Prüft ob Startposition und Ziel gleich sind. Wenns zutrifft dann wird ein neues Ziel ausgewürfelt.
            while (verkersteilnehmer[i].getAktuellePosition() == verkersteilnehmer[i].getZiel()) {
                verkersteilnehmer[i].setZiel(generateRichtung());
            }

            // Verkehrsteilnehmer wird auf Krezung gepackt.
            kreuzung.addVerkehrsteilnehmer(verkersteilnehmer[i]);
        }
    }

    /**
     * Prüft wohin der Verkehrsteilnehmer fahren möchte und lässt ihn über das Befehlsmuster in die
     * entsprechende Richtung fahren.
     * @param index
     *          Index des Fahrzeugs im Verkehrsteilnehmer Array
     */
    public static void fahrenLassen(int index) {
            if (verkersteilnehmer[index].getZiel() == "Norden") {
                fahreNorden = new FahreNorden(verkersteilnehmer[index]);
                steuerung.setBefehl(fahreNorden);
                steuerung.feuern();
            } else if (verkersteilnehmer[index].getZiel() == "Sueden") {
                fahreSueden = new FahreSueden(verkersteilnehmer[index]);
                steuerung.setBefehl(fahreSueden);
                steuerung.feuern();
            } else if (verkersteilnehmer[index].getZiel() == "Westen") {
                fahreWesten = new FahreWesten(verkersteilnehmer[index]);
                steuerung.setBefehl(fahreWesten);
                steuerung.feuern();
            } else if (verkersteilnehmer[index].getZiel() == "Osten") {
                fahreOsten = new FahreOsten(verkersteilnehmer[index]);
                steuerung.setBefehl(fahreOsten);
                steuerung.feuern();
            }

    }

    /**
     * Lässt anhand der Intention des Verkehrsteilnehmers ihn in die Entsprechende Richtung Fahren sofern
     * die Ampel auf den jeweiligen Straßen grün zeigt.
     */
    public static void regelnPruefen() {

        // Wenn Ampeln im Westen und Osten grün, dann fahren die jeweiligen Fahrzeuge auf der Straße
        if (kreuzung.lightWOIsgreen) {
            for (int i = 0; i < verkersteilnehmer.length; i++) {
                if (verkersteilnehmer[i].getAktuellePosition() == "Westen") {
                    fahrenLassen(i);
                } else if (verkersteilnehmer[i].getAktuellePosition() == "Osten") {
                    fahrenLassen(i);
                }
            }

            kreuzung.lightSwitcher();

            // Wenn Ampeln im Norden und Süden grün, dann fahren die jeweiligen Fahrzeuge auf der Straße
            if (kreuzung.lightNSIsgreen)
            for (int i = 0; i < verkersteilnehmer.length; i++) {
                if (verkersteilnehmer[i].getAktuellePosition() == "Norden") {
                    fahrenLassen(i);
                } else if (verkersteilnehmer[i].getAktuellePosition() == "Sueden") {
                    fahrenLassen(i);
                }
            }

        }


    }

    /**
     * Einstiegspunkt des Programms. Hier werden hauptsächlich die Fahrzeuge erzeugt und die Verkehrsregeln geprüft.
     * Im Anschluss werden die jeweiligen Befehle ausgeführt.
     * @param args
     *          Argumente.
     */
    public static void main(String[] args) {


        // Konkrete Verkehrsteilnehmer erzeugen und zufällig auf Kreuzung setzen
        erzeugeFahrzeuge(20);


        //Aktuelle Belegungen in der Kreuzung
        System.out.println(kreuzung.toString());

        // Lässt die Fahrzeuge gemäß ihres Ziels fahren.
        regelnPruefen();


        // Ausgabe wieviele Verkehsteilnehmer sich auf den einzlenen Straßen befinden
        System.out.println(kreuzung.toString());
    }
}
