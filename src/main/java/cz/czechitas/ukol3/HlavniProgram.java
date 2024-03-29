package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        System.out.println("Program spuštěn.");

        Pocitac mujPocitac = new Pocitac();
        System.out.println("Info o hodnote jeZapnuty() " + mujPocitac.isJeZapnuty());

        System.out.println("------------------------------------------------------");
        mujPocitac.zapniSe();
        System.out.println("------------------------------------------------------");


        System.out.println(mujPocitac.toString());

        Disk mujDisk = new Disk();
        mujDisk.setKapacita(994_662_584_320L);
        mujPocitac.setPevnyDisk(mujDisk);

        Pamet mojePamet = new Pamet();
        mojePamet.setKapacita(24_000_000_000L);
        mujPocitac.setRam(mojePamet);

        Procesor mujProcesor = new Procesor();
        mujProcesor.setRychlost(3_490_000_000L);
        mujProcesor.setVyrobce("Apple");
        mujPocitac.setCpu(mujProcesor);

        System.out.println("------------------------------------------------------");
        mujPocitac.zapniSe();
        System.out.println("------------------------------------------------------");


        System.out.println(mujPocitac.toString());

        mujPocitac.zapniSe();
        System.out.println("------------------------------------------------------");

        mujPocitac.vytvorSouborOvelikosti(662_584_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");

        System.out.println("------------------------------------------------------");

        mujPocitac.vytvorSouborOvelikosti(4_000_000_000L);
        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");

        System.out.println("------------------------------------------------------");
        mujPocitac.vytvorSouborOvelikosti(994_000_000_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");

        System.out.println("------------------------------------------------------");
        mujPocitac.vymazSouborOvelikosti(4_000_000_000L);

        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");
        System.out.println("------------------------------------------------------");
        mujPocitac.vymazSouborOvelikosti(1_994_000_000_000L);
        System.out.println("KONTROLA --> Aktualni vyuzite misto je: " + mujDisk.getVyuziteMisto() + "bajtu.");
        System.out.println("------------------------------------------------------");
        mujPocitac.vypniSe();

        mujPocitac.vymazSouborOvelikosti(100L);
        mujPocitac.vytvorSouborOvelikosti(200L);

    }

}
