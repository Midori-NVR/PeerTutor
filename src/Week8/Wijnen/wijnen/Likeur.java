package Week8.Wijnen.wijnen;

import java.time.LocalDate;

/**
 * PEER opdracht
 * P2W2
 */
public class Likeur extends Wijn{
    private double alcoholGehalte; //in procent


    public Likeur(String naam, String streek, LocalDate oogstDatum, double basisPrijs, double alcoholGehalte) {
        super(naam, streek, oogstDatum, basisPrijs);
        this.alcoholGehalte = alcoholGehalte;
    }

    @Override
    public double berekenPrijs() {
        if(alcoholGehalte >= 0.5) return super.berekenPrijs()*1.25;
        return super.berekenPrijs();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" --> %.0f%% alc",alcoholGehalte*100);
    }
}
