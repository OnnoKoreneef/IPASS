package model;

public class Medewerker {
    private String voornaam;
    private String achternaam;
    private String email;
    private String telefoonnummer;
    private String functie;

    public Medewerker(String voornaam, String achternaam, String email, String telefoonnummer, String functie) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.functie = functie;
    }
}
