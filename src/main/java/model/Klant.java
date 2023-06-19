package model;

public class Klant {
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String woonplaats;
    private String straatnaam;
    private int nummer;
    private String telefoonnummer;

    public Klant(String voornaam, String achternaam, String email, String wachtwoord, String woonplaats, String straatnaam, int nummer, String telefoonnummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.nummer = nummer;
        this.telefoonnummer = telefoonnummer;
    }
}
