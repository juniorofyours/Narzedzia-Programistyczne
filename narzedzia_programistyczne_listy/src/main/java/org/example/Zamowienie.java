package org.example;
import java.util.List;

public class Zamowienie {
    private DaneZamawiajacego daneZamawiajacego;
    private List<Produkty> produkty;

    public Zamowienie() {}

    public DaneZamawiajacego getDaneZamawiajacego() {
        return daneZamawiajacego;
    }
    public void setDaneZamawiajacego(DaneZamawiajacego daneZamawiajacego) {
        this.daneZamawiajacego = daneZamawiajacego;
    }

    public List<Produkty> getProdukty() {
        return produkty;
    }
    public void setProdukty(List<Produkty> produkty) {
        this.produkty = produkty;
    }

    public int numerZamowieniaMetoda() {
        if (daneZamawiajacego == null) return 0;
        int kod = getDaneZamawiajacego().getImie().length() + getDaneZamawiajacego().getNazwisko().charAt(0)*100+getDaneZamawiajacego().getEmail().length()*10;
        return kod;
    }
}
