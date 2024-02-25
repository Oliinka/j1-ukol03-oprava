package cz.czechitas.ukol3.model;

public class Pocitac {

    public boolean jeZapnuty = false;
    public boolean procesor = false;
    public boolean pamet = false;
    public boolean disk = false;

    public Disk pevnyDisk;

    public Pocitac() {
        this.pevnyDisk = new Disk();
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public void isJeZapnuty() {
        if (jeZapnuty) {
            System.out.println("Pocitac je zapnuty.");
        } else {
            System.out.println("Pocitac je vypnuty...");
        }
    }

    public void vypniSe() {
        if (jeZapnuty) {
            System.out.println("Pocitac se vypina...");
            jeZapnuty = false;
        } else {
            System.err.println("...");
        }
    }

    public void zjistiExistenciProcesoru() {
        try {
            Class.forName("cz.czechitas.ukol3.model.Procesor");
            procesor = true;
        } catch (ClassNotFoundException exception) {
            System.err.println("Pocitac nema procesor.");
        }
    }

    public void zjistiExistenciPameti() {
        try {
            Class.forName("cz.czechitas.ukol3.model.Pamet");
            pamet = true;
        } catch (ClassNotFoundException exception) {
            System.err.println("Pocitac nema pamet.");
        }
    }

    public void zjistiExistenciDisku() {
        try {
            Class.forName("cz.czechitas.ukol3.model.Disk");
            disk = true;
        } catch (ClassNotFoundException exception) {
            System.err.println("Pocitac nema hard disk.");
        }
    }

    public void zapniSe() {
        zjistiExistenciDisku();
        zjistiExistenciPameti();
        zjistiExistenciProcesoru();

        if (jeZapnuty) {
            System.err.println("Pocitac je jiz zapnuty");
        } else if (disk && pamet && procesor) {
            jeZapnuty = true;
            System.out.println("Pocitac se zapnul.");
        } else {
            System.err.println("Pocitac nema potrebne komponenty.");
        }
    }

    public void vytvorSouborOvelikosti(long velikostSouboru) {
        long vyuzitelneMisto = pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto();
        if ((velikostSouboru < vyuzitelneMisto)&&(0<velikostSouboru)) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() - velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl ulozeny na disk." + "Vyuzitelna kapacita disku je pouze " + pevnyDisk.getKapacita()+ " bajtů.");
        }
        else {
            System.out.println("Soubor nelze ulozit. Byla prekrocena kapacita disku. Zbyvajici kapacita disku je pouze " + pevnyDisk.getKapacita()+ " bajtů.");
        }
    }


    public void vymazSouborOvelikosti(long velikostSouboru) {
        if (velikostSouboru <= pevnyDisk.getVyuziteMisto()) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() + velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl smazany z disku." + "Vyuztelna kapacita disku je " + pevnyDisk.getKapacita() + " bajtů.");
        }
        else {
            System.out.println("Soubor o velikosti " + velikostSouboru + " je vetsi, nez vyuzite misto disku. Vyuzitelna kapacita disku je " + pevnyDisk.getVyuziteMisto() + " bajtů.");
        }
    }

}