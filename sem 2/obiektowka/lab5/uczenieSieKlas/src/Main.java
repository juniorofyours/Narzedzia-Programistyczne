


public static void main(String[] args) {
    //konstruktory +
    //zmienne statyczne
    //kompozycja/agregacja +
    //hermetyzacja +
    //dziedziczenie
    //interfejsy
    //konstruktory klas potomnych



    //Metody w roznych klasach
    //metode z jednej klasy mozna wywolaj w innej w nastepujacych przypadkach:

    //1
    //Jezeli metoda jest static, to wywyoluje sie ja po nazwie klasy, np:
    // NazwaKlasy.nazwaMetody();
    //jezeli metoda nie jest static i jest np w klasie Main, to nie da sie jej dac do metody static void main()
    // bo wymaga static metody -- to taki fun fact (wiec lepiej robic wtedy konstruktor i dzieki niemu dawac metody
    // do maina, chyba, nwm)

    //2
    //Jezeli metoda instancyjna (zwykla) , to wymaga utworzenia obiektu (a.k.a. instancji) klasy przed jej wywolaniem
    // NazwaKlasy nazwaObiektu = new NazwaKlasy();
    // nazwaObiektu.nazwaMetody();

    //3
    //Jezeli wystepuje dziedziczenie [... extends ...] (np. public class PracownikIT extends Pracownik {...}),
    // to klasa potomna dziedziczy metody klasy nadrzednej i wywyoluje je tak, niby w niej byly zdefiniowane

    //WAZNE: jezeli jest private, to wiadomo, ze sie nie da uzyc metody
    //protected - jest tylko dla klas dziedziczacych (potomnych)

    //np.:
    /* wewnatrz klasy public class PracownikIT extends Pracownik {} sa metody
    * protected double Premia() {...}
    * public double PensjaPoPodatku() {...}
    * to w klasie potomnej public class Programista extends PracownikIt jest ta sama metoda protected oraz:
    * @Override //nadpisywanie metody
    * public double PensjaPoPodatku() {...}
    */

    //Zmienne w roznych klasach
    //W opodobny sposob dzialaja zmienne;
    // zmienne statyczne mozna zmieniac wewnatrz innych klas piszac NazwaKlasy.zmiennaStatyczna = ...;
    // zmienne instancyjne (zalezne od obiektow) po utworzeniu obiektu mozna zmieniac w nastepujacy sposob:
    // nazwaObiektu.nazwaZmiennej = ...;
    // jezeli przed typem zmiennej nie piszemy public/protected/priavte to domyslne mozna je uzyc
    // w tym samym pakiecie (tzn. folerze, w ktorym ta klasy jest; czyli klasy w tym folderze moga uzywac tej zmiennej)
    // tez mozna zapisac to na poczatku pliku .java jako   package pl.programista.sklep    (np)

    //publi/protected/private tak samo dzialaja

    //Hermetyzacja
    //Wyzej wspomniane private tworzy pole prywatne potrzebne do hermetyzacji, np. (klasa KontoBankowe)
    KontoBankowe czyjesKonto = new KontoBankowe(90.05);
    System.out.println("Na koncie jest " + czyjesKonto.getSaldo() + " zl.");
    czyjesKonto.wplac(10.95); //zwiekszylismy saldo
    System.out.println("Na koncie jest " + czyjesKonto.getSaldo() + " zl.");


    //Agregacja
    // jedna z relacji calosc-czesc

    //czesci moga istniec niezaleznie od calosci
    //czyli usuniecie obiektu nadrzednego (calosci) nie spowoduje usuniecia obiektow podrzednych (czesci)

    //Relacja "posiada" odpowiada pytaniu "ma"
    // taki przyklad: Szkola ma Nauczycieli, Firma ma Dzialy, Biblioteka ma Ksiazki

    //np mozna w main zrobic obiekt z klasy, ktora bedzie miala agregacje z glona klasa

    //Kompozycja
    // jedna z relacji calosc-czesc
    //(bywa dobra alternatywa do klas dziedziczenia)

    //czesci sa scisle poiazane z caloscia
    //czyli jesli obiekt glowny jest niszczony, to rowniez sa niszczone czesci wewnetrzne
    // (CO CIEKAWE NIE ZAWSZE TAK JEST)

    //Przyklad relacji: Dom i Pokoj (bez Domu nie ma Pokoju)

    //np mozna zrobic konstruktor w jednej klasie, w ktorym z jednych paramatrow bedzie obiekt z innej klasy
    //np. w klasie Product zrobic konstruktor, gdzie jednym z parametrow bedzie obiekt z klasy Date
    //wtedy klasa Date staje sie zalezna od Product (chociaz brzmi na odwrot, ale chyba to tak dziala...)


    //PRZYKLAD uzycia obu rzeczy naraz: np. klasa Product moze istniec bez klasy Shop (agregacja), ale
    //klasa Date nie moze istniec bez klasy Product (bo jest klasa definijaca daty powiazane z TYM produktem)
    //(to drugie to jest kompozycja)


    //Konstruktory

    // w teorii podobne sa do prototypow w jezyku C, gdzie mozna stworzyc kilka roznych funkcji
    // ktore maja po prostu rozne parametry, ale nazwe moga miec ta sama np int func() {...} i int func(int numb) {...}

    //zazwyczaj sa wyrozniane trzy rodzaje konstruktorow (klasa Konstruktory)
    //domyslny konstruktor:
    Konstruktory defaultOne = new Konstruktory();
    //z parametrami konstruktor:
    Konstruktory parametricOne = new Konstruktory("Byczek", 10, 12.2005);
    //kopiujacy konstruktor
    Konstruktory copyOne = new Konstruktory(parametricOne);






}
