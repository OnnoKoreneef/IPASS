package model;

import java.time.LocalDate;

public class Offerte {
    private String onderwerp;
    private int bedrag;
    private int nummer;
    private LocalDate datum;
    private LocalDate geldigheid;
    private String omschrijving;
    private String klantType;
    private String onderdeel;


    public Offerte(String onderwerp, int nummer, LocalDate datum, LocalDate geldigheid, String omschrijving, String klantType, String onderdeel) {
        this.onderwerp = onderwerp;
        this.nummer = nummer;
        this.datum = datum;
        this.geldigheid = geldigheid;
        this.omschrijving = omschrijving;
        this.klantType = klantType;
        this.onderdeel = onderdeel;
    }

    public Offerte(String onderwerp, int bedrag, int nummer, LocalDate datum, LocalDate geldigheid, String omschrijving, String klantType, String onderdeel) {
        this(onderwerp, nummer, datum, geldigheid, omschrijving, klantType, onderdeel);
        this.bedrag = bedrag;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public int getBedrag() {
        return bedrag;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalDate getGeldigheid() {
        return geldigheid;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlantType() {
        return klantType;
    }

    public String getOnderdeel() {
        return onderdeel;
    }
}
