package org.example;

public class DaneZamawiajacego {
    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;

    public DaneZamawiajacego() {} //Jackson wymaga pusty konstuktor......

    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
