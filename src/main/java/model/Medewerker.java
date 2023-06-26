package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medewerker {
    private String voornaam;
    private String achternaam;
    private String emailMedewerker;
    private String telefoonnummer;
    private String functie;

    public Medewerker(String voornaam, String achternaam, String emailMedewerker, String telefoonnummer, String functie) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.emailMedewerker = emailMedewerker;
        this.telefoonnummer = telefoonnummer;
        this.functie = functie;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }
}

