package cz.czechitas.ukol3.model;

public class Pocitac {

    public boolean jeZapnuty = false;
    public boolean procesor = false;
    public boolean pamet = false;
    public boolean disk = false;

    public void isJeZapnuty() {
        if (jeZapnuty == true) {
            System.out.println("Pocitac je zapnuty.");
        } else {
            System.out.println("Pocitac je vypnuty...");
        }
    }

    public void vypniSe() {
        if (jeZapnuty == true) {
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

    public void zapniSe(){
        zjistiExistenciDisku();
        zjistiExistenciPameti();
        zjistiExistenciProcesoru();

        if (jeZapnuty){
            System.err.println("Pocitac je jiz zapnuty");
        }
        else if (disk&&pamet&&procesor){
            jeZapnuty= true;
            System.out.println("Pocitac se zapnul.");
        }
        else {
            System.out.println("Pocitac nema potrebne komponenty.");
        }
    }
}