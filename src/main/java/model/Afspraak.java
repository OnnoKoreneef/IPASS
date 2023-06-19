package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Afspraak {
    private LocalDate datum;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private String woonplaats;
    private String straatnaam;
    private int nummer;
    private String onderwerp;

    private Medewerker medewerker;
    private Klant klant;

    public Afspraak(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, String woonplaats, String straatnaam, int nummer, String onderwerp, Medewerker medewerker, Klant klant) {
        this.datum = datum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.woonplaats = woonplaats;
        this.straatnaam = straatnaam;
        this.nummer = nummer;
        this.onderwerp = onderwerp;
        this.medewerker = medewerker;
        this.klant = klant;
    }
}
