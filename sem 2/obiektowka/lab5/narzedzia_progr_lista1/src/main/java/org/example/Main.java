package org.example;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import java.io.File;
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
        } catch (ConfigurationException cex) {
            System.err.println("Błąd przy wczyttwaniu pliku konfiguracyjnego");
            cex.printStackTrace(); //wypisuje FileNotFoundExeption
        }
    }
}
