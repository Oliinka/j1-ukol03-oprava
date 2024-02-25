package cz.czechitas.ukol3.model;

public class Pocitac {

    public boolean jeZapnuty = false;
    public boolean procesor = false;
    public boolean pamet = false;
    public boolean disk = false;
    public Disk pevnyDisk;
    public Procesor cpu;
    public Pamet ram;

    public Pocitac() {
        this.pevnyDisk = new Disk();
        this.cpu = new Procesor();
        this.ram = new Pamet();
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
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
            System.out.println("...");
        }
    }

    public void zjistiExistenciProcesoru() {
        if (cpu != null){
            procesor = true;
        }
        else {
            System.err.println("Pocitac nema procesor.");
        }
    }

    public void zjistiExistenciPameti() {
        if (ram != null){
            pamet = true;
        }
        else {
            System.out.println("Pocitac nema pamet.");
        }
    }

    public void zjistiExistenciDisku() {
        if (pevnyDisk!= null){
            disk = true;
        } else {
            System.out.println("Pocitac nema hard disk.");
        }
    }

    public void zapniSe() {
        if (cpu == null || ram == null || pevnyDisk == null) {
            System.out.println("Pocitac nelze zapnout, nema potrebne komponenty.");
            return;
        } else if (jeZapnuty) {
            System.out.println("Pocitac je jiz zapnuty");
        } else {
            System.out.println("Pocitac se zapnul.");
            jeZapnuty = true;
        }
    }

    public void vytvorSouborOvelikosti(long velikostSouboru) {
        long vyuzitelneMisto = pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto();
        if ((velikostSouboru < vyuzitelneMisto) && (0 < velikostSouboru)) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() - velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl ulozeny na disk." + "Vyuzitelna kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        } else {
            System.out.println("Soubor nelze ulozit. Byla prekrocena kapacita disku. Zbyvajici kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        }
    }


    public void vymazSouborOvelikosti(long velikostSouboru) {
        if (velikostSouboru <= pevnyDisk.getVyuziteMisto()) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() + velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl smazany z disku." + "Vyuztelna kapacita disku je " + pevnyDisk.getKapacita() + " bajtů.");
        } else {
            System.out.println("Soubor o velikosti " + velikostSouboru + " je vetsi, nez vyuzite misto disku. Vyuzitelna kapacita disku je " + pevnyDisk.getVyuziteMisto() + " bajtů.");
        }
    }


    @Override
    public String toString() {
        return "Informace o pocitaci:\n" +
                "Informace o procesoru:\n" + cpu.toString() + "\n" +
                "Informace o pameti RAM:\n" + ram.toString() + "\n" +
                "Informace o hard disku:\n" + pevnyDisk.toString();
    }

}