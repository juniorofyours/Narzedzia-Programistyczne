package org.example;
//przy użyciu klasy ObjectMapper z biblioteki Jackson moge deserializowac z pliku .json.

public class Produkty {
    private String kodProduktu;
    private double zamawianaIlosc;
    private String jednostkaMiary;

    public Produkty() {} //Jackson wymaga pusty konstuktor......

    public String getKodProduktu(){
        return kodProduktu;
    }
    public void setKodProduktu(String kodProduktu) {
        this.kodProduktu = kodProduktu;
    }
    public double getZamawianaIlosc(){
        return zamawianaIlosc;
    }
    public void setZamawianaIlosc(double zamawianaIlosc) {
        this.zamawianaIlosc = zamawianaIlosc;
    }
    public String getJednostkaMiary(){
        return jednostkaMiary;
    }
    public void setJednostkaMiary(String jednostkaMiary) {
        this.jednostkaMiary = jednostkaMiary;
    }
}
