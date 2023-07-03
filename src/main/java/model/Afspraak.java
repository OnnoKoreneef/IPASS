package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Afspraak {
    private LocalDate datum;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private String woonplaats;
    private String straatnaam;
    private int huisNummer;
    private String onderwerp;
    private String medewerker;

    public Afspraak(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, String woonplaats, String straatnaam, int huisNummer, String onderwerp) {
        this.datum = datum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.onderwerp = onderwerp;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getBeginTijd() {
        return beginTijd;
    }

    public LocalTime getEindTijd() {
        return eindTijd;
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

    public String getOnderwerp() {
        return onderwerp;
    }

    public String getMedewerker() {
        return medewerker;
    }

    public void setMedewerker(Medewerker medewerker) {
        String voornaam = medewerker.getVoornaam();
        String achternaam = medewerker.getAchternaam();
        this.medewerker = voornaam + " " + achternaam;
    }
}
