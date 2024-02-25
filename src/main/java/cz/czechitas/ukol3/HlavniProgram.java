package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
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

        Disk mujDisk = new Disk();
        mujDisk.setKapacita(994_662_584_320L);

        mujPocitac.setPevnyDisk(mujDisk);
        mujPocitac.vytvorSouborOvelikosti(662_584_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");


        mujPocitac.vytvorSouborOvelikosti(4_000_000_000L);
        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");


        mujPocitac.vytvorSouborOvelikosti(994_000_000_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");


        mujPocitac.vymazSouborOvelikosti(4_000_000_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");

        mujPocitac.vymazSouborOvelikosti(1_994_000_000_000L);
        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");




    }

}
