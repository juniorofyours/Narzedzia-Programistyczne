package org.example;
import java.util.List;

public class Zamowienie {
    private DaneZamawiajacego dane;
    private List<Produkt> produkty;

    public Zamowienie() {}

    public DaneZamawiajacego getDaneZamawiajacego() {
        return dane;
    }
    public void setDaneZamawiajacego(DaneZamawiajacego dane) {
        this.dane = dane;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }
    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public int numerZamowieniaMetoda() {
        if (dane == null) return 0;
        int kod = getDaneZamawiajacego().getImie().length() + getDaneZamawiajacego().getNazwisko().charAt(0)*100+getDaneZamawiajacego().getEmail().length()*10;
        return kod;
    }
}
