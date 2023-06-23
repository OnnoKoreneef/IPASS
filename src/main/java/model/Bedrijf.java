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
    private ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
    private ArrayList<Klant> klanten = new ArrayList<Klant>();
    private ArrayList<Afspraak> afspraken = new ArrayList<Afspraak>();

    public Bedrijf(String naam, String woonplaats, String straatnaam, int nummer, int kvk, int btwNummer) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.nummer = nummer;
        this.kvk = kvk;
        this.btwNummer = btwNummer;
    }

    public Bedrijf getBedrijf() {
        return this;
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

    public static Klant getKlant(ArrayList<Klant> klanten , String email) {
        for (Klant klant: klanten) {
            if (klant.getEmail().equals(email)) {
                return klant;
            }
        }
        return null ;
    }

    public ArrayList<Klant> getKlanten() {
        return klanten;
    }

    public void createKlant(String voornaam, String achternaam, String email, String wachtwoord, String woonplaats, String straatnaam, int huisnummer, String telefoonnummer){
        Klant klant = new Klant(voornaam, achternaam, email, wachtwoord, woonplaats, straatnaam, huisnummer, telefoonnummer);
        klanten.add(klant);
    }
}
