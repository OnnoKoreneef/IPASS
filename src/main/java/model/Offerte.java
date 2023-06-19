package model;

import java.time.LocalDate;

public class Offerte {
    private String onderwerp;
    private int bedrag;
    private int nummer;
    private LocalDate datum;
    private String geldigheid;
    private String omschrijving;

    public Offerte(String onderwerp, int bedrag, int nummer, LocalDate datum, String geldigheid, String omschrijving) {
        this.onderwerp = onderwerp;
        this.bedrag = bedrag;
        this.nummer = nummer;
        this.datum = datum;
        this.geldigheid = geldigheid;
        this.omschrijving = omschrijving;
    }
}
