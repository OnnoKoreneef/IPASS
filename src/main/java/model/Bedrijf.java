package model;

import java.util.ArrayList;

public class Bedrijf {
    private String naam;
    private String woonplaats;
    private String straatnaam;
    private int nummer;
    private int kvk;
    private int btwNummer;
    private ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
    private ArrayList<Klant> klanten = new ArrayList<Klant>();
    private ArrayList<Offerte> offertes = new ArrayList<>();

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
    public void addOfferte(Offerte offerte) {
        offertes.add(offerte);
    }

    public static Klant getKlant(ArrayList<Klant> klanten , String email) {
        for (Klant klant: klanten) {
            if (klant.getEmail().equals(email)) {
                return klant;
            }
        }
        return null ;
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public ArrayList<Klant> getKlanten() {
        return klanten;
    }

    public ArrayList<Offerte> getOffertes() {
        return offertes;
    }
}
