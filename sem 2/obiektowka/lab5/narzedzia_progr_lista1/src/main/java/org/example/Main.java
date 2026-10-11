package org.example;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import java.io.File;
import java.io.FilenameFilter;
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
                    System.out.println("Pliki .json:");

                    for(File file: jsonFiles) {
                        System.out.println(file.getName());
                    }
                }
                else {
                    System.out.println("Brak plików .json");
                }
            }


        } catch (ConfigurationException cex) {
            System.err.println("Błąd przy wczyttwaniu pliku konfiguracyjnego");
            cex.printStackTrace(); //wypisuje FileNotFoundExeption
        }
    }
}
