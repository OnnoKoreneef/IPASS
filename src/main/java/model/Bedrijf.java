package model;

import java.util.ArrayList;
import java.util.List;

public class Bedrijf {
    private String naam;
    private String woonplaats;
    private String straatnaam;
    private int nummer;
    private int kvk;
    private int btwNummer;
    private List<Medewerker> medewerkers = new ArrayList<Medewerker>();
    private List<Klant> klanten = new ArrayList<Klant>();
    private List<Afspraak> afspraken = new ArrayList<Afspraak>();

    public Bedrijf(String naam, String woonplaats, String straatnaam, int nummer, int kvk, int btwNummer) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.nummer = nummer;
        this.kvk = kvk;
        this.btwNummer = btwNummer;
    }

    public void addMedewerker(Medewerker medewerker) {
        medewerkers.add(medewerker);
    }

    public void addKlant(Klant klant) {
        klanten.add(klant);
    }

    public void addAfspraak(Afspraak afspraak) {
        afspraken.add(afspraak);
    }
}
