package cz.czechitas.ukol3.model;

public class Procesor {
    private String vyrobce;
    private long rychlost;


    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }


    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }

    @Override
    public String toString() {
        return "Vyrobce procesoru je: " + vyrobce + "\n" +
                "Rychlost procesoru je: " + rychlost + " Hz";
    }

}
