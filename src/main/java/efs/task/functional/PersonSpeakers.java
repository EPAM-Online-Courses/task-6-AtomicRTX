package efs.task.functional;

import java.util.Locale;

class PersonSpeakers {

    private final String HELLO = "Hello. I'm ";
    private final String CZESC = "Czesc. Jestem ";
    private final String HALLO = "Hallo, ich heiBe ";


    Speaker createGreetSpeaker() {
        // Implementacja interfejsu Speaker za pomocą wyrażenia lambda. Implementacja w tej postaci możliwa jest
        // dzięki temu, że Speaker jest interfejsem funkcyjnym - posiada tylko jedną metodę abstrakcyjną.
        return p -> HELLO + p.getName();
    }

    Speaker createShoutingSpeaker() {
        // TODO: stwórz odpowiednią implementację interfejsu Speaker, tak aby wywołanie jego metody say() powodowało
        //  zwrócenie tekstu powitania zapisanego dużymi literami. Na zasadzie:
        //      "HELLO. I'M MARIA.", gdzie Maria to imię danej osoby przekazanej w argumencie metody say().
        //  Wywołanie metody say() interfejsu odbywa się w testach metody.
        //  Aby być pewnym, że użyta jest prawidłowa pisownia zaleca się użycie odpowiedniej stałej.
        String HELLO_UP = HELLO.toUpperCase();
        Speaker temp = (Person p) -> HELLO_UP + p.getName().toUpperCase();
        return temp;
    }

    Speaker createGreetLocalSpeaker() {
        // TODO: stwórz odpowiednią implementację interfejsu Speaker, tak aby wywołanie jego metody say() powodowało
        //  zwrócenie tekstu powitania w odpowiednim języku. Przykładowo dla języka angielskiego:
        //       "Hello. I'm Antonina.", gdzie Antonina to imię danej osoby przekazanej w argumencie metody say().
        //  Wywołanie metody say() interfejsu odbywa się w testach metody.
        //  Aby być pewnym, że użyta jest prawidłowa pisownia zaleca się użycie odpowiednich stałych.

        Speaker temp = (Person p) -> {
            if (p.getCountryOfLiving().equals(Country.USA)) {
                return HELLO + p.getName();
            }
            else if (p.getCountryOfLiving().equals(Country.PL)) {
                return CZESC + p.getName();
            }
            else {
                return HALLO + p.getName();
            }
        };
        return temp;
    }
}
