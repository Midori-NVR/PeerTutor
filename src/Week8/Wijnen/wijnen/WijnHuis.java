package Week8.Wijnen.wijnen;

import java.time.LocalDate;

/**
 * PEER opdracht
 * P2W2
 */
public class WijnHuis {
    private static final int MAX_AANTAL = 10;
    private Wijn[] wijnen = new Wijn[MAX_AANTAL];  //voorlopig gevuld met 10 null-objecten
    private String naam;
    private int aantal;

    public WijnHuis(String naam) {
        this.naam = naam;
    }

    public void voegWijnToe(Wijn wijn) {
        if (aantal >= MAX_AANTAL) return;
        if (zoekWijn(wijn)) return;
        wijnen[aantal] = wijn;
        aantal++;
    }

    public boolean zoekWijn(Wijn wijn) {
        for (Wijn invWijn : wijnen) {
            if (invWijn != null && wijn.getNaam().equals(invWijn.getNaam())) return true;
        }
        return false;
    }

    public Wijn getOudsteWijn() {
        if (aantal == 0) return null;
        Wijn oudsteWijn = wijnen[0];
        for (Wijn wijn : wijnen) {
            if (wijn != null && wijn.getOogstDatum().isBefore(oudsteWijn.getOogstDatum())) oudsteWijn = wijn;
        }
        return oudsteWijn;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Wijnhuis %s\n", naam.toUpperCase()));

        StringBuilder wijnenTekst = new StringBuilder();
        StringBuilder champagneTekst = new StringBuilder();
        StringBuilder likeurenTekst = new StringBuilder();

        for (Wijn wijn : wijnen) {
            if (wijn instanceof Likeur) likeurenTekst.append("\t ").append(wijn).append("\n");
            else if (wijn instanceof Champagne) champagneTekst.append("\t ").append(wijn).append("\n");
            else if (wijn != null) wijnenTekst.append("\t ").append(wijn).append("\n");
        }
        result.append("Wijnen:\n").append(wijnenTekst);
        result.append("Champagnes:\n").append(champagneTekst);
        result.append("Likeuren:\n").append(likeurenTekst);
        return result.toString();
    }
}
