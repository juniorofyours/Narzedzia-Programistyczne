package org.example;
//przy użyciu klasy ObjectMapper z biblioteki Jackson moge deserializowac z pliku .json.

public class Produkt {
    private String kodProduktu;
    private double zamawianaIlosc;
    private String jednostkaMiary;

    public Produkt() {} //Jackson wymaga pusty konstuktor......

    public String getKodProduktu(){
        return kodProduktu;
    }
    public void setKodProduktu(String kodWczytany) {
        this.kodProduktu = kodWczytany;
    }
    public double getZamawianaIlosc(){
        return zamawianaIlosc;
    }
    public void setZamawianaIlosc(double ilosc) {
        this.zamawianaIlosc = ilosc;
    }
    public String getJednostkaMiary(){
        return jednostkaMiary;
    }
    public void setJednostkaMiary(String jednostka) {
        this.jednostkaMiary = jednostka;
    }
}
