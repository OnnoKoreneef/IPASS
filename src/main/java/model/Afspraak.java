package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Afspraak {
    private LocalDate datum;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private String adres;
    private String onderwerp;

    public Afspraak(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, String adres, String onderwerp) {
        this.datum = datum;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.adres = adres;
        this.onderwerp = onderwerp;
    }
}
