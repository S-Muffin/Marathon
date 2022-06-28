package com.example.marathon;

public class Teilnehmer implements Comparable<Teilnehmer> {

    private String vorname;
    private String nachname;
    private String anrede;
    private String wettbewerb;
    private Double laufzeit;

    public Teilnehmer(String anrede, String vorname, String nachname, String wettbewerb, Double zeit) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.anrede = anrede;
        this.wettbewerb = wettbewerb;
        this.laufzeit = zeit;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getWettbewerb() {
        return wettbewerb;
    }

    public void setWettbewerb(String wettbewerb) {
        this.wettbewerb = wettbewerb;
    }

    public double getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(double laufzeit) {
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {

        return anrede + " " + vorname + " " + nachname + " " + wettbewerb + " " + laufzeit + " (mm:ss)";
    }

    @Override
    public int compareTo(Teilnehmer teilnehmer) {

        return this.laufzeit.compareTo(teilnehmer.getLaufzeit());
    }
}
