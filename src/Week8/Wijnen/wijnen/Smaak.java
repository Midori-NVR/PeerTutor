package Week8.Wijnen.wijnen;

/**
 * PEER opdracht
 * P2W2
 */
public enum Smaak {
    BRUT("Brut"), EXTRA_BRUT("Extra-brut"), BRUT_SANS_MILLESIME("Brut sans Millésime"),
    SEC("Sec"), DEMI_SEC("Demi-sec"), DOUX("Doux");

    private String naam;
    Smaak(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }
}
