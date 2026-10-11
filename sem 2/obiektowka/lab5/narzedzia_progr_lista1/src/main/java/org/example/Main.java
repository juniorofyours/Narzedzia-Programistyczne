package org.example;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import java.io.File;
import java.io.FilenameFilter;
import tools.jackson.databind.ObjectMapper;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configurations configs = new Configurations();

        //configi pozwalają na łątwą zmianę środowiska, np między środowiskiem lokalnym a produkcyjnym.
        try {
            Configuration config = configs.properties(new File("src/main/resources/appsettings.properties"));
            //zapisany klucz jako string:
            String path = config.getString("zamowienia");
            System.out.println("Ścieżka do orderRequest: " + path);

            File katalog = new File(path);
            if(katalog.exists() && katalog.isDirectory()) {
                //filtr przepuszczająy pliki json
                FilenameFilter filtr = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".json");
                    } // https://zetcode.com/java/io-filenamefilter/
                };

                File[] jsonFiles = katalog.listFiles(filtr);
                if(jsonFiles != null && jsonFiles.length > 0) {
                    System.out.println("Pliki .json (zadanie 4. bez deserializacji):");

                    for(File file: jsonFiles) {
                        System.out.println(file.getName());
                    }

                    System.out.println("Pliki .json (zadanie 5. z deserializacja):");

                    ObjectMapper mapper = new ObjectMapper();

                    for (File file : jsonFiles) {
                        try {
                            Zamowienie zamowienie = mapper.readValue(file, Zamowienie.class);

                            int liczbaProduktow = zamowienie.getProdukty().size();
                            int numerZamowienia = zamowienie.numerZamowieniaMetoda();

                            //odp.:
                            System.out.println("\nNazwa pliku: " + file.getName() + "\n");
                            System.out.println("Zamiawajacy: " + zamowienie.getDaneZamawiajacego().getImie() + " " +
                                    zamowienie.getDaneZamawiajacego().getNazwisko());
                            System.out.println("Produkty (" + liczbaProduktow + "):\n " + zamowienie.getProdukty());
                            System.out.println("Numer żądania złożenia zamówienia: NR" + numerZamowienia);

                        } catch (Exception e) {
                            System.err.println("Błąd podczas przetwarzania pliku " + file.getName() + ": " + e.getMessage());
                        }
                    }
                }
                else {
                    System.out.println("Brak plików .json");
                }
            }
            else {
                System.err.println("Dana ścieżka nie istnieje albo nie jest ktalogiem");
            }

        } catch (ConfigurationException cex) {
            System.err.println("Błąd przy wczyttwaniu pliku konfiguracyjnego");
            cex.printStackTrace(); //wypisuje FileNotFoundExeption
        }
    }
}
