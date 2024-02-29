package cz.czechitas.ukol3.model;

public class Pocitac {

    private boolean jeZapnuty;

    private Disk pevnyDisk = null;
    private Procesor cpu = null;
    private Pamet ram = null;

    public boolean isJeZapnuty() {
        return jeZapnuty;
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

    public void vypniSe() {
        if (jeZapnuty) {
            System.out.println("Pocitac se vypina...");
            jeZapnuty = false;
        } else {
            System.err.println("...");
        }
    }

    public void zjistiExistenciProcesoru() {
        if (cpu == null) {
            System.err.println("Pocitac nema procesor.");
        }
    }

    public void zjistiExistenciPameti() {
        if (ram == null) {
            System.err.println("Pocitac nema pamet.");
        }
    }

    public void zjistiExistenciDisku() {
        if (pevnyDisk == null) {
            System.err.println("Pocitac nema hard disk.");
        }
    }

    public void zapniSe() {
        zjistiExistenciProcesoru();
        zjistiExistenciPameti();
        zjistiExistenciDisku();

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Pocitac nelze zapnout, nema potrebne komponenty.");
            return;
        } else if (jeZapnuty) {
            System.err.println("Pocitac je jiz zapnuty");
        } else {
            System.out.println("Pocitac se zapnul.");
            jeZapnuty = true;
        }
    }

    public void vytvorSouborOvelikosti(long velikostSouboru) {
        long vyuzitelneMisto = pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto();
        if (!jeZapnuty) {
            System.err.println("Počítač není zapnutý a nelze uložit soubor.");
        } else if ((velikostSouboru < vyuzitelneMisto) && (0 < velikostSouboru)) {
            pevnyDisk.setKapacita(pevnyDisk.getKapacita() - velikostSouboru);
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtů byl uložen na disk.\n" +
                    "Vyuzitelna kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        } else {
            System.err.println("Soubor nelze uložit. Byla překročena kapacita disku.\n" +
                    "Zbyvajici kapacita disku je pouze " + pevnyDisk.getKapacita() + " bajtů.");
        }
    }

    public void vymazSouborOvelikosti(long velikostSouboru) {
        if (jeZapnuty && pevnyDisk != null && pevnyDisk.getVyuziteMisto() - velikostSouboru >= 0) {
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikostSouboru);
            System.out.println("Soubor o velikosti " + velikostSouboru + " bajtů byl smazán z disku.\n" +
                    "Vyuzitelna kapacita disku je " + pevnyDisk.getKapacita() + " bajtů.");
        } else if (!jeZapnuty) {
            System.err.println("Počítač není zapnutý a nelze smazat soubor.");
        } else {
            System.err.println("Soubor o velikosti " + velikostSouboru + " je větší než vyuzite misto disku.\n" +
                    "Vyuzitelna kapacita disku je " + pevnyDisk.getVyuziteMisto() + " bajtů.");
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