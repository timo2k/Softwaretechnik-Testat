package tests;

import Befehle.*;
import Kreuzung.Kreuzung;
import Verkehrsteilnehmer.Auto;
import Verkehrsteilnehmer.Verkehrsteilnehmer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Klasse für diverse jUnit Tests.
 * @author Timo Ischen
 */
class KreuzungTesten {

    private static Aufrufer steuerung = new Aufrufer();
    private static Verkehrsteilnehmer[] verkersteilnehmer;
    private static Kreuzung kreuzung = new Kreuzung();
    private static FahreNorden fahreNorden;
    private static FahreOsten fahreOsten;
    private static FahreSueden fahreSueden;
    private static FahreWesten fahreWesten;

    private static void fahrenLassen(int index) {
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

    private static void regelnPruefen() {

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


    @Test
    void zeigeDasAlleFahrzeugeOhneKonfliktFahren() {
        verkersteilnehmer = new Verkehrsteilnehmer[3];
        verkersteilnehmer[0] = new Auto("Sueden", "Norden");
        verkersteilnehmer[1] = new Auto("Westen", "Osten");
        verkersteilnehmer[2] = new Auto("Osten", "Sueden");
        kreuzung.addVerkehrsteilnehmer(verkersteilnehmer[0]);
        kreuzung.addVerkehrsteilnehmer(verkersteilnehmer[1]);
        kreuzung.addVerkehrsteilnehmer(verkersteilnehmer[2]);
        Assert.assertThat(kreuzung.vtSued.size(), is(1));
        Assert.assertThat(kreuzung.vtWest.size(), is(1));
        Assert.assertThat(kreuzung.vtOst.size(), is(1));
        regelnPruefen();
        Assert.assertThat(kreuzung.vtSued.size(), is(0));
        Assert.assertThat(kreuzung.vtWest.size(), is(0));
        Assert.assertThat(kreuzung.vtOst.size(), is(0));

    }

}