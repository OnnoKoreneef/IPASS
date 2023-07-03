package model;

import java.util.ArrayList;

public class Medewerker {
    private String voornaam;
    private String achternaam;
    private String emailMedewerker;
    private String telefoonnummer;
    private String functie;
    private ArrayList<Afspraak> afspraken;

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
    
    public ArrayList<Afspraak> getAfspraken() { return afspraken; }
    
    public boolean isBezet(Afspraak nieuwAfspraak) {
        boolean bezet = false;
        for (Afspraak afspraak : afspraken) {
            if (afspraak.getDatum().equals(nieuwAfspraak.getDatum())) {
                if (afspraak.getBeginTijd().isBefore(nieuwAfspraak.getBeginTijd()) && afspraak.getEindTijd().isAfter(nieuwAfspraak.getBeginTijd())) {
                    bezet = true;
                    break;
                } else if (afspraak.getBeginTijd().isAfter(nieuwAfspraak.getBeginTijd()) && afspraak.getEindTijd().isBefore(nieuwAfspraak.getEindTijd())) {
                    bezet = true;
                    break;
                } else if (afspraak.getBeginTijd().isAfter(nieuwAfspraak.getBeginTijd()) && afspraak.getBeginTijd().isBefore(nieuwAfspraak.getEindTijd())) {
                    bezet = true;
                    break;
                }
            } 
        }
        return bezet;
    }
}

