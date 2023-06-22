package model;

public class Klant {
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String woonplaats;
    private String straatnaam;
    private int huisnummer;
    private String telefoonnummer;

    public Klant(String voornaam, String achternaam, String email, String wachtwoord, String woonplaats, String straatnaam, int huisnummer, String telefoonnummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }
}
