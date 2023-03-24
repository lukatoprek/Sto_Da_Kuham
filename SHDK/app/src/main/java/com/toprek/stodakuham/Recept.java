package com.toprek.stodakuham;

public class Recept
{
    public String ime;
    public int slika;
    public String opis;
    public Boolean zahtjevnost;
    public int recept;
    public String kategorija;


    public Recept(String ime, String opis, Boolean zahtjevnost, int recept, int slika, String kategorija) {
        this.ime = ime;
        this.opis = opis;
        this.zahtjevnost = zahtjevnost;
        this.recept = recept;
        this.slika = slika;
        this.kategorija = kategorija;
    }
}




