# OOP_Project
<h4>
Project for college , OOP. </br>
Made by : Kornel Uriasz , Mikołaj Paterek. </br>
Subject : Agent Simulation of : bums. </br>
PWR W4N ITE 2022/2027. </br>
</h4>
<h3>
Dzień dobry

    Preferowane jest użycie interfejsów zamiast implementacji w typowaniu zmiennych (Map<,> map = new HashMap<>())
    nazwa MapArray sugeruje to, co kryje się pod implementacją. Klienta (kodu, który używa klasę) to nie interesuje
    FieldTypeParser można zastąpić wbudowaną metodą FieldType.valueOf()
    metoda parseJsonFile jest za duża - można podzielić ją na mniejsze. Nie ma nic złego w tworzeniu prywatnych metod użytych tylko raz
    podział pakietów nie ma sensu. Zazwyczaj dzielimy pakiety na funkcjonalności lub warstwy, takie jak aplikacja, infrastruktura i domena. W tym przypadku jednym pakietem może być logika i obiekty symulacji, innym aplikacja, a jeszcze innym interfejs graficzny
    RandomEvent implementuje Random, ale sam Random nie jest nigdzie używany
    Ocenie będzie podlegała najbardziej logika symulacji, a w tym momencie ciężko mi jest ją znaleźć
    klasa Bum jest używana tylko do rozszerzenia klasy MainBum. Dlaczego więc jej nie wyeliminować i nie umieścić tych pól w klasie MainBum?
    Kod nie ma spójnego formatowania i niektóre klasy zaczynają się z małych liter
    Pliki json powinny być w standardowym katalogu resources
    asercja assertTrue(true) w testach nie ma sensu. Sprawdzamy dane zachowanie i to, czy metody zwracają oczekiwane obiekty

    Pozdrawiam
