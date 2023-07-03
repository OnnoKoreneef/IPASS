package model;

import java.util.ArrayList;

public class Klant {
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String woonplaats;
    private String straatnaam;
    private int huisNummer;
    private String telefoonnummer;
    private ArrayList<Afspraak> afspraken = new ArrayList<Afspraak>();
    private ArrayList<Offerte> offertes = new ArrayList<>();


    public Klant(String voornaam, String achternaam, String email, String wachtwoord, String woonplaats, String straatnaam, int huisNummer, String telefoonnummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public int getHuisNummer() {
        return huisNummer;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public ArrayList<Afspraak> getAfspraken() { return afspraken; }

    public ArrayList<Offerte> getOffertes() { return offertes; }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setWoonplaats(String woonplaats) { this.woonplaats = woonplaats; }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public void setHuisNummer(int huisNummer) {
        this.huisNummer = huisNummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void addAfspraak(Afspraak afspraak) {
        afspraken.add(afspraak);
    }
    public void addOfferte(Offerte offerte) { offertes.add(offerte); }

}
