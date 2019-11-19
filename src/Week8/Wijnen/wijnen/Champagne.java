package Week8.Wijnen.wijnen;

import java.time.LocalDate;

/**
 * PEER opdracht
 * P2W2
 */
public class Champagne extends Wijn {
    private Smaak smaak;


    public Champagne(String naam, String streek, LocalDate oogstDatum, double basisPrijs, Smaak smaak) {
        super(naam, streek, oogstDatum, basisPrijs);
        this.smaak = smaak;
    }

    @Override
    public double berekenPrijs() {
        if (smaak.toString().contains("brut")) return super.berekenPrijs()*1.1;
        return super.berekenPrijs();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" --> Type: %s",smaak);
    }
}
