package cz.czechitas.ukol3.model;

public class Pocitac {

    private boolean jeZapnuty;

    private Disk pevnyDisk;
    private Procesor cpu;
    private Pamet ram;

    public Pocitac() {
        this.jeZapnuty = false;

    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public void isJeZapnuty() {
        if (jeZapnuty) {
            System.out.println("Pocitac je zapnuty.");
        } else {
            System.err.println("Pocitac je vypnuty...");
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

    public void zapniSe() {

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Pocitac nelze zapnout, nema potrebne komponenty.");
            return;
        }

        if (jeZapnuty) {
            System.err.println("Pocitac je jiz zapnuty");
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
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl ulozeny na disk.\n" + "Vyuzitelna kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        } else {
            System.out.println("Soubor nelze ulozit. Byla prekrocena kapacita disku.\n Zbyvajici kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        }
    }


    public void vymazSouborOvelikosti(long velikostSouboru) {
        if (velikostSouboru <= pevnyDisk.getVyuziteMisto()) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() + velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtu byl smazany z disku.\n" + "Vyuztelna kapacita disku je " + pevnyDisk.getKapacita() + " bajtů.");
        } else {
            System.out.println("Soubor o velikosti " + velikostSouboru + " je vetsi, nez vyuzite misto disku.\n Vyuzitelna kapacita disku je " + pevnyDisk.getVyuziteMisto() + " bajtů.");
        }
    }


    @Override
    public String toString() {
        String result = "Informace o pocitaci:\n";

        // Informace o procesoru
        if (cpu != null) {
            result += "Informace o procesoru:\n" + cpu.toString() + "\n";
        } else {
            result += "Procesor není nastaven.\n";
        }

        // Informace o paměti RAM
        if (ram != null) {
            result += "Informace o pameti RAM:\n" + ram.toString() + "\n";
        } else {
            result += "RAM není nastavena.\n";
        }

        // Informace o pevném disku
        if (pevnyDisk != null) {
            result += "Informace o hard disku:\n" + pevnyDisk.toString();
        } else {
            result += "Pevný disk není nastaven.";
        }

        return result;
    }

}