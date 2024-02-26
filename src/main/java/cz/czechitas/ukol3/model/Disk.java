package cz.czechitas.ukol3.model;

public class Disk {
    private long kapacita;
    private long vyuziteMisto;

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        if (vyuziteMisto > kapacita) {
            System.err.println("Disk nemá dostatečnou kapacitu pro uložení souboru.");
            return;
        } else if (vyuziteMisto < 0) {
            System.err.println("Soubor nelze vymazat. Velikost souboru přesahuje využité místo disku.");
            return;
        }
        this.vyuziteMisto = vyuziteMisto;
    }

    @Override
    public String toString() {
        return "Kapacita pevneho disku je: " + kapacita + "\n" +
                "Vyuzite misto je: " + vyuziteMisto + " bajtu";
    }
}