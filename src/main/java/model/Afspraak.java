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
    private Medewerker medewerker;

    public Afspraak(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, String woonplaats, String straatnaam, int huisNummer, String onderwerp, Medewerker medewerker) {
        this.datum = datum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.onderwerp = onderwerp;
        this.medewerker = medewerker;
    }
}
