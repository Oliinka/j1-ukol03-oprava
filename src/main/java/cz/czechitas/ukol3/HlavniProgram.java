package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Pocitac;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");

        Pocitac mujPocitac = new Pocitac();
        mujPocitac.jeZapnuty= false;
        mujPocitac.isJeZapnuty();

        mujPocitac.jeZapnuty= true;
        mujPocitac.isJeZapnuty();

        mujPocitac.vypniSe();
        mujPocitac.vypniSe();

        mujPocitac.zapniSe();

    }

}
