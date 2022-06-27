package com.example.marathon;

public class Teilnehmer {

    private String vorname;
    private String nachname;
    private String anrede;
    private String wettbewerb;
    private double laufzeit;

    public Teilnehmer(String vorname, String nachname, String anrede, String wettbewerb, double laufzeit) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.anrede = anrede;
        this.wettbewerb = wettbewerb;
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {

        return anrede + " " + vorname + " " + nachname + " " + wettbewerb + " " + laufzeit + " (mm:ss)";
    }
}
